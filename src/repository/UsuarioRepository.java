package repository;

import models.Usuario;

public interface UsuarioRepository {
    void addUsuario(Usuario usuario);
    void removerUsuario(String cpf);
    void listarUsuarios();
}
