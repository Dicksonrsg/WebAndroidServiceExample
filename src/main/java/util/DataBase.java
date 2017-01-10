
package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataBase {
    private static DataBase singleton = new DataBase();
    private static EntityManager em;

    private DataBase() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConexaoDB");
        em = emf.createEntityManager();
    }

    public static DataBase getInstance() {
        return singleton;
    }

    public EntityManager getEntityManager() {
        return em;
    }
}
