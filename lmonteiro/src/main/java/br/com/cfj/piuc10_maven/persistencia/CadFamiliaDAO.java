package br.com.cfj.piuc10_maven.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import javax.swing.JOptionPane;

public class CadFamiliaDAO {

    public CadFamilia buscarPorId(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.find(CadFamilia.class, id);
        } finally {
            em.close();
        }
    }

    public void cadastrar(CadFamilia cad) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cad);
            em.getTransaction().commit();
            System.out.println("Cadastro realizado");
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEtityManager();
        }
    }

    public List<CadFamilia> listarTodas() {
        EntityManager em = JPAUtil.getEntityManager();
        List<CadFamilia> familia = null;

        try {
            String textoQuery = "SELECT f FROM CadFamilia f";
            Query consulta = em.createQuery(textoQuery);

            familia = consulta.getResultList();

        } finally {
            JPAUtil.closeEtityManager();
        }
        return familia;
    }

    public List<CadFamilia> pesquisar(String filtroFamilia) {
        EntityManager em = JPAUtil.getEntityManager();
        List familia = null;
        try {
            String textoQuery = "SELECT f FROM CadFamilia f "
                    + "WHERE (:nomeFamilia IS NULL OR f.nomeFamilia LIKE :nomeFamilia)";
            Query consulta = em.createQuery(textoQuery, CadFamilia.class);
            consulta.setParameter("nomeFamilia", filtroFamilia != null && !filtroFamilia.isEmpty() ? "%" + filtroFamilia + "%" : null);
            familia = consulta.getResultList();
        } finally {
            JPAUtil.closeEtityManager();
        }
        return familia;
    }

    public void excluir(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            CadFamilia familia = em.find(CadFamilia.class, id);
            if (familia != null) {
                em.getTransaction().begin();
                em.remove(familia);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEtityManager();
        }
    }

    public void update(CadFamilia cad) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(cad);
            em.getTransaction().commit();

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            JOptionPane.showMessageDialog(null, "Erro ao atualizar");
            throw e;
        } finally {
            em.close();
        }

    }
}
