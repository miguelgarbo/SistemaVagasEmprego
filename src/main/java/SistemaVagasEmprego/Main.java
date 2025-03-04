package SistemaVagasEmprego;

import users.Empresa;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {

            System.out.println("==SISTEMA VAGAS DE EMPREGO==");
            System.out.println("Informe a opcao desejada: ");
            System.out.println("1 -  Entrar Como Empresa");
            System.out.println("2 - Entrar Como Candidato");
            System.out.println("3 - Cadastrar");
            System.out.println("4 - Sair");
            opcao = sc.nextInt();

            switch (opcao){

                case 1:

                    Empresa emp = new Empresa();

                    emp.publicarVaga();


                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    System.out.println("Saindo..");
                    break;
                default:

                    System.out.println("Foi Informado uma opção que não existe.");
            }

        }while (opcao != 4);


    }
}