package br.com.marcelogomes.exomeanalysis.service;

import br.com.marcelogomes.exomeanalysis.dao.VariantDao;
import br.com.marcelogomes.exomeanalysis.model.Project;
import br.com.marcelogomes.exomeanalysis.model.Variant;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author marcelo
 */
@Stateless
public class VariantService implements Serializable {
    private static final long serialVersionUID = 1L;
    @Inject
    private VariantDao variantDao;
    
    public List<Variant> findByProject(Project project){
        return variantDao.findByProject(project);
    }

    public void selectVariant(Variant variant) {
        variant.setSelected(true);
        variantDao.merge(variant);
    }
    
    public void unselectVariant(Variant variant){
        variant.setSelected(false);
        variantDao.merge(variant);
    }

    public List<Variant> findByProjectUnselected(Project project) {
        return variantDao.findByProjectSelected(project, false);
    }
    
    public List<Variant> findByProjectSelected(Project project) {
        return variantDao.findByProjectSelected(project, true);
    }
    
}
