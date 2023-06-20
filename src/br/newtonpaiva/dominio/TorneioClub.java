package br.newtonpaiva.dominio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TorneioClub {
    public List<String> lerClubes(String nomeArquivo) throws IOException {
        List<String> clubes = new ArrayList<>();
        BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
        String linha;

        while ((linha = leitor.readLine()) != null) {
            clubes.add(linha);
        }

        leitor.close();

        return clubes;
    }

    public List<String> gerarConfrontos(List<String> listaMG_RJ, List<String> listaSP_RS) {
        List<String> confrontos = new ArrayList<>();

        for (String timeMG_RJ : listaMG_RJ) {
            for (String timeSP_RS : listaSP_RS) {
                String confronto = timeMG_RJ + " x " + timeSP_RS;
                confrontos.add(confronto);
            }
        }

        return confrontos;
    }

    public List<String> preencherHorarios(List<String> confrontos) {
        List<String> horarios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os horários dos jogos:");

        for (String confronto : confrontos) {
            System.out.print(confronto + ": ");
            String horario = scanner.nextLine();
            horarios.add(horario);
        }

        return horarios;
    }

    public void escreverConfrontos(String nomeArquivo, List<String> confrontos, List<String> horarios) throws IOException {
        FileWriter escritor = new FileWriter(nomeArquivo);
        BufferedWriter buffWrite = new BufferedWriter(escritor);

        for (int i = 0; i < confrontos.size(); i++) {
            String confronto = confrontos.get(i);
            String horario = horarios.get(i);
            String confrontoHorario = confronto + " " + horario;
            buffWrite.write(confrontoHorario);
            buffWrite.newLine();
        }

        buffWrite.close();
        escritor.close();
    }
}