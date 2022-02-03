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

public class test_cascade_persist {

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

            // Creation de plusieurs références
            E_TExCascadeRef ref1 = new E_TExCascadeRef("Ma référence A");
            E_TExCascadeRef ref2 = new E_TExCascadeRef("Ma référence B");
            E_TExCascadeRef ref3 = new E_TExCascadeRef("Ma référence C");

            //Création de plusieurs FK
            E_TExCascadeFk fk1 = new E_TExCascadeFk("TestFKA");
            fk1.setUneRef(ref1);
            E_TExCascadeFk fk2 = new E_TExCascadeFk("TestFKB");
            fk2.setUneRef(ref2);
            E_TExCascadeFk fk3 = new E_TExCascadeFk("TestFKC");
            //commit
            tx.commit();


        } finally {
            session.close();
        }
    }


}