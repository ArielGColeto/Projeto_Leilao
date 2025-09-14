
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {


     private static final String URL = "jdbc:mysql://localhost:3306/leilao?useSSL=false&serverTimezone=UTC"; 
     private static final String USUARIO = "root";
     private static final String SENHA = "4RI3L123";
    
    
    public Connection connectDB() throws SQLException
    {
        return DriverManager.getConnection(URL, USUARIO, SENHA);    
    }
    
    
    

}
