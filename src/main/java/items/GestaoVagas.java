package items;

import users.Candidato;
import java.util.List;
import java.util.Scanner;


public class GestaoVagas {
    private List<Vaga> vagasPublicadas;

    public GestaoVagas(List<Vaga> vagasPublicadas) {
        this.vagasPublicadas = vagasPublicadas;
    }

    public void exibirVagas() {
        if (vagasPublicadas.isEmpty()) {
            System.out.println("Não há vagas publicadas.");
        } else {
            for (int i = 0; i < vagasPublicadas.size(); i++) {
                System.out.println((i + 1) + ". " + vagasPublicadas.get(i));
            }
        }
    }

    public void exibirInscricoes(List<Vaga> vagasPublicadas) {
        if (vagasPublicadas.isEmpty()) {
            System.out.println("Não há vagas disponíveis.");
        } else {
            for (Vaga vaga : vagasPublicadas) {
                System.out.println("Vaga: " + vaga.getTitulo());
                System.out.println("Candidatos Inscritos: ");
                for (Candidato candidato : vaga.getCandidatosInscritos()) {
                    System.out.println(candidato.getNome());
                }
            }
        }
    }
}
