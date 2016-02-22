package br.com.marcelogomes.exomeanalysis.dao;

import br.com.marcelogomes.exomeanalysis.model.Profile;
import br.com.marcelogomes.exomeanalysis.model.Project;
import br.com.marcelogomes.exomeanalysis.model.User;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author marcelo
 */
@Stateless
public class UserDao extends Dao<Long, User> implements Serializable{
    private static final long serialVersionUID = 1L;

    public User findByEmailPassword(String email, String password) {
        Query query = em.createQuery("SELECT u from User u  WHERE active = true AND u.email = :email AND u.password = :password", User.class );
        query.setParameter("email", email);
        query.setParameter("password", password);
        List<User> results = query.getResultList();
        if (results.isEmpty()) return null;
        else if (results.size() == 1) return results.get(0);
        throw new NonUniqueResultException();
    }




}