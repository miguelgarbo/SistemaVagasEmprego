package SistemaVagasEmprego;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import items.Vaga;
import users.Candidato;
import users.Empresa;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        Empresa empresa = new Empresa("Microsoft", "contato@microsoft.com", "123456789", "São Paulo");
        Candidato candidato = new Candidato("Miguel", "miguel@gmail.com", "987654321", "Desenvolvimento Back End", "Engenharia de Software");

        empresa.publicarVaga();

        do {
            System.out.println("\n== Menu Candidato ==");
            System.out.println("0 - Cadastro de Empresas");
            System.out.println("1 - Visualizar Vagas");
            System.out.println("2 - Inscrever-se em uma Vaga");
            System.out.println("3 - Sair");

            opcao = sc.nextInt();

            switch (opcao) {

                case 0 :
                    System.out.println("== CADASTRO DE EMPRESAS== ");

                    System.out.println("Informe o Nome da Empresa");
                    String nomeEmpresaInformado = sc.nextLine();

                    System.out.println("Email:");
                    String emailEmpresaInformado = sc.nextLine();

                    System.out.println("Telefone:");
                    String telefoneEmpresaInformado = sc.nextLine();

                    System.out.println("Localidade:");
                    String localidadeEmpresaInformado = sc.nextLine();

                    Empresa empresaCadastrada = new Empresa(nomeEmpresaInformado,emailEmpresaInformado, telefoneEmpresaInformado,localidadeEmpresaInformado);
                    System.out.print("Empresa Cadastrada Com Sucesso: ");
                    empresaCadastrada.exibirInformacoes();

                    break;

                case 1:
                    candidato.visualizarVagas(empresa.getVagasPublicadas());
                    break;

                case 2:

                    candidato.visualizarVagas(empresa.getVagasPublicadas());
                    System.out.print("Informe o índice da vaga para se inscrever: ");
                    int indice = sc.nextInt();
                    candidato.inscreverVaga(empresa.getVagasPublicadas(), indice);
                    break;

                case 3:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

    }while(opcao !=3);
}
}
