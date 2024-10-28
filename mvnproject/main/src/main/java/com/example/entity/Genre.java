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
public class Genre implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int GenreId;
    private String Name;

	@OneToMany(mappedBy="genre")
	private List<Book> books;

	public int getGenreId() {
		return this.GenreId;
	}

	public void setGenreId(int GenreId) {
		this.GenreId = GenreId;
	}

	public String getName() {
		return this.Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	
	public List<Book> getBooks() {
		return this.books;
	}

	@Override
	public String toString(){
		return this.Name;
	}

	public static int getOrCreateGenre(String genre, Session session){
		Transaction t;
		int genreId = 1;
		Query query = session.createQuery("select GenreId from Genre where Name = '" + genre + "'", int.class);
		List list = query.list();

		if (!list.isEmpty()){
			genreId = (int) query.uniqueResult();
			return genreId;
		}
		else{
			t = session.beginTransaction();
			try{
			
				Query queryInsert = session.createNativeQuery("insert into Genre(Name) values (?1)");
				queryInsert.setParameter(1, genre);
				queryInsert.executeUpdate();
				t.commit();
				Query queryId = session.createQuery("select GenreId from Genre where Name = '" + genre + "'", int.class);
				genreId = (int) queryId.uniqueResult();
				return genreId;
			}
		
			catch(Exception e){
				t.rollback();
				return genreId;
			}
		}
	}
}