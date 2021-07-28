/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesDAO;


import ClasesVO.registroVO;
import conexion.coneccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author cristian
 */
public class registroDAO {
     
    public static String Registrar_transaccion(registroVO transac){
        String result = null, last = null;
        coneccion cx = new coneccion();
        Connection cn = cx.getConnection();
        PreparedStatement smt;
        String Sql ="insert into usuario (id_usuario,contraseña,nombre,telefono)values(?,?,?,?)";
        
        try {
            smt =  cn.prepareStatement(Sql);
            smt.setString(1, transac.getId_usuario()+"");           
            smt.setString(2, transac.getContraseña());
            smt.setString(3, transac.getNombre());
            smt.setString(4, transac.getTelefono()+"");
            int resultado = smt.executeUpdate();
            if(resultado == 1){
                JOptionPane.showMessageDialog(null, "Datos guardaos");
            }else{
                JOptionPane.showMessageDialog(null, "Datos no guardados");
            }
        } catch (SQLException ex) {
            Logger.getLogger(transaccionesDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error "+ ex);
        }
        return result; 
    }
}
