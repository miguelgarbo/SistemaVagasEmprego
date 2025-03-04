package items;

import users.Candidato;

import java.util.ArrayList;
import java.util.List;

public class Vaga {
    private String titulo;
    private double salario;
    private String requisitos;
    private String areaInteresse;

    public List<Candidato> getCandidatosInscritos() {
        return candidatosInscritos;
    }

    public void setCandidatosInscritos(List<Candidato> candidatosInscritos) {
        this.candidatosInscritos = candidatosInscritos;
    }

    public void setAreaInteresse(String areaInteresse) {
        this.areaInteresse = areaInteresse;
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

    private List<Candidato> candidatosInscritos;

    public Vaga(String titulo, double salario, String requisitos, String areaInteresse) {
        this.titulo = titulo;
        this.salario = salario;
        this.requisitos = requisitos;
        this.areaInteresse = areaInteresse;
        this.candidatosInscritos = new ArrayList<>();
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

    public String getAreaInteresse() {
        return areaInteresse;
    }

    public void inscreverCandidato(Candidato candidato) {
        candidatosInscritos.add(candidato);
    }

    @Override
    public String toString() {
        return "Título: " + titulo + "\nSalário: R$ " + salario + "\nRequisitos: " + requisitos + "\nÁrea de Interesse: " + areaInteresse;
    }
}
