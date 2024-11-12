package view;

import models.Usuario;
import services.UsuarioServices;

public class FuncoesPanel {

    public void exibirMenu(){
        System.out.print(
                """
                    ------------------------------------------------------------
                    === SISTEMA DE CADASTRO ===
                    SELECIONE UMA OPÇÃO:
                    [1] Cadastrar novo usuario
                    [2] Remover usuario cadastrado
                    [3] Exibir informações do usuario
                    [4] Listar usuarios cadastrados
                    [5] Sair
                    
                    Seleção >\s"""
        );
    }

    public Usuario coletarInfo(){
        System.out.println("------------------------------------------------------------");
        System.out.print("NOME: ");
        String nome = UsuarioServices.validarNome();
        System.out.print("CPF: ");
        String cpf = UsuarioServices.validarCpf();
        System.out.print("IDADE: ");
        int idade = UsuarioServices.validarIDade();

        return new Usuario(nome, cpf, idade);
    }

    public String receberCpf (){
        System.out.println("------------------------------------------------------------");
        System.out.print("DIGITE O CPF DO USUARIO: ");
        String cpf = UsuarioServices.validarCpf();
        return cpf;
    }

}
