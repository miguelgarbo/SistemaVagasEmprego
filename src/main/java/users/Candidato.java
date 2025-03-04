package users;

import items.Vaga;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Candidato extends Usuario {
    private String areaInteresse;
    private String formacao;
    private static List<Candidato> listaCandidatos = new ArrayList<>();


    Scanner sc = new Scanner(System.in);

    public Candidato(String nome, String email, String telefone, String areaInteresse, String formacao) {
        super(nome, email, telefone);
        this.areaInteresse = areaInteresse;
        this.formacao = formacao;

    }


    public void adicionarCandidato(Candidato candidato){

        this.listaCandidatos.add(candidato);
        System.out.println("Candidato Adicionado Com Sucesso !");
    }

    public String getAreaInteresse() {
        return areaInteresse;
    }

    public void setAreaInteresse(String areaInteresse) {
        this.areaInteresse = areaInteresse;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public List<Candidato> getListaCandidatos() {
        return listaCandidatos;
    }

    public void setListaCandidatos(List<Candidato> listaCandidatos) {
        this.listaCandidatos = listaCandidatos;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Área de Interesse: " + areaInteresse);
        System.out.println("Formação: " + formacao);
    }

    public void visualizarVagas(List<Vaga> vagasPublicadas) {
        if (vagasPublicadas.isEmpty()) {
            System.out.println("Não há vagas disponíveis no momento.");
        } else {
            System.out.println("== Vagas Disponíveis == ");
            for (int i = 0; i < vagasPublicadas.size(); i++) {
                System.out.println((i + 1) + " ||" + vagasPublicadas.get(i));
            }
        }
    }

    public Candidato formularioCandidato() {

        System.out.println("Informe Seu Nome");
        String nomeCandidato = sc.nextLine();

        System.out.println("Email: ");
        String emailCandidato = sc.nextLine();

        System.out.println("Telefone: ");
        String telefoneCandidato = sc.nextLine();

        System.out.println("Area de  Interesse: ");
        String areaCandidato = sc.nextLine();

        System.out.println("Formação(ões): ");
        String formacaoCandidato = sc.nextLine();

        Candidato candidatoNovo = new Candidato(nomeCandidato, emailCandidato, telefoneCandidato, areaCandidato, formacaoCandidato);
        this.listaCandidatos.add(candidatoNovo);
        return candidatoNovo;
    }

    public void inscreverVaga(List<Vaga> vagasPublicadas, int indice) {

        if (indice >= 1 && indice <= vagasPublicadas.size()) {
            Vaga vaga = vagasPublicadas.get(indice - 1);

           Candidato candidatoNovo = formularioCandidato();

           vaga.inscreverCandidato(candidatoNovo);

            System.out.println("Candidato inscrito com sucesso na vaga: " + vaga.getTitulo());
        } else {
            System.out.println("Índice de vaga inválido.");
        }
    }
}
