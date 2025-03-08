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
    
    public Empresa empresaCadastradaDefault(){

        Empresa empresaCadastrada = new Empresa("Samsung","comercial@samsung.com", "11 982383284", "sao paulo - sp");
        return empresaCadastrada;
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
        System.out.println("Vagas Publicadas: ");
        for(int i = 0;i<this.vagasPublicadas.size();i++){

            System.out.println("Vaga: "+ (i+1));
            System.out.println(vagasPublicadas.get(i).getTitulo()+" , ");

        }
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

    public Empresa escolherEmpresaParaEditarVaga() {
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

                Empresa empresaSelected = listaEmpresas.get(indiceInformado - 1);
                System.out.println("Empresa Selecionada: " + empresaSelected.getNome());
                return empresaSelected;
            } else {
                System.out.println("Esse Indice Não existe..");
                return null;
            }
        }
    }
    public void visualizarVagasPorEmpresaSelecionada(Empresa empresaSelected){
        if (empresaSelected != null) {
            List<Vaga> vagasDaEmpresa = empresaSelected.getVagasPublicadas();
            if (vagasDaEmpresa.isEmpty()) {
                System.out.println("Nenhuma vaga publicada por esta empresa.");
            } else {
                System.out.println("Vagas publicadas por " + empresaSelected.getNome() + ":");
                for (int i = 0;i < vagasDaEmpresa.size();i++) {
                    Vaga vaga = vagasDaEmpresa.get(i);
                    System.out.println("Índice || " + (i+1));
                    System.out.println("- " + vaga.getTitulo() + ": " + vaga.getDescricao());
                }
            }
        } else {
            System.out.println("Empresa selecionada é inválida.");
        }
    }

    public Vaga selecionarVagaPorIndice(Empresa empresaSelected, int indice){
        if (empresaSelected != null) {
            List<Vaga> vagasDaEmpresa = empresaSelected.getVagasPublicadas();
            if (indice >= 0 && indice < vagasDaEmpresa.size()) {
                return vagasDaEmpresa.get(indice);
            } else {
                System.out.println("Índice inválido. Por favor, selecione um índice válido.");
                return null;
            }
        } else {
            System.out.println("Empresa selecionada é inválida.");
            return null;
        }
    }


    public void editarVagaPorIndice(Empresa empresaSelected, int indice) {
        if (empresaSelected != null) {
            List<Vaga> vagasDaEmpresa = empresaSelected.getVagasPublicadas();
            if (indice >= 0 && indice < vagasDaEmpresa.size()) {
                Vaga vaga = vagasDaEmpresa.get(indice);

                System.out.println("Editando a vaga: " + vaga.getTitulo() + " - " + vaga.getDescricao());
                sc.nextLine();//para desbugar.
                System.out.print("Novo título: ");
                String novoTitulo = sc.nextLine();
                System.out.print("Nova descrição: ");
                String novaDescricao = sc.nextLine();

                vaga.setTitulo(novoTitulo);
                vaga.setDescricao(novaDescricao);

                System.out.println("Vaga editada com sucesso!");
            } else {
                System.out.println("Índice inválido. Por favor, selecione um índice válido.");
            }
        } else {
            System.out.println("Empresa selecionada é inválida.");
        }
    }


    public void publicarVaga(Empresa empresaSelecionada) {
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
        adicionarVagaPublicadaPorEmpresa(novaVaga,empresaSelecionada);
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

    public void adicionarVagaPublicadaPorEmpresa(Vaga vaga ,Empresa empresaNome){
        empresaNome.vagasPublicadas.add(vaga);
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
        sc.nextLine();

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

    public void visualizarEmpresasCadastradas(){
        int i = 0;
        for (Empresa empresa : this.getListaEmpresas()){

            System.out.println("EMPRESA:"+ (i+1));
            this.getListaEmpresas().get(i).exibirInformacoes();
            i++;
        }
    }
    public void excluirVagaPorIndice(int indice) {
        if (indice >= 0 && indice < vagasPublicadas.size()) {
            Vaga vagaRemovida = vagasPublicadas.remove(indice);
            System.out.println("Vaga removida com sucesso: " + vagaRemovida.getTitulo());
        } else {
            System.out.println("Índice inválido. Por favor, selecione um índice válido.");
        }
    }
    public void excluirEmpresaPorIndice(int indice) {
        if (indice >= 0 && indice < listaEmpresas.size()) {
            Empresa empresaRemovida = listaEmpresas.remove(indice);
            System.out.println("Empresa removida com sucesso: " + empresaRemovida.getNome());
        } else {
            System.out.println("Índice inválido. Por favor, selecione um índice válido.");
        }
    }
}
