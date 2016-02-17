package br.com.marcelogomes.exomeanalysis.managedbean.general;

import br.com.marcelogomes.exomeanalysis.model.User;
import br.com.marcelogomes.exomeanalysis.service.UserService;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author marcelo
 */
@Named(value = "userAddMB")
@RequestScoped
public class userAddMB implements Serializable {
    @Inject
    private UserService userService;
    private User user = new User();

    public userAddMB() {
    }
    
    public void persiste(){
        userService.persiste(user);
        this.user = new User();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario adicionado com sucesso"));
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
