package com.termlex;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DataService {

    int lastUsedId = 1000;
    EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction et;

    public DataService(){
    	//Initializing necessary parameters
    	emf=Persistence.createEntityManagerFactory("termlex");
        em=emf.createEntityManager();
        et=em.getTransaction();
        //storing some terms
        saveTerm("First term");
        saveTerm("Second term");
        saveTerm("Another term");
        saveTerm("Miscellaneous term");
        saveTerm("");
    }

    public String getTermForId(int id){
    	if(!et.isActive()) et.begin();
        TermsData td=em.find(TermsData.class, id);
        String str=td.getTerm();
        em.flush();
        return str;
    }

    public void saveTerm(String term){
    	if(!et.isActive()) et.begin();
    	//checking for already stored terms
        Query q=em.createQuery("select t.term from termdata t");
        @SuppressWarnings("unchecked")
		List <String> l=q.getResultList();
        for(String d:l) {
        	if(term.equals(d)) {
        		em.flush();
        		return;
        	}
        }
        //avoiding null terms
        if(term.equals("")) {
        	em.flush();
        	return;
        }
        //storing term
        TermsData td=new TermsData();
        int key=lastUsedId + getAllTerm().size()+1;
    	td.setId(key);
    	td.setTerm(term);
    	em.persist(td);
    	em.flush();
    	et.commit();
    }

    @SuppressWarnings("unchecked")
	public Collection<TermsData> getAllTerm(){
    	if(!et.isActive()) et.begin();
        Query q=em.createQuery("select t from termdata t");
        List<TermsData> l=q.getResultList();
        em.flush();
        return l;
    }
}
