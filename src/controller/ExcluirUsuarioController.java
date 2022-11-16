/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.ExcluirUsuarioView;

/**
 *
 * @author Pancaldi
 */
public class ExcluirUsuarioController {
   
    private ExcluirUsuarioView view;
    
    public ExcluirUsuarioController(ExcluirUsuarioView view){
        this.view = view;
    }
    
    public void excluirUsuario() throws SQLException{
        
        String cpfUser = view.getTxtCPF().getText();
        int processo = 0;
        
        try {
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            
            processo = usuarioDao.excluir(cpfUser);
            
            if(processo == 1){
                JOptionPane.showMessageDialog(null,"Exclusão realizada com sucesso" );
                view.getTxtCPF().setText("");
            }else{
                JOptionPane.showMessageDialog(null,"Essa conta não existe" );
            }
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir esse usuário! ");
            Logger.getLogger(ExcluirUsuarioView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
  }

