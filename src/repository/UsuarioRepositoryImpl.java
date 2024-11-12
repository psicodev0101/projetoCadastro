package repository;

import models.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositoryImpl implements UsuarioRepository {

    @Override
    public void addUsuario(Usuario usuario) {
        String info = usuario.toString();
        UsuarioData.gravar(info);
    }

    @Override
    public void removerUsuario(String cpf) {
        List<Usuario> list = carregarUsuarios();
        if (list.remove(buscarCpf(cpf, list))) {
            System.out.println("REMOVIDO COM SUCESSO!");
        }
        UsuarioData.sincronizarDataBase(list);
    }

    public void informacoesUsuario (String cpf) {
        List<Usuario> list = carregarUsuarios();
        Usuario usuario = buscarCpf(cpf, list);
        if (usuario != null && list.contains(usuario)) {
            System.out.printf(
                    """
                    ---------------------------------------------------------------
                    INFORMACOES DO USUARIO:
                    NOME: %s;
                    CPF: %s;
                    IDADE: %d;
                    """, usuario.getNome(), usuario.getCpf(), usuario.getIdade()
            );
        }
    }

    @Override
    public void listarUsuarios() {
        List<Usuario> list = carregarUsuarios();

        for (Usuario usuario : list) {
            usuario.getInfo();
        }
    }

    private List<Usuario> carregarUsuarios() {
        List<String[]> tabela = UsuarioData.gerarTabela();
        List<Usuario> usuarios = new ArrayList<>();

        for (String[] dados : tabela) {
            String nome = dados[0];
            String cpf = dados[1];
            int idade = Integer.parseInt(dados[2]);
            Usuario usuario = new Usuario(nome, cpf, idade);
            usuarios.add(usuario);
        }

        return usuarios;
    }

    private Usuario buscarCpf(String cpf, List<Usuario> list) {

        for (Usuario usuario : list) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }

        System.out.println("ERRO: Nenhum registro encontrado.");
        return null;
    }

}
