package dataFactory;

import pojo.UsuarioPojo;
import pojo.produtoPojo;

public class UsuarioDataFactory {
    public static UsuarioPojo criarNovoUsuarioAdmin(){
        UsuarioPojo usuario = new UsuarioPojo();
        usuario.setUsuarioLogin("admin");
        usuario.setUsuarioSenha("admin");
        return usuario;
    }
}
