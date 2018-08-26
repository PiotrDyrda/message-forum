package model;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.Collections;
import java.util.List;

class MessageRepository {

    public List<Message> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Query query = session.createQuery("from Message m");

            List<Message> messages = query.getResultList();

            tx.commit();
            return messages;
        } catch (Exception e) {
            tx.rollback();
            return Collections.emptyList();
        } finally {
            session.close();
        }
    }

    public Message save(Message message) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(message);
            tx.commit();
            return message;
        } catch (Exception e) {
            tx.rollback();
            return null;
        } finally {
            session.close();
        }
    }
}
