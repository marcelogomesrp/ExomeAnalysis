/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.marcelogomes.exomeanalysis.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    
    public List<T> findByQueryParameters(String jpql, Map<String,Object> parameters){
        Query query = em.createQuery(jpql);
        if(parameters != null){
            for (String key : parameters.keySet()) {
                query.setParameter(key, parameters.get(key));
            }
        }
        return query.getResultList();
    }
}
