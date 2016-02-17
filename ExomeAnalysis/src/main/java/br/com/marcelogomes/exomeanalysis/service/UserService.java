package br.com.marcelogomes.exomeanalysis.service;

import br.com.marcelogomes.exomeanalysis.dao.UserDao;
import br.com.marcelogomes.exomeanalysis.model.User;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author marcelo
 */
@Stateless
public class UserService implements Serializable {
    private static final long serialVersionUID = 1L;
    @Inject
    private UserDao userDao;
    
    public void persiste(User user){
        userDao.persist(user);
    }

}
