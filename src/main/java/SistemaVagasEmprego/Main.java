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

        do {
            System.out.println("\n== Menu ==");
            System.out.println("0 - Cadastro de Empresas");
            System.out.println("1 - Visualizar Vagas");
            System.out.println("2 - Inscrever-se em uma Vaga");
            System.out.println("3 - Publicar Vaga");
            System.out.println("4 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 0 :
                  Empresa empresaCadastrada =  empresa.cadastraEmpresaNova();
                  empresa.adicionarEmpresaLista(empresaCadastrada);

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

                    Empresa empresaSelecionada = empresa.escolherEmpresaParaPublicarVaga();
                    empresa.publicarVaga(empresaSelecionada);

                    break;

                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

    }while(opcao !=4);
}
}
