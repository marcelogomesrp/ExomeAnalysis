/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marcelogomes.exomeanalysis.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author marcelo
 */
public class Dao<Pk, T> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @PersistenceContext
    protected EntityManager em;

    public Dao() {
    }

    public void persist(T entity){
        em.persist(entity);
    }
    public void merge(T entity){
        em.merge(entity);
    }
    
    public T getById(Pk pk){
        return (T) em.find(getTypeClass(), pk);
    }
    
    public void remove(T entity){
        em.remove(entity);
    }
    
    public List<T> findAll(){
        return em.createQuery(("FROM " + getTypeClass().getName())).getResultList();
    }
    
    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }
}
