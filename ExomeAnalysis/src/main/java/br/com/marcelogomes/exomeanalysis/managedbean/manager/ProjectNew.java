package br.com.marcelogomes.exomeanalysis.managedbean.manager;

import br.com.marcelogomes.exomeanalysis.model.Project;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marcelo Gomes de Paula
 */
@Named(value = "projectNew")
@RequestScoped
public class ProjectNew {
    private Project project = new Project();

    /**
     * Creates a new instance of ProjectNew
     */
    public ProjectNew() {
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    
    public void save(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Project saved"));
    }
    
}
