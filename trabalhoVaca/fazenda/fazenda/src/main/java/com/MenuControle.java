
package com;
import java.io.IOException;
import javafx.fxml.FXML;

public class MenuControle {
    
    @FXML
    public void VacaInserir () throws IOException{
        App.setRoot ("telaVaca");
    }
    public void VacaExcluir () throws IOException{
        App.setRoot ("telaExcluirVaca");
    }
    public void UsuarioLogar () throws IOException{
        App.setRoot ("telaLogin");
    }  
    public void UsuarioCadastrar () throws IOException{
        App.setRoot ("telaCadastroUsuario");
    }
    public void UsuarioExcluir () throws IOException{
        App.setRoot ("telaExcluirUsuario");
    }
    public void ProducaoRegistrar () throws IOException{
        App.setRoot ("telaProducao");
    }

}
