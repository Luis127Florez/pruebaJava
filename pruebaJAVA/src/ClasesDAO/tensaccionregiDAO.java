/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesDAO;

import conexion.coneccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cristian
 */
public class tensaccionregiDAO {
      public DefaultTableModel mostrarClientes()
    {
        coneccion cx = new coneccion();
        Connection cn = cx.getConnection();
        PreparedStatement smt;
        String []  nombresColumnas = {"id","numero_cuenta","numero_documento","monto","nombre","fecha_transaccion"};
        String [] registros = new String[6];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM transacion";

        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {      
        
            
            pst = cn.prepareStatement(sql);                              
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("numero_cuenta");
                registros[2] = rs.getString("numero_documento");
                registros[3] = rs.getString("monto");
                registros[4] = rs.getString("nombre");
                registros[5] = rs.getString("fecha_transaccion");
                   
                
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }
    
}
