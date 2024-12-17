
package com;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import modelo.Usuario;
import modelo.Vaca;
import util.Dao;

public class VacaControle {

    @FXML
    private TextField campoBrinco;
    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoRaca;
    
    Dao <Vaca> daoVaca;
    Vaca vaca;
    
    @FXML
    private void initialize(){
        daoVaca = new Dao(Vaca.class); 
    }
    
    @FXML
    public void cadastrar(){
        if(campoBrinco.getText().isEmpty()|| campoNome.getText().isEmpty()|| campoRaca.getText().isEmpty()){
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("ERROR");
            alerta.setHeaderText(null);
            alerta.setContentText("Campo vazio");
            alerta.showAndWait();
        }
        else if(daoVaca.buscarPorChave("brinco", campoBrinco.getText()) != null){
                
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("ERROR");
            alerta.setHeaderText(null);
            alerta.setContentText("Vaca ja inserido");
            alerta.showAndWait();
        }
        else{
            vaca = new Vaca();
            vaca.setBrinco(campoBrinco.getText());
            vaca.setNome(campoNome.getText());
            vaca.setRaca(campoRaca.getText());
            daoVaca.inserir(vaca);

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

