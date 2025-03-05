package users;

import items.EStatusVaga;
import items.Vaga;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empresa extends Usuario {
    private String localidade;
    private List<Vaga> vagasPublicadas;
    private List<Empresa> listaEmpresas = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public void adicionarEmpresa(Empresa empresa){

        this.listaEmpresas.add(empresa);
        System.out.println("Empresa Adicionada Com Sucesso !");
    }

    public List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }

    public void setListaEmpresas(List<Empresa> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }


    public Empresa(String nome, String email, String telefone, String localidade) {
        super(nome, email, telefone);
        this.localidade = localidade;
        this.vagasPublicadas = new ArrayList<>();
        this.listaEmpresas = new ArrayList<>();
    }

    public Empresa() {
        this.listaEmpresas = new ArrayList<>();
        this.vagasPublicadas = new ArrayList<>(); // Agora a lista de vagas também é inicializada
    }


    @Override
    public void exibirInformacoes() {
        System.out.println("Nome da Empresa: " + this.getNome());
        System.out.println("Email: " + this.getEmail());
        System.out.println("Telefone: " + this.getTelefone());
        System.out.println("Localidade: " + this.getLocalidade());
    }

    public Empresa escolherEmpresaParaPublicarVaga() {

        if (listaEmpresas.isEmpty()) {

            System.out.println("Não Há Empresas Cadastradas");
            return null;

        } else {

            System.out.println("Informe o Indice da Empresa para Acessa-la: ");
            for (int i = 0; i < listaEmpresas.size(); i++) {

                Empresa empresa = listaEmpresas.get(i);

                System.out.println("INDICE: " + (i + 1));
                System.out.println("Nome Empresa: " + empresa.getNome());
            }
            int indiceInformado = sc.nextInt();

            if (indiceInformado >= 1 && indiceInformado <= listaEmpresas.size()) {

                Empresa empresaSelecionda = listaEmpresas.get(indiceInformado - 1);
                System.out.println("Empresa Selecionada: " + empresaSelecionda.getNome());
                return empresaSelecionda;
            }else{
                System.out.println("Esse Indice Não existe..");
                return null;
            }
        }
    }

    public Vaga publicarVaga(Empresa empresaSelecionada) {
        Scanner sc = new Scanner(System.in);
        System.out.println("== Publicar Vaga ==");

        System.out.print("Título da Vaga: ");
        String titulo = sc.nextLine();

        System.out.print("Salário da Vaga: ");
        double salario = sc.nextDouble();
        sc.nextLine();

        System.out.print("Requisitos (separe por vírgula): ");
        String requisitos = sc.nextLine();

        System.out.print("Descrição: ");
        String descricao = sc.nextLine();

        Vaga novaVaga = new Vaga(titulo, salario, requisitos, descricao, empresaSelecionada, EStatusVaga.ATIVA);
        adicionarVagaPublicada(novaVaga);
        return novaVaga;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public void setVagasPublicadas(List<Vaga> vagasPublicadas) {
        this.vagasPublicadas = vagasPublicadas;
    }

    public List<Vaga> getVagasPublicadas() {
        return vagasPublicadas;
    }

    public void adicionarVagaPublicada(Vaga vaga){
        this.vagasPublicadas.add(vaga);
        System.out.println("Vaga Publicada Com Sucessooo!");
    }

    public void selecionarCandidatoParaVaga(int indice, Vaga vagaescolhida){

        List<Candidato> listaCandidatosVaga = vagaescolhida.getCandidatosInscritos();
        if(indice >=1 && indice<= listaCandidatosVaga.size()){

            Candidato candidatoEscolhido = listaCandidatosVaga.get(indice-1);
            System.out.println("Candidato Efetivado Para a Vaga: "+ candidatoEscolhido.getNome());
            vagaescolhida.setStatusVaga(EStatusVaga.INATIVA);
            System.out.println("Status da Vaga: "+ vagaescolhida.getStatusVaga());

        }else {

            System.out.println("Esse Indice Não corresponde a algum de nossos candidatos inscritos.");
        }
    }



    public Empresa cadastraEmpresaNova(){

        System.out.println("== CADASTRO DE EMPRESAS== ");

        System.out.println("Informe o Nome da Empresa: ");
        String nomeEmpresaInformado = sc.nextLine();

        System.out.println("Email:");
        String emailEmpresaInformado = sc.nextLine();

        System.out.println("Telefone:");
        String telefoneEmpresaInformado = sc.nextLine();

        System.out.println("Localidade:");
        String localidadeEmpresaInformado = sc.nextLine();

        Empresa empresaCadastrada = new Empresa(nomeEmpresaInformado,emailEmpresaInformado, telefoneEmpresaInformado,localidadeEmpresaInformado);
        empresaCadastrada.exibirInformacoes();
        System.out.print("Empresa Cadastrada Com Sucesso: ");
     return empresaCadastrada;
    }
    public void adicionarEmpresaLista(Empresa empresaNova){

        this.listaEmpresas.add(empresaNova);

        System.out.println(" Adicionada A lista de Empresas Com Sucesso!! ");
    }

}
