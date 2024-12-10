
package com;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import modelo.Vaca;
import modelo.VacaProducao;
import util.Dao;

public class RegistrarProducaoControle {
    @FXML
    private TextField campoLeite;
    @FXML
    private ComboBox<Vaca> comboVacas;
    @FXML
    private DatePicker data;
    @FXML
    private Vaca selecionada;
    
    Dao <VacaProducao> daoProducao;
    Dao <Vaca> daoVaca;
    Vaca vaca;
    
    @FXML
    private void initialize(){
        daoVaca = new Dao(Vaca.class);   
        daoProducao = new Dao(VacaProducao.class);   
        List<Vaca> vacasCadastradas = daoVaca.listarTodos();
        ObservableList<Vaca> itensComboBox = FXCollections.observableArrayList(vacasCadastradas);
        comboVacas.setItems(itensComboBox);
        
    }
    @FXML
    private void atualizarCampos(){
        selecionada = comboVacas.getValue();

    }
    @FXML
    private void gravar(){
        Vaca comboVaca = comboVacas.getValue();
        LocalDate datas = data.getValue();
        String leiteF = campoLeite.getText();
        
        if(comboVaca == null || datas == null || leiteF.isEmpty()){
            
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("ERROR");
        alerta.setHeaderText(null);
        alerta.setContentText("Campo vazio");
        alerta.showAndWait();
        
        }
        else{
            VacaProducao producao = new VacaProducao(comboVaca, datas, leiteF);
            producao.setBrinco(comboVaca);
            producao.setData(datas);
            producao.setLeite(leiteF);
            daoProducao.inserir(producao);
            
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText(null);
            alerta.setContentText("Vaca inserido");
            alerta.showAndWait(); 
        }
    }
    
    @FXML
    public void cancelar() throws IOException{
        App.setRoot("telaMenu");
    }
}
