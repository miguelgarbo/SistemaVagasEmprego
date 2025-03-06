package SistemaVagasEmprego;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import items.EStatusVaga;
import items.Vaga;
import users.Candidato;
import users.Empresa;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcaoMenu;

        Empresa empresa = new Empresa();
        Candidato candidato = new Candidato();
        Vaga vaga = new Vaga();

        do {
            System.out.println("==MENU==");
            System.out.println("1 - Entrar Como Candidato");
            System.out.println("2 - Entrar Como Empresa");
            System.out.println("3 - Sair");
            opcaoMenu = sc.nextInt();

            if (opcaoMenu ==1){
                System.out.println("==MENU CANDIDATO==");
                System.out.println("1 - Visualizar Vagas Disponiveis");
                System.out.println("2 - Inscrever-se em uma Vaga");
                System.out.println("3 - Se Cadastrar como Candidato");
                System.out.println("4 - Voltar");
                int opcaoCandidato = sc.nextInt();

                switch (opcaoCandidato){

                    case 1:

                        candidato.visualizarVagas(empresa.getVagasPublicadas());
                        break;
                    case 2:

                        candidato.visualizarVagas(empresa.getVagasPublicadas());// printa as vagas
                        System.out.print("Informe o índice da vaga para se inscrever: "); //pega o indice para selecionar a vaga escolhida
                        int indice = sc.nextInt();
                        candidato.inscreverVaga(empresa.getVagasPublicadas(), indice);
                        break;

                    case 3:

                        Candidato candidatoCadastrado = candidato.formularioCandidato();
                        candidato.salvarCandidatoSistema(candidatoCadastrado);

                        break;

                    case 4:

                        System.out.println("Voltando..");
                        break;

                    default:

                        System.out.println("Opcao Invalida");
                }


            } else if (opcaoMenu==2) {

                System.out.println("==MENU EMPRESA==");
                System.out.println("1 - Cadastrar Empresas");
                System.out.println("2 - Visualizar Vagas");
                System.out.println("3 - Publicar Vaga");
                System.out.println("4 - Sair");
                int opcaoEmpresa = sc.nextInt();

                switch (opcaoEmpresa) {

                    case 1:
                        Empresa empresaCadastrada = empresa.cadastraEmpresaNova();
                        empresa.adicionarEmpresaLista(empresaCadastrada);
                        break;

                    case 2:
                        candidato.visualizarVagas(empresa.getVagasPublicadas());
                        System.out.println("1 - Selecionar Vaga || 2 - Voltar...");
                        int umDois = sc.nextInt();
                        if (umDois == 1){

                            System.out.println("Informe o Indice da Vaga: ");
                            int indiceVagaInformada = sc.nextInt();

                            if (indiceVagaInformada >=1 && indiceVagaInformada<= empresa.getVagasPublicadas().size()){

                                Vaga vagaSelecionada = empresa.getVagasPublicadas().get(indiceVagaInformada-1);
                                System.out.println("Vaga Selecionada: "+ vagaSelecionada.getTitulo() +"|| Empresa"+ vagaSelecionada.getNomeEmpresa().getNome());

                                System.out.println("Informe o indice do Candidato Escolhido: ");
                                int indiceCandidato = sc.nextInt();

                                empresa.selecionarCandidatoParaVaga(indiceCandidato,vagaSelecionada);
                            }
                        }
                        break;

                    case 3:

                        Empresa empresaSelecionada = empresa.escolherEmpresaParaPublicarVaga();
                        empresa.publicarVaga(empresaSelecionada);

                        break;

                    case 4:

                        System.out.println("Voltando");
                        break;

                    default:

                        System.out.println("Opcao Invalida");

                }

            }

    }while(opcaoMenu !=3);
}
}
