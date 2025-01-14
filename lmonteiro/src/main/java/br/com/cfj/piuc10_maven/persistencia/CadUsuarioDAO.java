package br.com.cfj.piuc10_maven.persistencia;

import jakarta.persistence.EntityManager;

public class CadUsuarioDAO {

    public void cadastrarUsuario(CadUsuario cadUser) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cadUser);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEtityManager();
        }
    }

    public int recuperarIdPorLogin(String login) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT u.id FROM CadUsuario u WHERE u.login = :login", Integer.class)
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao recuperar ID do usuário: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public boolean verificarLoginIgual(String login) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            String jpql = "SELECT COUNT(u) FROM CadUsuario u WHERE u.login = :login";
            Long count = em.createQuery(jpql, Long.class)
                    .setParameter("login", login)
                    .getSingleResult();
            return count > 0;
        } finally {
            JPAUtil.closeEtityManager();
        }
    }
}
