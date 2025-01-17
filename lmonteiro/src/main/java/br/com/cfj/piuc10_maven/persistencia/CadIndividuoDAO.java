package br.com.cfj.piuc10_maven.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import javax.swing.JOptionPane;

public class CadIndividuoDAO {

    public CadIndividuo buscarPorId(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(CadIndividuo.class, id);
        } finally {
            em.close();
        }
    }

    public void cadastrar(CadIndividuo cad) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cad);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEtityManager();
        }
    }

    public List<CadIndividuo> listarTodas() {
        EntityManager em = JPAUtil.getEntityManager();
        List<CadIndividuo> individuo = null;

        try {
            String textoQuery = "SELECT i FROM CadIndividuo i";
            Query consulta = em.createQuery(textoQuery);

            individuo = consulta.getResultList();

        } finally {
            JPAUtil.closeEtityManager();
        }
        return individuo;
    }

    public List<CadIndividuo> pesquisar(String filtroIndividuo) {
        EntityManager em = JPAUtil.getEntityManager();
        List individuo = null;
        try {
            String textoQuery = "SELECT i FROM CadIndividuo i "
                    + "WHERE (:nome IS NULL OR i.nome LIKE :nome)";
            Query consulta = em.createQuery(textoQuery, CadIndividuo.class);
            consulta.setParameter("nome", filtroIndividuo != null && !filtroIndividuo.isEmpty() ? "%" + filtroIndividuo + "%" : null);
            individuo = consulta.getResultList();
        } finally {
            JPAUtil.closeEtityManager();
        }
        return individuo;
    }

    public void excluir(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            CadIndividuo i = em.find(CadIndividuo.class, id);
            if (i != null) {
                em.getTransaction().begin();
                em.remove(i);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEtityManager();
        }
    }

    public void update(CadIndividuo cad) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(cad);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            throw e;
        } finally {
            em.close();
        }
    }
}
