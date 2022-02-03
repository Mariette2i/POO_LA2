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

public class test_cascade1 {

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
            E_TExCascadeFk uneFk = session.load(E_TExCascadeFk.class,2); // ou load a la place de get
            System.out.println(uneFk.getLibFk());

            // GET REF
            E_TExCascadeRef uneRef = session.load(E_TExCascadeRef.class,2); // ou load a la place de get
            System.out.println(uneRef.getLibRef());

           // Creation ref
           E_TExCascadeRef refCreate = new E_TExCascadeRef("Ma référence 2");
           session.save(refCreate);
          // tx.commit();


           //Creation FK avec la ref create en cascade
         //   tx = session.beginTransaction();
            E_TExCascadeFk deuxFk = new E_TExCascadeFk("TestFK2");
            deuxFk.setUneRef(refCreate);
            session.save(deuxFk);
            tx.commit();


        } finally {
            session.close();
        }
    }


}