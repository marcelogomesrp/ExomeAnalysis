package br.com.marcelogomes.exomeanalysis.managedbean.general;

import br.com.marcelogomes.exomeanalysis.managedbean.UserMB;
import br.com.marcelogomes.exomeanalysis.model.User;
import br.com.marcelogomes.exomeanalysis.service.UserService;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author marcelo
 */
@Named(value = "signInMB")
@RequestScoped
public class SignInMB {
    @Inject 
    private UserMB userMB;
    @Inject
    private UserService userService;

    public User getUser() {
        return userMB.getUser();
    }

    public void setUser(User user) {
        userMB.setUser(user);
    }
    
    public SignInMB() {
    }
    
    public String doLogin(){
        System.out.println("MB: " + this.getUser().toString());
        User user = userService.validLogin(this.getUser());
        userMB.setUser(user);
        if(user != null){
            if(user.isAdministrator())
                return "/administrator/index";
            if(user.isManager())
                return "/manager/index";
            if(user.isReviser())
                return "/reviser/index";
        }
        return "/general/sign_in";
    }
    
}
