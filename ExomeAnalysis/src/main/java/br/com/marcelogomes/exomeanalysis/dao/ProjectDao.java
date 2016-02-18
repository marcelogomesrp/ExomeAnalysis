package br.com.marcelogomes.exomeanalysis.dao;

import br.com.marcelogomes.exomeanalysis.model.Project;
import br.com.marcelogomes.exomeanalysis.model.ProjectState;
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
        return this.findAll();
        //Query query = em.createQuery("SELECT p from Project");
        //return query.getResultList();
        /*
        String jpql = "SELECT p FROM Project p WHERE p.projectState = :projectState";
        Map<String,Object> parameters = new HashMap<String, Object>();
        parameters.put("projectState", ProjectState.processed);
        List<Project> lista =  this.findBy(jpql, parameters);
        System.out.println("Lista: " + lista.size());
        return lista;
        */
    }
    
    
    
}
