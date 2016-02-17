package br.com.marcelogomes.exomeanalysis.dao;

import br.com.marcelogomes.exomeanalysis.model.User;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author marcelo
 */
@Stateless
public class UserDao implements Serializable {
    private static final long serialVersionUID = 1L;
    @PersistenceContext
    private EntityManager em;
    
    public void persiste(User user){
        em.persist(user);
    }

}
