package br.com.marcelogomes.exomeanalysis.service;

import br.com.marcelogomes.exomeanalysis.dao.UserDao;
import br.com.marcelogomes.exomeanalysis.model.Profile;
import br.com.marcelogomes.exomeanalysis.model.Project;
import br.com.marcelogomes.exomeanalysis.model.User;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author marcelo
 */
@Stateless
public class ReviserService implements Serializable {
    private static final long serialVersionUID = 1L;
    @Inject
    private UserDao userDao;
    
    public List<User> findSelectedByProject(Project project){
        return userDao.findAll();
       // return userDao.findByProfileProjectSelect(Profile.reviser, project, true);
    }
    
    public List<User> findUnselectedByProject(Project project){
        return userDao.findAll();
       // return userDao.findByProfileProjectSelect(Profile.reviser, project, false);
    }
    
}
