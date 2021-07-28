/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesDAO;

import ClasesVO.SaldoVO;
import conexion.coneccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author cristian
 */
public class SaldoDAO {
    public static SaldoVO saldo (String Clave){
        SaldoVO sal = new SaldoVO();
        coneccion cx = new coneccion();
        Connection cn = cx.getConnection();
        PreparedStatement smt;
        String sql ="select * from cuenta where fk_id_usuario=?";
        
        try {
            smt = cn.prepareStatement(sql);
            smt.setString(1, Clave);
            ResultSet rs = smt.executeQuery();
            if(rs.next()){
                sal.setId(Integer.parseInt(rs.getString(1)));
                sal.setSaldo(rs.getString(2)); 
                System.err.println("bien hecho");
            }else{
                System.err.println("lo siento hay un error");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaldoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("erro " +ex);
        }
        return sal;
    }
}
