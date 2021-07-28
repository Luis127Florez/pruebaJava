/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesDAO;

import ClasesVO.TransaccionesVO;
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
public class transaccionesDAO {
    
    public static String Registrar_transaccion(TransaccionesVO transaca){
        String result = null, last = null;
        coneccion cx = new coneccion();
        Connection cn = cx.getConnection();
        PreparedStatement smt;
        String Sql ="insert into transacion (numero_cuenta,numero_documento,monto,nombre,id_usuario)values(?,?,?,?,?)";
        
        try {
            smt =  cn.prepareStatement(Sql);
            smt.setString(1, transaca.getNumero_cuenta()+"");
            smt.setString(2, transaca.getNumero_docuemneto()+"");
            smt.setString(3, transaca.getMonto());
            smt.setString(4, transaca.getNombre());
            smt.setString(5, transaca.getFk_id_usuario()+"");
            int resultado = smt.executeUpdate();
            if(resultado == 1){
                JOptionPane.showMessageDialog(null, "Transaccion exitosa");
            }else{
                JOptionPane.showMessageDialog(null, "Ha ocurrido  un error en la transaccion");
            }
        } catch (SQLException ex) {
            Logger.getLogger(transaccionesDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error "+ ex);
        }
        return result; 
    }
    
}
