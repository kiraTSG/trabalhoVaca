
package com;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    
    Dao<Usuario> dao;
    Usuario usuario;
    @FXML
    public void cadastrar(){
        if(campoLogin.getText().isEmpty()|| campoNome.getText().isEmpty()|| campoSenha.getText().isEmpty()){
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle("ERROR");
        alerta.setHeaderText(null);
        alerta.setContentText("Campo vazio");
        alerta.showAndWait();
    }
        
        else{
        usuario = new Usuario();
        usuario.setLogin(campoLogin.getText());
        usuario.setNome(campoNome.getText());
        usuario.setSenha(campoSenha.getText());
        dao = new Dao(Usuario.class); 
        dao.inserir(usuario);
        
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setContentText("Usuario cadastrado");
        alerta.showAndWait();
        }
        
    }
    @FXML
    public void cancelar() throws IOException{
        App.setRoot("telaMenu");
    }
    
    
 
}
