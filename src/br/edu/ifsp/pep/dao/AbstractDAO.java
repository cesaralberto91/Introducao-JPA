package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.Produto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aluno
 */
public abstract class AbstractDAO<T> {

    private EntityManagerFactory emf;

    public AbstractDAO() {
        emf = Persistence
                .createEntityManagerFactory("aula1PU");
    }

    protected EntityManager getEntityManager() {
        return this.emf.createEntityManager();
    }

    public void inserir(T entity) {
        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();

        em.close();
    }

    public void alterar(T entity) {
        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();

        em.close();
    }

}
