package financeiro.DAO;


import Conexao.conexao;
import financeiro.MODEL.LivroCaixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class LivroCaixaDao {

    public void entrada(LivroCaixa livroCaixa) {

        Connection con = conexao.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("INSERT INTO livrocaixa(descricao,entrada,observacao) values (?,?,?);");
            pstm.setString(1, livroCaixa.getDescricao());
            pstm.setDouble(2, livroCaixa.getEntrada());
            pstm.setString(3, livroCaixa.getObservacao());

            pstm.execute();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm);
        }
    }

    public void saida(LivroCaixa livroCaixa) {
        Connection con = conexao.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("INSERT INTO livrocaixa(descricao,saida,observacao) values (?,?,?);");
            pstm.setString(1, livroCaixa.getDescricao());
            pstm.setDouble(2, livroCaixa.getSaida());
            pstm.setString(3, livroCaixa.getObservacao());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm);
        }
    }

    public void alterarLivroCaixa(LivroCaixa livroCaixa) {
        Connection con = conexao.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("UPDATE livrocaixa SET descricao = ?, entrada = ?, saida = ?, observacao = ? WHERE id = ?;");
            pstm.setString(1, livroCaixa.getDescricao());
            pstm.setDouble(2, livroCaixa.getEntrada());
            pstm.setDouble(3, livroCaixa.getSaida());
            pstm.setString(4, livroCaixa.getObservacao());
            pstm.setLong(5, livroCaixa.getId());

            pstm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm);
        }
    }

    public void remover(LivroCaixa livroCaixa) {
        Connection con = conexao.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareCall("DELETE FROM livrocaixa where id = ?;");
            pstm.setLong(1, livroCaixa.getId());

            pstm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ErroSql) {

            JOptionPane.showMessageDialog(null, "Erro ao Remover:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm);
        }
    }

    public List<LivroCaixa> ListaLivroCaixa() {

        List<LivroCaixa> controleLivrosCaixa = new ArrayList<>();

        Connection con = conexao.getConnection();

        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = con.prepareStatement("SELECT id, datahora, descricao, entrada, saida, observacao FROM livrocaixa order by id DESC; ");
            rs = pstm.executeQuery();
            while (rs.next()) {

                LivroCaixa controleLivroCaixa = new LivroCaixa();
                controleLivroCaixa.setId(rs.getLong("id"));
                controleLivroCaixa.setDatahora(rs.getTimestamp("datahora"));
                controleLivroCaixa.setDescricao(rs.getString("descricao"));
                controleLivroCaixa.setEntrada(rs.getDouble("entrada"));
                controleLivroCaixa.setSaida(rs.getDouble("saida"));
                controleLivroCaixa.setObservacao(rs.getString("observacao"));

                controleLivrosCaixa.add(controleLivroCaixa);
            }
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "EERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm, rs);
        }
        return controleLivrosCaixa;
    }
}
