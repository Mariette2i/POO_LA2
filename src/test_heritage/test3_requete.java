package test_heritage;

import entite.E_TMembre;
import entite.E_TMembre_TEST;
import entite.E_TParticulier_TEST;
import entite.E_TTransaction;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class test3_requete {
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

            //Requête pour récupérer le nom de tout les pros
            final String strQuery = "SELECT m.nomMembre FROM E_TMembre m "
                    + "WHERE m.typeMembre = :type" ;
            Query query = session.createQuery(strQuery);
            query.setParameter("type", "PRO");
            List<String> employees = query.getResultList();
            System.out.println(employees);

            //Requête pour récupérer tout les membres PART
            final String strQuery2 = "SELECT m FROM E_TMembre m "
                    + "WHERE m.typeMembre = :type" ;
            Query query2 = session.createQuery(strQuery2);
            query2.setParameter("type", "PRO");
            List<E_TMembre> mb_list = query2.getResultList();
            System.out.println(mb_list.toString());

            //recherche de transactions pour un membre bénéficiaire pour lequel vous connaissez le nom et le prénom
            /*SQL : SELECT ID_TRANSACTION FROM T_TRANSACTION t, T_MEMBRE m WHERE t.ID_MEMBRE_BENEFICIAIRE=m.ID_MEMBRE AND m.PRENOM_MEMBRE="ROSITA"*/
            /*final String strQuery = "SELECT idTransaction FROM E_TTransaction t, E_TMembre m"
                    + "WHERE t." +
                    " t.id = :type" ;
            Query query = session.createQuery(strQuery);
            query.setParameter("type", "PRO");
            List<String> employees = query.getResultList();
            System.out.println(employees);*/

            //GET Transactions
            // GET FK
            /*E_TTransaction t= session.load(E_TTransaction.class,1);
            System.out.println(membre.getNomMembre());*/

        } finally {
            session.close();
        }
    }

}
