package br.com.cfj.piuc10_maven.persistencia;

import jakarta.persistence.EntityManager;

public class SenhasDAO {

    public void cadastrarSenha(Senhas senha) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(senha);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new IllegalArgumentException("Erro ao cadastrar senha");
        } finally {
            em.close();
        }
    }

    public Senhas buscarSenhaPorLogin(String login) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            String jpql = "SELECT s FROM Senhas s WHERE s.id_usuario = (SELECT u.id FROM CadUsuario u WHERE u.login = :login)";
            return em.createQuery(jpql, Senhas.class)
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro!");
        } finally {
            em.close();
        }
    }
}
