
package com;

import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import modelo.Usuario;
import util.Dao;

public class ExcluirUsuarioControle {
    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoSenha;
    @FXML
    private ComboBox<Usuario> comboUsuario;
    
    private Usuario selecionado;
    
    Dao<Usuario> daoUsuario;
    Usuario usuario;
    
    @FXML
    private void initialize(){
        daoUsuario = new Dao(Usuario.class);
        List<Usuario> usuarioCadastrados = daoUsuario.listarTodos();
        ObservableList<Usuario> itensComboBox = FXCollections.observableArrayList(usuarioCadastrados);
        comboUsuario.setItems(itensComboBox);
    }
    @FXML
    private void atualizarCampos(){
        Usuario comboUsuarios = comboUsuario.getValue();
        campoNome.setText(comboUsuarios.getNome());
        campoSenha.setText(comboUsuarios.getSenha());

    }
    
    @FXML
    private void excluirUsuario() throws IOException{
        selecionado = comboUsuario.getValue();
        if(campoSenha.getText().isEmpty()){

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("ERROR");
            alerta.setHeaderText(null);
            alerta.setContentText("Campo vazio");
            alerta.showAndWait();
        }
        
        else if(daoUsuario.buscarPorChave("login", selecionado.getLogin()) == null || daoUsuario.buscarPorChave("senha", campoSenha.getText()) == null ){

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("ERROR");
            alerta.setHeaderText(null);
            alerta.setContentText("Login nao encontrado");
            alerta.showAndWait();
        }
        else{
            daoUsuario.excluir("login", selecionado.getLogin());
            comboUsuario.setValue(null);
            campoSenha.setText("");
            
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText(null);
            alerta.setContentText("Login excluido");
            alerta.showAndWait();
            
        }
    }
        
    @FXML
    public void cancelar() throws IOException{
        App.setRoot("telaMenu");
    }
}
