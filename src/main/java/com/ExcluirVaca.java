
package com;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import modelo.Vaca;
import util.Dao;

public class ExcluirVaca {
    @FXML
    private TextField campoBrinco;
    
    Dao <Vaca> daoVaca;
    Vaca vaca;
    
    @FXML
    private void initialize(){
        daoVaca = new Dao(Vaca.class);
    }
    
    @FXML
    private void excluir(){
        
        if(campoBrinco.getText().isEmpty()){
            
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("ERROR");
            alerta.setHeaderText(null);
            alerta.setContentText("Campo vazio");
            alerta.showAndWait();
            
        }
        else if(daoVaca.buscarPorChave("brinco", campoBrinco.getText()) == null){
                
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("ERROR");
            alerta.setHeaderText(null);
            alerta.setContentText("Vaca nao encontrado");
            alerta.showAndWait();
            
        }
        else{
            daoVaca.excluir("brinco", campoBrinco.getText());

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText(null);
            alerta.setContentText("Vaca excluido");
            alerta.showAndWait(); 
            
        }
    }
    
    @FXML
    public void cancelar() throws IOException{
        App.setRoot("telaMenu");
    }
}
