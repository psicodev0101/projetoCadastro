package repository;

import models.Usuario;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioData {

    private static final String PATH = "D:\\PEDRO\\Workspace\\Intellij\\projetos apresentaveis\\poobasicprojects\\projetoCadastro\\src\\repository\\database.csv";

    public static void gravar(String usuarioString) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH, true))) {
                bufferedWriter.write(usuarioString);
                bufferedWriter.newLine();
                System.out.println("Salvo com sucesso!");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static List<String> ler() {
        List<String> linhas = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))) {
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return linhas;
    }

    public static List<String[]> gerarTabela () {
        return ler().stream()
                .map(linha -> linha.split(";"))
                .collect(Collectors.toList())
        ;
    }

    public static void sincronizarDataBase(List<Usuario> usuarios){
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH))) {
                for (Usuario usuario : usuarios) {
                    bufferedWriter.write(usuario.toString());
                    bufferedWriter.newLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
    }
}
