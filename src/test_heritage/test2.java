package test_heritage;

import entite.E_TExCascadeFk;
import entite.E_TExCascadeRef;
import entite.E_TMembre_TEST;
import entite.E_TParticulier_TEST;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class test2 {
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

            // GET un habitant quelque soit son type
            E_TMembre_TEST membre= session.load(E_TMembre_TEST.class,1);
            System.out.println(membre.getNomMembre());

            //GET un pro dans un membre
            System.out.println("Pro Test");
            E_TMembre_TEST pro= session.load(E_TMembre_TEST.class,2);
            System.out.println(pro.toString());

            //GET un particulier dans un membre
            System.out.println("Particulier Test");
            E_TMembre_TEST p= session.load(E_TMembre_TEST.class,6);
            System.out.println(p.toString());

            //GET un particulier dans un membre
            System.out.println("Particulier Test");
            E_TParticulier_TEST p2= session.load(E_TParticulier_TEST.class,6);
            System.out.println(p.toString());

        } finally {
            session.close();
        }
    }

}
