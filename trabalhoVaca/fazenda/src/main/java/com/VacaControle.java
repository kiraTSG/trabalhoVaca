
package com;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modelo.Vaca;
import util.Dao;

public class VacaControle {

    @FXML
    private TextField campoBrinco;
    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoRaca;
    
    Dao <Vaca> dao;
    Vaca vaca;
    
    private void initialize(){
        dao = new Dao(Vaca.class); 
    }
    
    @FXML
    public void cadastrar(){
        
        vaca = new Vaca();
        vaca.setBrinco(campoBrinco.getText());
        vaca.setNome(campoNome.getText());
        vaca.setRaca(campoRaca.getText());
        dao.inserir(vaca);
        
    }
    @FXML
    public void cancelar() throws IOException{
        App.setRoot("telaMenu");
    }
    
 
}

