package services;

import java.util.Scanner;

public class UsuarioServices {

    public static String validarNome () {
        String nome = null;
        Scanner read = new Scanner(System.in);

        while (true) {
            nome = read.nextLine();
            if (nome.matches("[a-zA-Z]+")){
                break;
            }
            System.out.print("ERRO: Nome inválido, tente novamente... \n -> ");
        }

        return nome;
    }

    public static String validarCpf (){
        String cpf = null;
        Scanner read = new Scanner(System.in);

        while (true) {
            cpf = read.nextLine();
            if (isNum(cpf) && cpf.length() == 11){
                break;
            }
            System.out.print("ERRO: CPF invalido! tente novamente... \n -> ");
        }

        return cpf;
    }

    public static int validarIDade () {
        String input = null;
        int num = 0;
        Scanner read = new Scanner(System.in);

        while (true) {
            input = read.nextLine();
            if (isNum(input)){
                num = Integer.parseInt(input);
                if (num > 0 && num < 110) {
                    break;
                }
            }
            System.out.print("ERRO: Apenas números, tente novamente... \n -> ");
        }

        return num;
    }

    private static boolean isNum (String input) {
        return input.matches("[0-9]+");
    }
}
