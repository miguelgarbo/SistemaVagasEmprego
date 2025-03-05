package items;

import users.Candidato;
import users.Empresa;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Vaga {
    private String titulo;
    private double salario;
    private String requisitos;
    private String descricao;
    private Empresa nomeEmpresa;
    private List<Candidato> candidatosInscritos = new ArrayList<>();

    public Empresa getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(Empresa nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public List<Candidato> getCandidatosInscritos() {
        return candidatosInscritos;
    }


    public void setCandidatosInscritos(List<Candidato> candidatosInscritos) {
        this.candidatosInscritos = candidatosInscritos;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Vaga(String titulo, double salario, String requisitos, String descricao, Empresa nomeEmpresa) {
        this.titulo = titulo;
        this.salario = salario;
        this.requisitos = requisitos;
        this.descricao = descricao;
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getSalario() {
        return salario;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public String getdescricao() {
        return descricao;
    }

    public void inscreverCandidato(Candidato candidato) {
        this.candidatosInscritos.add(candidato);
    }

    public void exibirInformaçoes() {

        System.out.println("Título: " + titulo + "\nSalário: R$ " + salario + "\nRequisitos: " + requisitos + "\nDescrição: " + this.getdescricao()+ "\nEmpresa: "+ this.nomeEmpresa.getNome());
        for (int i = 0;i<candidatosInscritos.size();i++){

            System.out.println("Candidatos Incritos: ");
            System.out.println("Indice: "+ (i+1));
            candidatosInscritos.get(i).exibirInformacoes();
        }
    }
}
