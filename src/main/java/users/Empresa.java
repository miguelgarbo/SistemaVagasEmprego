package users;

import items.Vaga;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empresa extends Usuario {
    private String localidade;
    private List<Vaga> vagasPublicadas;
    private List<Empresa> listaEmpresas;


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
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Nome da Empresa: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Localidade: " + localidade);
    }

    public Vaga publicarVaga() {
        Scanner sc = new Scanner(System.in);
        System.out.println("== Publicar Vaga ==");

        System.out.print("Título da Vaga: ");
        String titulo = sc.nextLine();

        System.out.print("Salário da Vaga: ");
        double salario = sc.nextDouble();
        sc.nextLine();

        System.out.print("Requisitos (separe por vírgula): ");
        String requisitos = sc.nextLine();

        System.out.print("Área de Interesse: ");
        String areaInteresse = sc.nextLine();

        Vaga novaVaga = new Vaga(titulo, salario, requisitos, areaInteresse);
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
}
