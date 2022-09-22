/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;
import view.FormCadastroView;

/**
 *
 * @author Pancaldi
 */
public class UsuarioDAO {
    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Usuario usuario) throws SQLException{
  
        String sql = "insert into usuario( user_usuario, senha_usuario, nome_usuario, email_usuario, telefone_usuario, cpf_usuario) values('"+ usuario.getUsuario() +"', '"+ usuario.getSenha() +"' , '" + usuario.getNome()+"', '" + usuario.getEmail() + "' , '" + usuario.getTelefone() + "' , '" + usuario.getCpf() + "');";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        
            
        
    }

    public boolean autenticarUsuario(Usuario user) throws SQLException {
        String sql = "select * from usuario where user_usuario = '"+user.getUsuario()+"' and senha_usuario = '"+user.getSenha()+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        
        ResultSet resultSet = statement.getResultSet();
        
       return resultSet.next();
        
        
    }

    
}
