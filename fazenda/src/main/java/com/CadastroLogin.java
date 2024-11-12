
package com;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modelo.Usuario;
import util.Dao;

public class CadastroLogin {
    @FXML
    private TextField campoLogin;
    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoSenha;
    
    Usuario usuario;
    @FXML
    public void cadastrar(){
        usuario = new Usuario();
        usuario.setLogin(campoLogin.getText());
        usuario.setNome(campoNome.getText());
        usuario.setSenha(campoSenha.getText());
        Dao <Usuario> dao = new Dao(Usuario.class); 
        dao.inserir(usuario);
        
    }
    
 
}
