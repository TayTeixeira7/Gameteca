/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Jogo;

/**
 *
 * @author Pancaldi
 */
public class JogoDAO {
    private final Connection connection;
    public Jogo jogo;
    
    public JogoDAO(Connection connection){
            this.connection = connection;
    }
    

    public void insert(Jogo jogo) throws SQLException{
        
        String sql = "insert into jogo(nome_jogo, genero_jogo, ano_jogo, desenvolvedora_jogo, distribuidora_jogo, progresso_jogo) values("
                + "'" + jogo.getNomeJogo() + "', '" + jogo.getGeneroJogo() + "', '" + jogo.getAnoLancamentoJogo() + "', '" + jogo.getDesenvolvedoraJogo() + "', '" + jogo.getDistribuidoraJogo() + "', '" + jogo.getProgressoJogo() + "');" ;
    
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }
    
    public ArrayList<Jogo> listarTodosJogos() throws SQLException{
        
        
        String sql = "select * from jogo";
        ArrayList<Jogo> jogo = new ArrayList<Jogo>();
        
        try{
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        resultSet = statement.executeQuery();
        
        while(resultSet.next()){
            String nomeJogo = resultSet.getString("nome_jogo");
            String generoJogo = resultSet.getString("genero_jogo");
            int anoLancamento = resultSet.getInt("ano_jogo");
            String desenvolvedora = resultSet.getString("desenvolvedora_jogo");
            String distribuidora = resultSet.getString("distribuidora_jogo");
            Float  progresso = resultSet.getFloat("progresso_jogo");
            
            Jogo jogocomDados = new Jogo(nomeJogo, generoJogo, anoLancamento, desenvolvedora, distribuidora, progresso);
            jogo.add(jogocomDados);
        }
        
        
        
    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar!");
    } 
       
    return jogo;    
        
    }

}
