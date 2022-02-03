package test_cascade;

import entite.E_TCategorie;
import entite.E_TCompetence;
import entite.E_TExCascadeRef;
import entite.E_TExCascadeFk;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import test_cascade.E_ref;

import javax.persistence.metamodel.EntityType;

public class test_cascade_remove {

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

            // GET REF 11 : "Ma référence"
            E_TExCascadeRef ref = session.load(E_TExCascadeRef.class,11); // ou load a la place de get
            System.out.println(ref.getLibRef());

            //delete la ref
            session.remove(ref);
            tx.commit();


        } finally {
            session.close();
        }
    }


}