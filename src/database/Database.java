package database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Database {
	
	private static Database instance = null;
	public static Database getInstance(){
		if (instance == null){
			instance = new Database();
		}
		return instance;
	}
	
	
	private SessionFactory sessionFactory = null;
	private StandardServiceRegistry registry = null;
	private Session session = null;
	
	private Database(){
		registry = new StandardServiceRegistryBuilder()
				.configure("database/hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
				.build();
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		session = sessionFactory.openSession();
	}
	
	public void close(){
		session.close();
		StandardServiceRegistryBuilder.destroy( registry );
	}
	
	public <T> void save(T entity){
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
	}
	
	public <T> void remove(T entity){
		session.beginTransaction();
		session.remove(entity);
		session.getTransaction().commit();
	}
	
	public <T> List<T> getAll(Class<T> entry){
		session.beginTransaction();
		List<T> listFromDb = session.createQuery("from " + entry.getName()).list();
		session.getTransaction().commit();
		
		return listFromDb;
	}
	
}
