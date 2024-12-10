
package com;

import com.App;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import modelo.Usuario;
import util.Dao;



public class LoginControle {
    @FXML
    private TextField campoLogin;
    @FXML
    private TextField campoSenha;
    
    Dao<Usuario> daoUsuario;
    
    
    @FXML
    private void initialize(){
        daoUsuario = new Dao(Usuario.class); 
    }
    
    @FXML
    private void entrar()throws IOException{
        if(campoLogin.getText().isEmpty()|| campoSenha.getText().isEmpty()){
            
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ERROR");
        alerta.setHeaderText(null);
        alerta.setContentText("Campo vazio");
        alerta.showAndWait();
        }
        
        else if(daoUsuario.buscarPorChave("login", campoLogin.getText()) == null || daoUsuario.buscarPorChave("senha", campoSenha.getText()) == null ){
                
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ERROR");
        alerta.setHeaderText(null);
        alerta.setContentText("Login nao encontrado");
        alerta.showAndWait();
        }
        else{
        
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setContentText("Login aceito");
        alerta.showAndWait();
        App.setRoot ("telaMenu");
        }
    }
    
    @FXML
    private void cadastrar() throws IOException{
        App.setRoot("telaCadastroUsuario");
    }
    
    @FXML
    public void cancelar() throws IOException{
        App.setRoot("telaMenu");
    }
}