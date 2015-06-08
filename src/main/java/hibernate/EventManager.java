package hibernate;

import hibernate.entity.Event;
import hibernate.util.HibernateUtil;

import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.Session;

public class EventManager {
	
	private static Logger logger = null;
	
	static {
		System.setProperty("log4j.configuration", "exceptionDemo/log4j.properties");
		logger = Logger.getLogger(EventManager.class);
	}
	
	public static void main(String[] args) {
		
		
		logger.debug("fsdfds");
		logger.error("adfsadsf");
        /*EventManager mgr = new EventManager();

        
        mgr.createAndStoreEvent("My Event", new Date());

        HibernateUtil.getSessionFactory().close();*/
    }

    private void createAndStoreEvent(String title, Date theDate) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Event theEvent = new Event();
        theEvent.setTitle(title);
        theEvent.setDate(theDate);
        session.save(theEvent);

        session.getTransaction().commit();
    }
}
