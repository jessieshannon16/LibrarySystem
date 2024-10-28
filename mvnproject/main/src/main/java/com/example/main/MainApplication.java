package com.example.main;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Author;
import com.example.entity.Book;
import com.example.entity.BorrowLength;
import com.example.entity.Genre;
import com.example.util.HibernateUtil;
import com.example.util.Response;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@SpringBootApplication
@RestController
public class MainApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
		// com.example.population.Populator.populate();
	}

	private static <T> List<T> loadAllData(Class<T> type, Session session) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(type);
		criteria.from(type);
		List<T> data = session.createQuery(criteria).getResultList();
		return data;
  }

	@GetMapping(value="/author")
	public String author(){
		Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            List<Author> authors = loadAllData(Author.class,session);
            if (authors != null) {
				System.out.println("Authors found");
				
				String result = "";
				for(Author author:authors){
					result += author.toString();
				}

				return result;
            } 
			else {
                System.out.println("Author not found!");
				return "Error";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        } finally {
            session.close();
        }
	}

	@GetMapping(value="/author",params="id")
	public String author(@RequestParam(name="id") String id){
		Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            Author author = session.get(Author.class, id);
            if (author != null) {
                System.out.println("Author details: " + author.getFirstName() + " " + author.getLastName());
				return author.toString();
            } else {
                System.out.println("Author not found!");
				return "Error";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        } finally {
            session.close();
        }
	}

	@GetMapping("/book")
	public String book(){
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
            List<Book> books = loadAllData(Book.class,session);
			if(books != null){
				System.out.println("Books found");
				
				String result = "";
				for(Book book:books){
					result += book.toString();
				}
				return result;
			}
			else{
				return "Error";
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return "Error";
		}
		finally {
            session.close();
        }
	}

	@GetMapping(value="/book",params="id")
	public String book(@RequestParam(name="id") String id){
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
            Book book = session.get(Book.class,id);
			if(book != null){
				System.out.println("Book found");

				return book.toString();
			}
			else{
				return "Error";
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return "Error";
		}
		finally {
            session.close();
        }
	}

	@GetMapping("/genre")
	public String genre(){
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
            List<Genre> genres = loadAllData(Genre.class,session);
			if(genres != null){
				System.out.println("Genres found");
				
				String result = "";
				for(Genre genre:genres){
					result += genre.toString();
				}
				return result;
			}
			else{
				return "Error";
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return "Error";
		}
		finally {
            session.close();
        }
	}

	@GetMapping(value="/genre",params="id")
	public String genre(@RequestParam(name="id") String id){
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
            Genre genre = session.get(Genre.class,id);
			if(genre != null){
				System.out.println("Genre found");

				return genre.toString();
			}
			else{
				return "Error";
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return "Error";
		}
		finally {
            session.close();
        }
	}

	@GetMapping(value="/result")
	public List<Response> response(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Response> responses = new ArrayList<>();

		try {
            List<Book> books = loadAllData(Book.class,session);
			if(books != null){
				System.out.println("Books found");
				
				
				for(Book book:books){
					Response currResponse = new Response();
					currResponse.setIsbn(book.getBookIsbn());
					currResponse.setTitle(book.getTitle());
					currResponse.setBlurb(book.getBlurb());
					currResponse.setImg(book.getImg());

					Author author = book.getBookAuthorMappings().get(0).getAuthor();
					currResponse.setAuthorName(author.getFirstName() + " " + author.getLastName());

					Genre genre = book.getGenre();
					currResponse.setGenre(genre.getName());

					BorrowLength bl = book.getBorrowLength();
					currResponse.setBorrowLength(bl.getMaxLength());

					responses.add(currResponse);

				}
				return responses;
			
			}
			else{
				return responses;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally {
            session.close();
        }
	}
}

