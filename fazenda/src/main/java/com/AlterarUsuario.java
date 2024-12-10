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

public class AlterarUsuario {
    @FXML
    private ComboBox <Usuario> comboUsuario;
    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoSenha;
    
    private Usuario selecionado;
    
    
    Dao <Usuario> daoUsuario;
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
    private void confirmar(){
        selecionado = comboUsuario.getValue();
        
        if(selecionado == null || campoNome.getText().isEmpty() || campoSenha.getText().isEmpty()){
            
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ERROR");
        alerta.setHeaderText(null);
        alerta.setContentText("Campo vazio");
        alerta.showAndWait();
        
        }
        else{
            
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("ERROR");
            alerta.setHeaderText(null);
            alerta.setContentText("Login atualizado");
            alerta.showAndWait();
            selecionado.setNome(campoNome.getText());
            selecionado.setSenha(campoSenha.getText());
            
            daoUsuario.alterar("login", selecionado.getLogin(), selecionado);
            
            comboUsuario.setValue(null);
            campoNome.setText("");
            campoSenha.setText("");
        }
    }
    
    @FXML
    public void voltar() throws IOException{
        App.setRoot("telaMenu");
    }
}
