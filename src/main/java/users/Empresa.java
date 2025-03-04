package users;

import items.ESenioridade;
import items.Vaga;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empresa extends Usuario {

    Scanner sc = new Scanner(System.in);

    private String localidade;
    private List<Vaga> vagasPublicadas;


    public Empresa(String nome, String email, String telefone, String localidade) {
        super(nome, email, telefone);
        this.localidade = localidade;
        this.vagasPublicadas = new ArrayList<>();
    }

    public Empresa(){};

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }


    public void publicarVaga() {

        System.out.println("==PUBLICAR VAGA==");
        System.out.println("Empresa: " + this.getNome());
        System.out.println("Informe o Titulo da Vaga: ");
        String tituloInformado = sc.nextLine();
        int continuar;
        List<String> listaRequisitosInformados = new ArrayList<>();
        List<String> listaBeneficiosInformados = new ArrayList<>();


        do {
            System.out.println("Informe os requisitos da vaga: ");
            String requisitoInformado = sc.nextLine();

            listaRequisitosInformados.add(requisitoInformado);
            System.out.println("1 - Add Requisito || 2 - Acabou os Requisitos");
            continuar = sc.nextInt();
            sc.nextLine(); // Consome a quebra de linha pendente


        } while (continuar != 2);

        do {
            System.out.println("Informe os Beneficios da vaga: ");
            String beneficioInformado = sc.nextLine();

            listaBeneficiosInformados.add(beneficioInformado);
            System.out.println("1 - Add Beneficio || 2 - Acabou os Beneficios");
            continuar = sc.nextInt();

            sc.nextLine(); // Consome a quebra de linha pendente

        } while (continuar != 2);


        System.out.println("Informe o Salário da Vaga: ");
        double salarioInformado = sc.nextDouble();

        sc.nextLine();

        for(ESenioridade senioridade : ESenioridade.values()){

            System.out.println(senioridade);
        }

        System.out.print("Digite o nível de senioridade: ");
        String entrada = sc.nextLine().toLowerCase();


        try {
            ESenioridade senioridadeInformada = ESenioridade.valueOf(entrada);
            System.out.println("Você escolheu: " + senioridadeInformada);
            Vaga vagaNova = new Vaga(listaRequisitosInformados, salarioInformado, listaBeneficiosInformados, senioridadeInformada, tituloInformado);
            System.out.println("Vaga Publicada com Sucesso !!");

            } catch(IllegalArgumentException e){
                System.out.println("Nível de senioridade inválido!");
            }


        }
    }
