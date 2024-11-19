/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package util;

import java.util.List;
import modelo.Usuario;
import modelo.Vaca;
import org.junit.jupiter.api.Test;

/**
 *
 * @author LuanBraz
 */
public class DaoTest {
    
    public DaoTest() {
}
//    @Test
//        public void testInserirVaca() {
//        Usuario v = new Usuario("L", "luan", "2");
//        Dao<Usuario> dao = new Dao(Usuario.class);
//        dao.inserir(v);    
//    }
    
//    @Test
//        public void testListar(){
//        Dao<Vaca> dao = new Dao(Vaca.class);
//        List<Vaca> lista = dao.listarTodos(); 
//        for (Vaca v : lista){
//            System.out.println(v.getBrinco() + " " + v.getNome() + " "+ v.getRaca());
//        }
//    }
    
    
    @Test
    public void testExcluir(){
        Dao<Vaca> dao = new Dao(Vaca.class);
        //boolean result = dao.excluir("login", "15"); // para dar errado 
        boolean result = dao.excluir("brinco", "o");  // para dar certo
        System.out.println(result);
    }
}  

