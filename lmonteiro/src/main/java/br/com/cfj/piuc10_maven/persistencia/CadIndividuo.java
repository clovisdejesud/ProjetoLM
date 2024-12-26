package br.com.cfj.piuc10_maven.persistencia;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Date;

@Entity
public class CadIndividuo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String nome;
    private String cpf;
    private Date dataNasc;
    private String telefone;
    private String nomeFamilia;
    private String escolaridade;
    private String trabalha;
    private String obs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNomeFamilia() {
        return nomeFamilia;
    }

    public void setNomeFamilia(String nomeFamilia) {
        this.nomeFamilia = nomeFamilia;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getTrabalha() {
        return trabalha;
    }

    public void setTrabalha(String trabalha) {
        this.trabalha = trabalha;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public static int calcularIdade(Date dataNasc) {
        if (dataNasc == null) {
            return 0;
        }
        
        java.util.Calendar dataSis  = java.util.Calendar.getInstance();
        java.util.Calendar dataNascimento = java.util.Calendar.getInstance();
        dataNascimento.setTime(dataNasc);
        
        int idade = dataSis.get(java.util.Calendar.YEAR) - dataNascimento.get(java.util.Calendar.YEAR);
        
        if (dataSis.get(java.util.Calendar.MONTH) < dataNascimento.get(java.util.Calendar.MONTH)
                || dataSis.get(java.util.Calendar.MONTH) == dataNascimento.get(java.util.Calendar.MONTH)
                && dataSis.get(java.util.Calendar.DAY_OF_MONTH) < dataNascimento.get(java.util.Calendar.DAY_OF_MONTH)){
            idade--;
        }
        return idade;
    }

}
