/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ModeloMedico;
import org.openide.util.Exceptions;

/**
 *
 * @author xavie
 */
public class ControleMedico {

    ConexaoBD conex = new ConexaoBD();
    ModeloMedico mod = new ModeloMedico();

    public void salvar(ModeloMedico mod) {
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into medico(nome_medico, especialidade_medico, crm_medico) values(?, ?, ?)"); //Coluna onde serão inseridos os dados para pesquisa no BD
            pst.setString(1, mod.getNome()); //Primeiro parâmetro a ser enviado e atributo (tipo) que será inserido
            pst.setString(2, mod.getEspecialidade()); //Segundo parâmetro a ser enviado e atributo (tipo) que será inserido
            pst.setInt(3, mod.getCrm()); //Terceiro parâmetro a ser enviado e atributo (tipo) que será inserido
            pst.execute(); //Se ele conseguir seguir todas as instruções
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso.");
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados./nErro: " + ex);
        }

        conex.desconexao();
    }
}
