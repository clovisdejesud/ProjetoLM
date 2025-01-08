package br.com.cfj.piuc10_maven.persistencia;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import br.com.cfj.piuc10_maven.persistencia.CadIndividuo;
import br.com.cfj.piuc10_maven.persistencia.CadIndividuoDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Helper {
    public static boolean validarData(String data) {
       
        String regex = "\\d{2}/\\d{2}/\\d{4}";
        if (!data.matches(regex)) {
            return false;
        }

        try {
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            sdf.parse(data);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }


    public void carregarDadosIndividuo(DefaultTableModel model) {
        CadIndividuoDAO dao = new CadIndividuoDAO();
        List<CadIndividuo> listaIndividuo = dao.listarTodas();
        preencherTabelaIndividuo(model, listaIndividuo);
    }

    public void carregarDadosFamilia(DefaultTableModel model) {
        CadFamiliaDAO dao = new CadFamiliaDAO();
        List<CadFamilia> listaFamilia = dao.listarTodas();
        preencherTabelaFamilia(model, listaFamilia);
    }

    public static void preencherTabelaIndividuo(DefaultTableModel model, List<CadIndividuo> listaIndividuo) {
        model.setRowCount(0);

        for (CadIndividuo ind : listaIndividuo) {
            int idade = CadIndividuo.calcularIdade(ind.getDataNasc());

            model.addRow(new Object[]{
                ind.getId(),
                ind.getNome(),
                ind.getCpf(),
                idade,
                ind.getTelefone(),
                ind.getNomeFamilia(),
                ind.getEscolaridade(),
                ind.getTrabalha(),
                ind.getObs()
            });
        }
    }

    public static void preencherTabelaFamilia(DefaultTableModel model, List<CadFamilia> listaFamilia) {
        model.setRowCount(0);

        for (CadFamilia f : listaFamilia) {
            model.addRow(new Object[]{
                f.getId(),
                f.getNomeFamilia(),
                f.getNrFamilia(),
                f.getEndereco(),
                f.getObs()
            });

        }
    }
}
