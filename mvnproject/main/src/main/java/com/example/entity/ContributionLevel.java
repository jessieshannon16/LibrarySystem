package com.example.entity;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class ContributionLevel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ContributionLevelId;
    private String Level;

	@OneToMany(mappedBy="contributionLevel")
	private List<BookAuthorMapping> bookAuthorMappings;
	

	public int getContributionLevelId() {
		return this.ContributionLevelId;
	}

	public void setContributionLevelId(int ContributionLevelId) {
		this.ContributionLevelId = ContributionLevelId;
	}

	public String getLevel() {
		return this.Level;
	}

	public void setLevel(String Level) {
		this.Level = Level;
	}

	
	public List<BookAuthorMapping> getBookAuthorMappings() {
		return this.bookAuthorMappings;
	}

	public static void createDefaults(Session session){
		//check if table is empty
		Query query = session.createQuery("select ContributionLevelId from ContributionLevel", int.class);
		List list = query.list();

		//if it is not, return
		if (!list.isEmpty()){
			return;
		}

		ContributionLevel cl1 = new ContributionLevel();
		ContributionLevel cl2 = new ContributionLevel();
		cl1.setLevel("Author");
		cl2.setLevel("Publisher");

		Transaction t = session.beginTransaction();
		try{
			session.persist(cl1);
			session.persist(cl2);
			t.commit();
		}
		catch(Exception e){
			t.rollback();
		}	
	}
}