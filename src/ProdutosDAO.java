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
import java.sql.SQLException;
import java.sql.*;


public class ProdutosDAO {
   
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

    public ArrayList<ProdutosDTO> listarProdutos(){
        ArrayList<ProdutosDTO> produtos = new ArrayList<>();
        try
        {
            conectaDAO connect = new conectaDAO();
            Connection conn = connect.connectDB();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, nome, valor, status FROM produtos");
            
            while(rs.next())
            {
                ProdutosDTO p = new ProdutosDTO(rs.getInt("id"), rs.getString("nome"), rs.getInt("valor"), rs.getString("status"));
                produtos.add(p);   
            }
            rs.close();
            stmt.close();
            conn.close();
            
        }catch(SQLException e)
        { 
            e.printStackTrace();
        }
                
        return produtos;
    }
    
    public void venderProdutos(int id)
    {
        String sql = "UPDATE produtos SET status = 'Vendido' WHERE id = ?";
        
        try (Connection conn = new conectaDAO().connectDB();PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setInt(1, id);
            int updt = stmt.executeUpdate();
            if (updt > 0)
            {
                JOptionPane.showMessageDialog(null,"Atualizado com sucesso");
            } else
            {
                JOptionPane.showMessageDialog(null, "Nenhum produto encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Erro na conexão:\n" + ex.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
}

