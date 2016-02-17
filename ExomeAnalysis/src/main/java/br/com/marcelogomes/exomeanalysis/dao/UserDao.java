package br.com.marcelogomes.exomeanalysis.dao;

import br.com.marcelogomes.exomeanalysis.model.User;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author marcelo
 */
@Stateless
public class UserDao extends Dao<Long, User> implements Serializable{
    private static final long serialVersionUID = 1L;


}