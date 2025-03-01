package users;

import items.ESenioridade;
import items.Vaga;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Empresa extends Usuario {

    Scanner sc = new Scanner(System.in);

    private String setor;
    private String localidade;
    private List<Vaga> vagasPublicadas;


    public Empresa(String nome, String email, String telefone, String setor, String localidade) {
        super(nome, email, telefone);
        this.setor = setor;
        this.localidade = localidade;
        this.vagasPublicadas = new ArrayList<>();
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }


    public void publicarVaga(String requisitos, double salario, String beneficios){

        System.out.println("==PUBLICAR VAGA==");
        System.out.println("Informe o Titulo da Vaga: ");
        String tituloInformado = sc.nextLine();
        int continuar;
        List<String> listaRequisitosInformados = new ArrayList<>();

        do {
            System.out.println("Informe os requisitos da vaga: ");
            String requisitoInformado = sc.nextLine();

            listaRequisitosInformados.add(requisitoInformado);
            System.out.println("1 - Add Requisito || 2 - Acabou os Requisitos");
            continuar = sc.nextInt();

        }while (continuar != 2);





//parei aqui 01/03

  // Vaga vagaNova = new Vaga();

    }
}
