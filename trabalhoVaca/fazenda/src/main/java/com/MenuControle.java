
package com;
import java.io.IOException;
import javafx.fxml.FXML;

public class MenuControle {
    
    @FXML
    public void VacaInserir () throws IOException{
        App.setRoot ("telaVaca");
    }
    public void UsuarioCadastrar () throws IOException{
        App.setRoot ("telaCadastroUsuario");
    }
    public void UsuarioLogar () throws IOException{
        App.setRoot ("telaLogin");
    }    
    public void ProducaoRegistrar () throws IOException{
        App.setRoot ("telaProducao");
    }
}
