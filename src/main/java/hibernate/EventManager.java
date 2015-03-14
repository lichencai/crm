package hibernate;

import hibernate.entity.Event;
import hibernate.util.HibernateUtil;

import java.util.Date;

import org.hibernate.Session;

public class EventManager {
	public static void main(String[] args) {
        EventManager mgr = new EventManager();

        
        mgr.createAndStoreEvent("My Event", new Date());

        HibernateUtil.getSessionFactory().close();
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
