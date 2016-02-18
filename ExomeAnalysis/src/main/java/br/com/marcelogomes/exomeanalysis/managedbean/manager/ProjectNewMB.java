package br.com.marcelogomes.exomeanalysis.managedbean.manager;

import br.com.marcelogomes.exomeanalysis.model.Project;
import br.com.marcelogomes.exomeanalysis.service.ProjectService;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Marcelo Gomes de Paula
 */
@Named(value = "projectNewMB")
@RequestScoped
public class ProjectNewMB implements Serializable {
    private static final long serialVersionUID = 1L;

    private Project project = new Project();
    private UploadedFile uploadedFile;
    @Inject
    private ProjectService projectService;

    /**
     * Creates a new instance of ProjectNew
     */
    public ProjectNewMB() {
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public void save() {
        File arquivoLocal = null;
        try {
            projectService.save(project, uploadedFile.getInputstream());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Project saved " ));
            this.project = new Project();
        } catch (IOException ex) {
            Logger.getLogger(ProjectNewMB.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("An error occorred"));
        }
    }
}
