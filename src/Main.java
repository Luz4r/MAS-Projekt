import models.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
	public static void main(String[] args) {
		StandardServiceRegistry registry = null;
		SessionFactory sessionFactory = null;
		
		try {
			registry = new StandardServiceRegistryBuilder()
					.configure() // configures settings from hibernate.cfg.xml
					.build();
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			
			Instructor ins1 = new Instructor("Piotr", "Franiula", "789456123",
					"pio.fra@gmail.com", LocalDate.of(1971, 6, 13),
					4000.0d, Stream.of("15:00 - 20:00").collect(Collectors.toSet()), true);
			Instructor ins2 = new Instructor("Jan", "Kowalski", "456123789",
					"jan.kow@gmail.com", LocalDate.of(1984, 4, 17),
					3000.0d, Stream.of("12:00 - 19:00").collect(Collectors.toSet()), false);
			
			
			
			
			// Save to DB
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(ins1);
			session.save(ins2);
			session.getTransaction().commit();
			session.close();
			
			// Read from DB
			session = sessionFactory.openSession();
			session.beginTransaction();
			List<Instructor> instructorsFromDb = session.createQuery( "from Instructor" ).list();
			
			for (Instructor instructor:
				 instructorsFromDb) {
				System.out.println(instructor.getInstructorType());
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
