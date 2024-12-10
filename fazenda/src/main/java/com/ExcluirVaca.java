
package com;

import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import modelo.Vaca;
import util.Dao;

public class ExcluirVaca {
    @FXML
    private ComboBox <Vaca> comboVaca;
    @FXML
    private TextField campoNome;
    
    private Vaca selecionada;
    
    Dao <Vaca> daoVaca;
    Vaca vaca;
    
    @FXML
    private void initialize(){
        daoVaca = new Dao(Vaca.class);
        List<Vaca> vacaCadastrados = daoVaca.listarTodos();
        ObservableList<Vaca> itensComboBox = FXCollections.observableArrayList(vacaCadastrados);
        comboVaca.setItems(itensComboBox);
        
    }
        @FXML
    private void atualizarCampos(){
        Vaca comboVacas = comboVaca.getValue();
        campoNome.setText(comboVacas.getNome());

    }
    
    @FXML
    private void excluir(){
        selecionada = comboVaca.getValue();

            daoVaca.excluir("brinco", selecionada.getBrinco());

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText(null);
            alerta.setContentText("Vaca excluido");
            alerta.showAndWait(); 
            
            comboVaca.setValue(null);
            campoNome.setText("");
            
    }
    
    
    @FXML
    public void cancelar() throws IOException{
        App.setRoot("telaMenu");
    }
}
