package br.com.marcelogomes.exomeanalysis.dao;

import br.com.marcelogomes.exomeanalysis.model.Project;
import br.com.marcelogomes.exomeanalysis.model.Variant;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author marcelo
 */
@Stateless
public class VariantDao extends Dao<Long, Variant> implements Serializable{
    private static final long serialVersionUID = 1L;

    public List<Variant> findByProject(Project project) {
        Query query = em.createQuery("SELECT v FROM Variant v WHERE v.project = :project", Variant.class);
        query.setParameter("project", project);
        return query.getResultList();
    }

    public List<Variant> findByProjectSelected(Project project, boolean selected) {
        Query query = em.createQuery("SELECT v FROM Variant v WHERE v.project = :project AND v.selected = :selected", Variant.class);
        query.setParameter("project", project);
        query.setParameter("selected", selected);
        return query.getResultList();
    }
    
}
