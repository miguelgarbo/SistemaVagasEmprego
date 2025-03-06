package users;

import items.Vaga;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Candidato extends Usuario {
    private String descricao;
    private String formacao;
    private List<Candidato> listaCandidatosCadastrados = new ArrayList<>();


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Candidato> getListaCandidatosCadastrados() {
        return listaCandidatosCadastrados;
    }

    public void setListaCandidatosCadastrados(List<Candidato> listaCandidatosCadastrados) {
        this.listaCandidatosCadastrados = listaCandidatosCadastrados;
    }

    Scanner sc = new Scanner(System.in);

    public Candidato(String nome, String email, String telefone, String descricao, String formacao) {
        super(nome, email, telefone);
        this.descricao = descricao;
        this.formacao = formacao;

    }

    public Candidato(){}

    public String getdescricao() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }


    @Override
    public void exibirInformacoes() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("Email: " + this.getEmail());
        System.out.println("Telefone: " + this.getTelefone());
        System.out.println("Descrição: " + this.getdescricao());
        System.out.println("Formação: " +this.getFormacao());
        System.out.println("//////////////////////////////\n");
    }

    public void visualizarVagas(List<Vaga> vagasPublicadas) {
        if (vagasPublicadas.isEmpty()) {
            System.out.println("Não há vagas disponíveis no momento.");
        } else {
            System.out.println("== Vagas Disponíveis == ");
            for (int i = 0; i < vagasPublicadas.size(); i++) {
                System.out.print((i + 1) + " || ");
                vagasPublicadas.get(i).exibirInformaçoes();
                System.out.println("///////////////////////////\n");
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
        return candidatoNovo;
    }

    public void  salvarCandidatoSistema(Candidato candidatoCadastrado){

        this.getListaCandidatosCadastrados().add(candidatoCadastrado);
        System.out.println("Candidato Cadastrado No Sistema Com Sucesso");
    }


    public Candidato cadastradoOuNao(){

            System.out.println("Candidatos Cadastrados:");

            for (int i = 0;i<this.getListaCandidatosCadastrados().size();i++){

                System.out.println("Indice: "+(i+1));
                getListaCandidatosCadastrados().get(i).exibirInformacoes();
            }

            System.out.println("Informe o seu Indice de Candidato Cadastrado: ");
            int indiceCandidatoCadastrado = sc.nextInt();

            if (indiceCandidatoCadastrado >= 1 && indiceCandidatoCadastrado<= this.getListaCandidatosCadastrados().size()){

                Candidato candidatoSelecionado = this.getListaCandidatosCadastrados().get(indiceCandidatoCadastrado-1);
                System.out.println("Candidato Selecionado: "+ candidatoSelecionado.getNome());
                return candidatoSelecionado;

            }else {

                System.out.println("Esse indice esta errado! ");
            }

        return null;
    }

    public void inscreverVaga(List<Vaga> vagasPublicadas, int indice, boolean isCadastrado) {

        if (isCadastrado==false){
            if (indice >= 1 && indice <= vagasPublicadas.size()) {
                Vaga vaga = vagasPublicadas.get(indice - 1);

                Candidato candidatoNovo = formularioCandidato();// aqui retorna o candidato novo

                vaga.inscreverCandidato(candidatoNovo);

                System.out.println("Candidato inscrito com sucesso na vaga: " + vaga.getTitulo());
            } else {
                System.out.println("Índice de vaga inválido.");
            }

        }else {

            if (indice >= 1 && indice <= vagasPublicadas.size()) {
                Vaga vaga = vagasPublicadas.get(indice - 1);

                Candidato candidatoNovo = cadastradoOuNao();// aqui retorna o candidato novo

                vaga.inscreverCandidato(candidatoNovo);

                System.out.println("Candidato inscrito com sucesso na vaga: " + vaga.getTitulo());
            } else {
                System.out.println("Índice de vaga inválido.");
            }
        }


    }
}
