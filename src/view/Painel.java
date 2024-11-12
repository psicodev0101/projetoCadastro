package view;

import repository.UsuarioRepositoryImpl;

import java.util.Scanner;

public class Painel extends FuncoesPanel{
    private boolean exit = false;
    UsuarioRepositoryImpl usuarioRepository = new UsuarioRepositoryImpl();
    public void startPainel (){

        while (!exit) {
            Scanner read = new Scanner(System.in);
            exibirMenu();
            String input = null;
            int select = 0;

            while (true) {
                input = read.nextLine();
                if (input.matches("[0-9]+")){
                    select = Integer.parseInt(input);
                        break;
                }
                System.out.print("ERRO: Apenas números, tente novamente... \n -> ");
            }

            switch (select) {
                case 1 -> usuarioRepository.addUsuario(coletarInfo());
                case 2 -> usuarioRepository.removerUsuario(receberCpf());
                case 3 -> usuarioRepository.informacoesUsuario(receberCpf());
                case 4 -> usuarioRepository.listarUsuarios();
                case 5 -> exit = true;
                default -> System.out.println(
                        """
                            OPCAO INVALIDA! SELECIONE NOVAMENTE...
                            -----------------------------------------------------------
                        """
                );
            }
        }
    }
}
