
package com;
import java.io.IOException;
import javafx.fxml.FXML;

public class MenuControle {
    
    @FXML
    public void VacaInserir () throws IOException{
        App.setRoot ("telaVaca");
    } 
    public void VacaAlterar () throws IOException{
        App.setRoot ("telaAlterarVaca");
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
    public void UsuarioAlterar () throws IOException{
        App.setRoot ("telaAlterarUsuario");
    }  
    public void ProducaoRegistrar () throws IOException{
        App.setRoot ("telaRegistrarProducao");
    }
    public void ProducaoListar () throws IOException{
        App.setRoot ("telaListarProducaoVaca");
    }
    public void ProducaoListarMes () throws IOException{
        App.setRoot ("telaListarProducaoMes");
    }
    public void ProducaoListarDia () throws IOException{
        App.setRoot ("telaListarProducaoDia");
    }
    public void Sair () throws IOException{
        App.setRoot ("telaLogin");
    }

}
