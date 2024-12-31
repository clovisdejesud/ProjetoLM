package br.com.cfj.piuc10_maven.persistencia;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import br.com.cfj.piuc10_maven.persistencia.CadIndividuo;
import br.com.cfj.piuc10_maven.persistencia.CadIndividuoDAO;

public class Helper {

    public void carregarDadosIndividuo(DefaultTableModel model) {
        CadIndividuoDAO dao = new CadIndividuoDAO();
        List<CadIndividuo> listaIndividuo = dao.listarTodas();
        preencherTabelaIndividuo(model, listaIndividuo);
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
}
