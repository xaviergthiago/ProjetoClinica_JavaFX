/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author xavie
 */
public class ConexaoBD {
    public Statement stm; //Realiza a pesquisa no BD
    public ResultSet rs; //Armazena o resultado da pesquisa
    private String driver = "org.postgresql.Driver"; //Identifica o serviço (padrão)
    private String caminho = "jdbc:postgresql://localhost:5432/projetoclinica"; //Qual o caminho do BD, onde está alocado
    private String usuario = "postgres"; //Usuário cadastrado
    private String senha = "771882"; //Senha cadastrada
    public Connection con;
    
    public void conexao(){ //Método responsável por realizar a conexão com a base de dados
        try {
            System.setProperty("jdcb.Drivers", driver); //Responsável por setar as propriedades do driver de conexão
            con=DriverManager.getConnection(caminho, usuario, senha);
            JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso.");
        } catch (SQLException ex) {
            //Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao se conectar com o banco de dados: \n" +ex.getMessage());
        }
    }   
    
    public void desconecta(){ //Método responsável por realizar a desconexão com a base de dados
        try {
            con.close();
            JOptionPane.showMessageDialog(null, "BD desconectado com sucesso.");
        } catch (SQLException ex) {
            //Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao desconectar BD: \n" +ex.getMessage());
        }
    }
    
}
