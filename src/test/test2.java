package test;

import entite.E_TCategorie;
import entite.E_TCompetence;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;

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
            //création catégorie
            Transaction tx = null ;
            tx = session.beginTransaction();
            E_TCategorie cat1 = new E_TCategorie("dons surnaturels");
            session.save(cat1);
            //création compétences
            E_TCompetence comp1 = new E_TCompetence("voyance",cat1);
            E_TCompetence comp2 = new E_TCompetence("magie",cat1);
            E_TCompetence comp3 = new E_TCompetence("telekinesie",cat1);
            session.save(comp1);
            session.save(comp2);
            session.save(comp3);

            tx.commit();

        } finally {
            session.close();
        }
    }


}