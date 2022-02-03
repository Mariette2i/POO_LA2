package test;

import entite.E_TCategorie;
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

            //System.out.println("Récupérer catégorie");
            //E_TCategorie cat = session.get(E_TCategorie.class,13); // ou load a la place de get
            //System.out.println(cat.getCategorie());

            /*
            System.out.println("Création d'une catégorie");
            Transaction tx = null ;
            tx = session.beginTransaction();
            E_TCategorie cat1 = new E_TCategorie("Aaaaa");
            session.save(cat1);
            tx.commit();
            */

            //suppression
            Transaction tx = null ;

            System.out.println("Suppression catégorie");
            tx = session.beginTransaction();
            E_TCategorie c = session.get(E_TCategorie.class, 71);
            if (c != null) {
                session.remove(c); }
            tx.commit();



        } finally {
            session.close();
        }
    }


}
