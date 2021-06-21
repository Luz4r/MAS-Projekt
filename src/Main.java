import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDate;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		StandardServiceRegistry registry = null;
		SessionFactory sessionFactory = null;
		
		try {
			registry = new StandardServiceRegistryBuilder()
					.configure() // configures settings from hibernate.cfg.xml
					.build();
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			
			System.out.println("Created movies:");
			var movie1 = new Movie("Terminator 1", LocalDate.of(1984, 10,26), Movie.MovieCategory.SciFi);
			var movie2 = new Movie("Terminator 3", LocalDate.of(2003, 8,8), Movie.MovieCategory.SciFi);
			
			System.out.println(movie1);
			System.out.println(movie2);
			System.out.println("Created actors:");
			var actor1 = new Actor("Arnold", "Schwarzenegger", LocalDate.of(1947, 7, 30));
			var actor2 = new Actor("Claire", "Danes", LocalDate.of(1979, 4, 12));
			var actor3 = new Actor("Kristanna", "Loken", LocalDate.of(1979, 10, 8));
			
			actor1.setUrls(List.of("http://www.schwarzenegger.com/", "https://pl.pinterest.com/schwarzenegger/", "https://www.facebook.com/arnold"));
			actor1.setAddress(new Address("12989 Chalon Rd", "Los Angeles", "CA 90049"));
			
			System.out.println(actor1);
			System.out.println(actor2);
			System.out.println(actor3);
			
			movie2.addActor(actor1);
			movie2.addActor(actor2);
			movie2.addActor(actor3);
			
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(movie1);
			session.save(movie2);
			session.save(actor1);
			session.save(actor2);
			session.save(actor3);
			session.getTransaction().commit();
			session.close();
			
			System.out.println("\nMovies and actors from the db:");
			
			session = sessionFactory.openSession();
			session.beginTransaction();
			List<Movie> moviesFromDb = session.createQuery( "from Movie" ).list();
			for ( var movie : moviesFromDb) {
				System.out.println(movie);
			}
			List<Actor> actorsFromDb = session.createQuery( "from Actor" ).list();
			for ( var actor : actorsFromDb) {
				System.out.println(actor);
				System.out.println(actor.getUrls());
			}
			session.getTransaction().commit();
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
		finally {
			if (sessionFactory != null) {
				sessionFactory.close();
				sessionFactory = null;
			}
		}
	}
}
