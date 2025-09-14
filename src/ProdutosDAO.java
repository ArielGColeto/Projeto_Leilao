/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
<<<<<<< HEAD


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        
        //conn = new conectaDAO().connectDB();
        
        
    }
    
=======
import java.sql.SQLException;


public class ProdutosDAO {
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto)
    {
        try{
            String sql = "INSERT INTO produtos (nome,valor,status) VALUES (?,?,?)";
       
        try (Connection conn = new conectaDAO().connectDB();PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getValor());
            stmt.setString(3, produto.getStatus());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Cadastrado com Sucesso");
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Erro na conexão:\n" + ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
>>>>>>> 5c9423b (Commit #1: Botao de cadastro agora tem funcionalidade)
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

