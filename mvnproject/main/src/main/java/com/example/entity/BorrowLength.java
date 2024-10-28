package com.example.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class BorrowLength implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BorrowLengthId;
    private int MaxLength;

	@OneToMany(mappedBy="borrowLength")
	private List<Book> books;

	public int getBorrowLengthId() {
		return this.BorrowLengthId;
	}

	public void setBorrowLengthId(int BorrowLengthId) {
		this.BorrowLengthId = BorrowLengthId;
	}
    
    public int getMaxLength() {
		return this.MaxLength;
	}

	public void setMaxLength(int MaxLength) {
		this.MaxLength = MaxLength;
	}

	public List<Book> getBooks() {
		return this.books;
	}

	public static void createDefaultBorrowLengths(Session session){
		//check if table is empty
		Query query = session.createQuery("select BorrowLengthId from BorrowLength", int.class);
		List list = query.list();

		//if it is not, return
		if (!list.isEmpty()){
			return;
		}

		//if it is, create default borrowLength
		BorrowLength br = new BorrowLength();
		br.setMaxLength(7);

		Transaction t = session.beginTransaction();
		try{
			session.persist(br);
			t.commit();
		}
		catch(Exception e){
			t.rollback();
		}	
	}

	public static int getRandomId(Session session){
		Query query = session.createQuery("select BorrowLengthId from BorrowLength", int.class);
		List list = query.list();

		Random random = new Random();
		int index = random.nextInt(list.size());
		return (int) list.get(index);
	}
}