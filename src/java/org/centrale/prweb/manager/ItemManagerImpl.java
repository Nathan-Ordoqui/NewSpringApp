/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.prweb.manager;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.centrale.prweb.items.Item;

/**
 *
 * @author Kevin
 */
public class ItemManagerImpl implements ItemManager{
    
    private EntityManagerFactory emf;
    private static ItemManagerImpl theItemManager;

    public ItemManagerImpl() {
        if (emf == null){
            // Create the factory
            emf = Persistence.createEntityManagerFactory("MySpringAppPU");
            // Clear cache
            emf.getCache().evictAll();
        }
    }

    public static ItemManager getInstance(){
        if (theItemManager == null){
            theItemManager = new ItemManagerImpl();
        }
        return theItemManager;
    }
    
    @Override
    public Collection<Item> page(){
        EntityManager em = emf.createEntityManager();
        Query queryProductsByName = em.createNamedQuery("Item.findAll", Item.class);
        Collection theList = queryProductsByName.getResultList();
        return theList;
    }
            
    
}
