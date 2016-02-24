package br.com.marcelogomes.exomeanalysis.dao;

import br.com.marcelogomes.exomeanalysis.model.Project;
import br.com.marcelogomes.exomeanalysis.model.ProjectState;
import br.com.marcelogomes.exomeanalysis.model.User;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author marcelo
 */
@Stateless
public class ProjectDao extends Dao<Long, Project> implements Serializable{
    private static final long serialVersionUID = 1L;

    public List<Project> findByState(ProjectState projectState) {
        Query query = em.createQuery("SELECT p from Project p  WHERE p.projectState = :projectState" );
        query.setParameter("projectState", ProjectState.uploaded);
        return query.getResultList();
    }

    public List<Project> findByState(ProjectState projectState, User manager) {
        Query query = em.createQuery("SELECT p from Project p  WHERE p.projectState = :projectState AND p.manager = :manager" );
        query.setParameter("projectState", projectState);
        query.setParameter("manager", manager);
        return query.getResultList();
    }
    
    public List<User> findReviserinProject(Long id){
        Query query;
        query = em.createQuery("SELECT p.listRevisers from Project p WHERE p.id = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }
    
    
    
}
