package br.newtonpaiva.ui;

import br.newtonpaiva.dominio.TorneioClub;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            TorneioClub torneioClub = new TorneioClub();

            List<String> listaMG_RJ = torneioClub.lerClubes("Clubes_MG_RJ.txt");
            List<String> listaSP_RS = torneioClub.lerClubes("Clubes_SP_RS.txt");

            List<String> confrontos = torneioClub.gerarConfrontos(listaMG_RJ, listaSP_RS);
            List<String> horarios = torneioClub.preencherHorarios(confrontos);

            torneioClub.escreverConfrontos("Torneio.txt", confrontos, horarios);

            System.out.println("Confrontos gerados com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao manipular arquivos: " + e.getMessage());
        }
    }
}