package br.com.marcelogomes.exomeanalysis.managedbean;

import br.com.marcelogomes.exomeanalysis.model.User;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author marcelo
 */
@Named(value = "userMB")
@SessionScoped
public class UserMB implements Serializable {
    private static final long serialVersionUID = 1L;
    private User user = new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
