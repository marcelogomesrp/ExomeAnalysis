package br.com.marcelogomes.exomeanalysis.service;

import br.com.marcelogomes.exomeanalysis.dao.ProjectDao;
import br.com.marcelogomes.exomeanalysis.dao.UserDao;
import br.com.marcelogomes.exomeanalysis.dao.VariantDao;
import br.com.marcelogomes.exomeanalysis.model.Project;
import br.com.marcelogomes.exomeanalysis.model.ProjectState;
import br.com.marcelogomes.exomeanalysis.model.User;
import br.com.marcelogomes.exomeanalysis.model.Variant;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author marcelo
 */
@Stateless
public class ProjectService implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final File TARGET_FOLDER = new File("c:\\Temp");

    @Inject
    private ProjectDao projectDao;
    @Inject
    private VariantDao variantDao;
    @Inject
    private UserDao userDao;

    public void save(Project project) {
        projectDao.persist(project);
    }

    public void save(Project project, InputStream inputstream) {
        project.setProjectState(ProjectState.uploaded);
        this.save(project);
        this.saveFile(inputstream, project);
    }

    public void saveFile(InputStream inputStream, Project project) {
        try {
            File arquivoLocal = new File(TARGET_FOLDER, project.getId().toString());
            OutputStream out = new FileOutputStream(arquivoLocal);
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            inputStream.close();
            out.flush();
            out.close();
            processFile(arquivoLocal, project);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Asynchronous
    public void processFile(File fileName, Project project) {
        BufferedReader buffRead;
        try {
            FileReader fileReader = new FileReader(fileName);
            buffRead = new BufferedReader(fileReader);
            String linha;
            while ((linha = buffRead.readLine()) != null) {
                if (!linha.startsWith("#")) {
                    System.out.println("Gravado...");
                    Variant variant = new Variant();
                    variant.setProject(project);
                    String[] valores = linha.split("\\s+");

                    variant.setChromosome(valores[0]);
                    variant.setPosition(valores[1]);
                    variant.setIdentifier(valores[2]);
                    variant.setReference(valores[3]);
                    variant.setAlternate(valores[4]);
                    variant.setQuality(valores[5]);
                    variant.setFilter(valores[6]);
                    //variant.setAdditionalInformation(valores[7]);
                    //variant.setAnalise(analise);

                    variantDao.persist(variant);
                } else {
                    System.out.println("pulado é comentario");
                }
            }
            buffRead.close();
            fileReader.close();
            //Thread.sleep(10000);
            project.setProjectState(ProjectState.processed); 
        } catch (Exception ex) {
            project.setProjectState(ProjectState.processing_error);
        }
        projectDao.merge(project);
    }

    public List<Project> findAllUploaded() {
        return projectDao.findByState(ProjectState.uploaded);
    }

    public List<Project> findAllProccessed(User user) {
        return projectDao.findByState(ProjectState.processed, user);
    }
    
    public List<User> findReviserInProject(Project project){
        return projectDao.findReviserinProject(project.getId());
    }
    //findNotInProject
    
    public void addReviserInProject(Project project, User reviser){
        projectDao.addReviserInProject(project, reviser);
    }
    
    public List<User> findReviserNotInProject(Project project){
        return userDao.findNotInProject(project.getId());
    }

}
