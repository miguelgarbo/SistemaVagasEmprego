package SistemaVagasEmprego;
import java.util.Scanner;
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
        empresa.adicionarEmpresa(empresa.empresaCadastradaDefault()); // só pra comecar com uma empresa cadastrada já

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
                System.out.println("4 - Visualizar Candidatos Cadastrados");
                System.out.println("5 - Editar Candidato Cadastrado");
                System.out.println("6 - Voltar");
                int opcaoCandidato = sc.nextInt();

                switch (opcaoCandidato){

                    case 1:

                        candidato.visualizarVagas(empresa.getVagasPublicadas());

                        break;
                    case 2:

                        if (!candidato.visualizarVagas(empresa.getVagasPublicadas())) {
                            break; // Sai do case se não houver vagas
                        }

                        System.out.print("Informe o índice da vaga para se inscrever: "); //pega o indice para selecionar a vaga escolhida
                        int indice = sc.nextInt();

                        System.out.println("1 - Ja tenho Cadastro no Sistema || 2 - Preencher o Formulario Apenas Para essa Vaga");
                        int opcaoUsuario = sc.nextInt();

                        if (opcaoUsuario ==1){

                            candidato.inscreverVaga(empresa.getVagasPublicadas(), indice, true);

                        } else if (opcaoUsuario ==2) {

                            candidato.inscreverVaga(empresa.getVagasPublicadas(), indice, false);
                        }
                        break;

                    case 3:

                        Candidato candidatoCadastrado = candidato.formularioCandidato();
                        candidato.salvarCandidatoSistema(candidatoCadastrado);

                        break;

                    case 4:

                        if(!candidato.visualizarCandidatosCadastradosSistema()){
                            break;
                        }else {
                            candidato.visualizarCandidatosCadastradosSistema();
                        }

                        break;

                    case 5:
                        if (!candidato.visualizarCandidatosCadastradosSistema()) {
                            System.out.println("Não há candidatos cadastrados!");
                            break; // Sai do case se não houver candidatos
                        }

                        System.out.println("1 - Editar Cadastro de Candidato || 2 - Voltar...");
                        int opcaoEditarCandidato = sc.nextInt();
                        sc.nextLine(); // Consumir a nova linha pendente

                        if (opcaoEditarCandidato == 1) {
                            System.out.print("Informe o índice do candidato que deseja editar: ");
                            int indiceCandidato = sc.nextInt();
                            sc.nextLine(); // Consumir a nova linha pendente

                            candidato.editarCandidatoPorIndice(indiceCandidato - 1); // Subtrair 1 para ajustar o índice
                        }
                        break;
                    case 6:
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
                System.out.println("4 - Visualizar Empresas Cadastradas");
                System.out.println("5 - Edição de Vagas de Emprego");
                System.out.println("6 - Voltar");
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
                        empresa.visualizarEmpresasCadastradas();
                        break;

                    case 5:
                        Empresa empresaSelected = empresa.escolherEmpresaParaEditarVaga();
                        empresaSelected.visualizarVagasPorEmpresaSelecionada(empresaSelected);
                        System.out.println("Digite o Índice da Vaga Selecionada:");
                        int vagaSelected = sc.nextInt();
                        sc.nextLine();
                        Vaga vagaSelecionada = empresaSelected.selecionarVagaPorIndice(empresaSelected,vagaSelected);
                        empresa.editarVagaPorIndice(empresaSelected,vagaSelected);
                        break;

                    case 6:

                        System.out.println("Voltando");
                        break;

                    default:

                        System.out.println("Opcao Invalida");

                }

            }
    }while(opcaoMenu !=3);
}
}
