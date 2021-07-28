/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesDAO;

import ClasesVO.LoginVO;
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
public class LoginDAO {
    public static LoginVO validar(String Clave, String contraseña){
        LoginVO login = new LoginVO();
        coneccion cx = new coneccion();
        Connection cn = cx.getConnection();
        PreparedStatement smt;
        String Sql= "select * from usuario where nombre=? and contraseña=?";
            
        try {
            smt = cn.prepareStatement(Sql);
            smt.setString(1, Clave);
            smt.setString(2, contraseña);
            ResultSet rs = smt.executeQuery();
            if(rs.next()){
                login.setId_usuario(Integer.parseInt(rs.getString(1)));
                login.setContraseña(rs.getString(2)); 
                login.setNombre(rs.getString(3));
                JOptionPane.showMessageDialog(null, "Bienvenido");
            }else{
                JOptionPane.showMessageDialog(null, "lo sentimos datos de usuarios incorrectos");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (cn !=null){
                try {
                    cn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
        return login;
    }
}
