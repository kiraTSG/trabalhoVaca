
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

public class AlterarVaca {
    @FXML
    private ComboBox <Vaca> comboVaca;
    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoRaca;
    
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
        campoRaca.setText(comboVacas.getRaca());

    }
    
    @FXML
    private void alterar(){
        selecionada = comboVaca.getValue();
        
        if(selecionada == null || campoNome.getText().isEmpty() || campoRaca.getText().isEmpty()){
            
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ERROR");
        alerta.setHeaderText(null);
        alerta.setContentText("Campo vazio");
        alerta.showAndWait();
        
        }
        else{

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText(null);
            alerta.setContentText("Vaca Alterado");
            alerta.showAndWait(); 
            selecionada.setNome(campoNome.getText());
            selecionada.setRaca(campoRaca.getText());
            
            daoVaca.alterar("brinco", selecionada.getBrinco(), selecionada);
            
            comboVaca.setValue(null);
            campoNome.setText("");
            campoRaca.setText("");
            
        }
    }
    
    @FXML
    public void cancelar() throws IOException{
        App.setRoot("telaMenu");
    }
}
