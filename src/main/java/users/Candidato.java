package users;

import items.ESenioridade;

public class Candidato extends Usuario {

    private String experiencia;
    private String areaInteresse;
    private String formacao;

    public Candidato(String nome, String email, String telefone, String experiencia, String areaInteresse, String formacao) {
        super(nome, email, telefone);
        this.experiencia = experiencia;
        this.areaInteresse = areaInteresse;
        this.formacao = formacao;
    }


    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getAreaInteresse() {
        return areaInteresse;
    }

    public void setAreaInteresse(String areaInteresse) {
        this.areaInteresse = areaInteresse;
    }

}
