package database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

/**
 * The type Database. Used
 */
public class Database {
	
	private static Database instance = null;
	
	/**
	 * Get instance database. Used here Singleton is defined for making sure that there is only one instance of class
	 * Database. We don't need couple of instances of this class. Also this helps getting instance from anywhere.
	 *
	 * @return instance of database
	 */
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
	
	/**
	 * Close session of connection to database.
	 */
	public void close(){
		session.close();
		StandardServiceRegistryBuilder.destroy( registry );
	}
	
	/**
	 * Save or update entity to database.
	 *
	 * @param <T>    type to save
	 * @param entity entity to save
	 */
	public <T> void save(T entity){
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
	}
	
	/**
	 * Remove entity from database.
	 *
	 * @param <T>    type to save
	 * @param entity entity to save
	 */
	public <T> void remove(T entity){
		session.beginTransaction();
		session.remove(entity);
		session.getTransaction().commit();
	}
	
	/**
	 * Get all entities of class specified in parameter.
	 *
	 * @param <T>   type to save
	 * @param entry entity to save
	 * @return the list of all entities in database of specified type
	 */
	public <T> List<T> getAll(Class<T> entry){
		session.beginTransaction();
		List<T> listFromDb = session.createQuery("from " + entry.getName()).list();
		session.getTransaction().commit();
		
		return listFromDb;
	}
	
}
