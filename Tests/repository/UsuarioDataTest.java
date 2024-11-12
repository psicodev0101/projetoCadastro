package repository;

import models.Usuario;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioDataTest {

    Usuario usuarioA = new Usuario("pedro","12345678900",18);
    Usuario usuarioB = new Usuario("paulo","12345678901",19);
    Usuario usuarioC = new Usuario("joao","12345678902",20);
    Usuario usuarioD = new Usuario("antonieta","12345678903",21);
    Usuario usuarioE = new Usuario("joaquina","12345678904",22);

    @Test
    void gravarELerTest() {
        UsuarioData.gravar(usuarioA.toString());
        UsuarioData.gravar(usuarioB.toString());
        UsuarioData.gravar(usuarioC.toString());
        UsuarioData.gravar(usuarioD.toString());
        UsuarioData.gravar(usuarioE.toString());

        List<String> output = new ArrayList<>();
        output.add(usuarioA.toString());
        output.add(usuarioB.toString());
        output.add(usuarioC.toString());
        output.add(usuarioD.toString());
        output.add(usuarioE.toString());

        assertEquals(output, UsuarioData.ler());
    }

    @Test
    void gerarTabelaTest() {
        String[] usuarioA = {"pedro", "12345678900", "18"};
        assertEquals(Arrays.toString(usuarioA), Arrays.toString(UsuarioData.gerarTabela().get(0)));
        String[] usuarioB = {"paulo", "12345678901", "19"};
        assertEquals(Arrays.toString(usuarioB), Arrays.toString(UsuarioData.gerarTabela().get(1)));
    }

    @Test
    void sincronizarDataBaseTest() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuarioA);
        usuarios.add(usuarioB);

        UsuarioData.sincronizarDataBase(usuarios);

        assertEquals("[pedro, 12345678900, 18]", Arrays.toString(UsuarioData.gerarTabela().get(0)));
        assertEquals("[paulo, 12345678901, 19]", Arrays.toString(UsuarioData.gerarTabela().get(1)));
    }
}