
package com;
import java.io.IOException;
import javafx.fxml.FXML;

public class MenuControle {
    
    @FXML
    public void VacaInserir () throws IOException{
        App.setRoot ("telaVaca");
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
        App.setRoot ("telaRegistrarProducao");
    }
    public void ProducaoListar () throws IOException{
        App.setRoot ("telaListarProducaoVaca");
    }
    public void ProducaoListarMes () throws IOException{
        App.setRoot ("telaListarProducaoVacaMes");
    }
    public void ProducaoListarDia () throws IOException{
        App.setRoot ("telaListarProducaoVacaDia");
    }

}
