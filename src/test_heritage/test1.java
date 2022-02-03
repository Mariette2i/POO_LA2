package test_heritage;

import entite.E_TExCascadeFk;
import entite.E_TExCascadeRef;
import entite.E_TMembre_TEST;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class test1 {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {

            // Creation transaction
            Transaction tx = null ;
            tx = session.beginTransaction();

            // GET FK
            E_TMembre_TEST membre= session.load(E_TMembre_TEST.class,1);
            System.out.println(membre.getNomMembre());
            tx.commit();

        } finally {
            session.close();
        }
    }

}
