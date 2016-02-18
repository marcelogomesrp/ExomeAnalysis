package br.com.marcelogomes.exomeanalysis.managedbean.manager;

import br.com.marcelogomes.exomeanalysis.model.Project;
import br.com.marcelogomes.exomeanalysis.service.ProjectService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author marcelo
 */
@Named(value = "uploadedMB")
@RequestScoped
public class UploadedMB implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Project> listProjects = new ArrayList<Project>();
    @Inject
    private ProjectService projectService;

    /**
     * Creates a new instance of uploadedMB
     */
    public UploadedMB() {
    }
    
    public void updateListProjects(){
        this.listProjects = projectService.findAllUploaded();
    }

    public List<Project> getListProjects() {
        //return listProjects;
        System.out.println("Get---");
        for(Project p: projectService.findAllUploaded()){
            System.out.println("---> " + p.getId() + p.getName());
        }
        return projectService.findAllUploaded();
    }

    public void setListProjects(List<Project> listProjects) {
        this.listProjects = listProjects;
    }
    
    
    
}
