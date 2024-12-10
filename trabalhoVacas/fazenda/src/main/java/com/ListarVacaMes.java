
package com;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Vaca;
import modelo.VacaProducao;
import util.Dao;

public class ListarVacaMes {
    @FXML
    private TableView<VacaProducao> tabelaProducao;
    @FXML
    private ComboBox<Integer> comboMes;
    @FXML
    private Integer selecionada;
    
    private LocalDate data;
    
    Dao <VacaProducao> daoProducao;
    Dao <Vaca> daoVaca;
    @FXML
    private void initialize(){
        daoProducao = new Dao(VacaProducao.class);
        daoVaca = new Dao(Vaca.class);

        TableColumn <VacaProducao, LocalDate> colunaData = new TableColumn <> ("Data");
        colunaData.setCellValueFactory (new PropertyValueFactory <> ("data"));
        TableColumn <VacaProducao, Integer> colunaQuantidade = new TableColumn <> ("Quantidade");
        colunaQuantidade.setCellValueFactory (new PropertyValueFactory<>("leite"));
        tabelaProducao.getColumns().addAll(colunaData, colunaQuantidade);
        
    }
    @FXML
    private void atualizarCampos(){
        selecionada = comboMes.getValue();
        List <VacaProducao> listaProd = daoProducao.buscarPorChave(data.getMonthValue() , selecionada);
        ObservableList <VacaProducao> listaFiltrada  = FXCollections.observableArrayList();
        for(VacaProducao v : listaProd){
            if(v.getBrinco().getBrinco().equals(selecionada.getClass()) ){
                listaFiltrada.add(v);
            }
        }
        tabelaProducao.setItems(listaFiltrada);
        
    }
    @FXML
    public void voltar() throws IOException{
        App.setRoot("telaMenu");
    }

}
