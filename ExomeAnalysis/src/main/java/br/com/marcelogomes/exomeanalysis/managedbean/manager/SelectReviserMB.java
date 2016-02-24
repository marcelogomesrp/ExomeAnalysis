package br.com.marcelogomes.exomeanalysis.managedbean.manager;

import br.com.marcelogomes.exomeanalysis.model.Project;
import br.com.marcelogomes.exomeanalysis.model.User;
import br.com.marcelogomes.exomeanalysis.service.ProjectService;
import br.com.marcelogomes.exomeanalysis.service.ReviserService;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author marcelo
 */
@Named(value = "selectReviserMB")
@RequestScoped
public class SelectReviserMB implements Serializable{
    @Inject
    private ProjectService projectService;
    @Inject
    private ReviserService reviserService;
    private Project project;
    private List<User> listUnselectReviser;
    private List<User> listSelectReviser;
    

    /**
     * Creates a new instance of SelectReviserMB
     */
    public SelectReviserMB() {
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<User> getListUnselectReviser() {
        return reviserService.findUnselectedByProject(project);
    }

    public void setListUnselectReviser(List<User> listUnselectReviser) {
        this.listUnselectReviser = listUnselectReviser;
    }

    public List<User> getListSelectReviser() {
        //return reviserService.findSelectedByProject(project);
        return projectService.findReviserInProject(project);
    }

    public void setListSelectReviser(List<User> listSelectReviser) {
        this.listSelectReviser = listSelectReviser;
    }
    
    
    
    public String showPage(Project project){
        this.project = project;
        return "select_reviser";
    }
    
}
