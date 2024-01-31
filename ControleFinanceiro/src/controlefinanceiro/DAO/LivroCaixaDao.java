package controlefinanceiro.DAO;

import controlefinanceiro.CONEXAO.conexaoBancoDados;
import controlefinanceiro.MODEL.LivroCaixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class LivroCaixaDao {

    public void entrada(LivroCaixa livroCaixa) {

        Connection con = conexaoBancoDados.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("INSERT INTO livrocaixa(descricao,entrada,dataentrada) values (?,?,?);");
            pstm.setString(1, livroCaixa.getDescricao());
            pstm.setDouble(2, livroCaixa.getEntrada());
            pstm.setDate(3, livroCaixa.getDataEntrada());

            pstm.execute();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexaoBancoDados.closeConnection(con, pstm);
        }
    }

    public void saida(LivroCaixa livroCaixa) {
        Connection con = conexaoBancoDados.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("INSERT INTO livrocaixa(descricao,saida,datasaida) values (?,?,?);");
            pstm.setString(1, livroCaixa.getDescricao());
            pstm.setDouble(2, livroCaixa.getSaida());
            pstm.setDate(3, livroCaixa.getDataSaida());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexaoBancoDados.closeConnection(con, pstm);
        }
    }

    public void alterar(LivroCaixa livroCaixa) {
        Connection con = conexaoBancoDados.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("UPDATE livrocaixa set datahora = ? , descricao = ?, entrada = ?,Dataentrada = ?, saida = ?, datasaida = ? where id = ?;");

            pstm.setTimestamp(1, livroCaixa.getDatahora());
            pstm.setString(2, livroCaixa.getDescricao());
            pstm.setDouble(3, livroCaixa.getEntrada());
            pstm.setDate(4, livroCaixa.getDataEntrada());
            pstm.setDouble(5, livroCaixa.getSaida());
            pstm.setDate(6, livroCaixa.getDataSaida());
            pstm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexaoBancoDados.closeConnection(con, pstm);
        }
    }

    public void remover(LivroCaixa livroCaixa) {
        Connection con = conexaoBancoDados.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareCall("DELETE FROM livrocaixa where id = ?;");
            pstm.setLong(1, livroCaixa.getId());

            pstm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ErroSql) {

            JOptionPane.showMessageDialog(null, "Erro ao Remover:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexaoBancoDados.closeConnection(con, pstm);
        }
    }

    public List<LivroCaixa> ListaLivroCaixa() {

        List<LivroCaixa> controleLivrosCaixa = new ArrayList<>();

        Connection con = conexaoBancoDados.getConnection();

        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = con.prepareStatement("SELECT * FROM livrocaixa");
            rs = pstm.executeQuery();
            while (rs.next()) {

                LivroCaixa controleLivroCaixa = new LivroCaixa();
                controleLivroCaixa.setId(rs.getLong("id"));
                controleLivroCaixa.setDatahora(rs.getTimestamp("datahora"));
                controleLivroCaixa.setDescricao(rs.getString("descricao"));
                controleLivroCaixa.setEntrada(rs.getDouble("entrada"));
                controleLivroCaixa.setDataEntrada(rs.getDate("dataentrada"));
                controleLivroCaixa.setSaida(rs.getDouble("saida"));
                controleLivroCaixa.setDataSaida(rs.getDate("datasaida"));

                controleLivrosCaixa.add(controleLivroCaixa);
            }
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "EERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexaoBancoDados.closeConnection(con, pstm, rs);
        }
        return controleLivrosCaixa;
    }
}
