package br.com.marcelogomes.exomeanalysis.managedbean.manager;

import br.com.marcelogomes.exomeanalysis.managedbean.UserMB;
import br.com.marcelogomes.exomeanalysis.model.Project;
import br.com.marcelogomes.exomeanalysis.service.ProjectService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import javax.inject.Inject;

/**
 *
 * @author marcelo
 */
@Named(value = "proccessedMB")
//@RequestScoped
@ViewScoped
public class ProccessedMB implements Serializable {
    private static final long serialVersionUID = 1L;
    @Inject
    private ProjectService projectService;
    @Inject
    private UserMB userMB;
    private List<Project> listProject = new ArrayList<Project>();

    public List<Project> getListProject() {
        return listProject;
    }

    public void setListProject(List<Project> listProject) {
        this.listProject = listProject;
    }
    
    public void updateList(){
        listProject = projectService.findAllProccessed(userMB.getUser());
    }

    public ProccessedMB() {
    }
    
}
