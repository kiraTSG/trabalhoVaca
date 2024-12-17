
package modelo;

import java.time.LocalDate;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class VacaProducao {

    @BsonProperty(value="brinco") // unico para cada vaca 
    private Vaca brinco;
    
    @BsonProperty(value="data")
    private LocalDate data;
    
    @BsonProperty(value="data")
    private LocalDate datas;
    
    @BsonProperty(value="leite")
    private String leite; 

    public VacaProducao(){
        brinco = new Vaca(); 
        data = LocalDate.now();
        leite = "";
    }
    
    public VacaProducao(Vaca brinco, LocalDate data, String leite){
        this.brinco = brinco; 
        this.data = data;
        this.leite = leite;
    }

    public Vaca getBrinco() {
        return brinco;
    }

    public void setBrinco(Vaca brinco) {
        this.brinco = brinco;
    }
    
    public LocalDate getData() {
        return data;
    }
    
    public void setData(LocalDate data) {
        this.data = data;
    }

        
    public String getLeite() {
        return leite;
    }

    public void setLeite(String leite) {
        this.leite = leite;
    }
}
