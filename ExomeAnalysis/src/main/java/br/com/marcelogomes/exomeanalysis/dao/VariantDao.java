package br.com.marcelogomes.exomeanalysis.dao;

import br.com.marcelogomes.exomeanalysis.model.Variant;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author marcelo
 */
@Stateless
public class VariantDao extends Dao<Long, Variant> implements Serializable{
    private static final long serialVersionUID = 1L;
    
}
