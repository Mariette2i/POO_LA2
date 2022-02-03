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

public class test_cascade_refresh {

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

            // création d'une référence
            E_TExCascadeRef refCreate = new E_TExCascadeRef("Je veux la refresh");
            session.save(refCreate);
            tx.commit();
            System.out.println(refCreate.getLibRef());

            //Pause pour changer manuellement la valeur
            System.out.println("Attente avec le mode debug, changement manuel de la valeur");

            //Ré afficher la valeur de la ref
           // session.refresh(refCreate);
            System.out.println(refCreate.getLibRef());

        } finally {
            session.close();
        }
    }


}