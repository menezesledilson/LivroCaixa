package financeiro.DAO;

import Conexao.conexao;
import financeiro.MODEL.Boleto;
import financeiro.MODEL.LivroCaixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BoletoDao {

    public void adicionar(Boleto boleto) {
        Connection con = conexao.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("INSERT INTO boletos(descricao,valor,datavencimento,datapagamento,statuspagamento,observacao) values (?,?,?,?,?,?);");
            pstm.setString(1, boleto.getDescricao());
            pstm.setDouble(2, boleto.getValor());
            pstm.setString(3, boleto.getDataVencimento());
            pstm.setString(4, boleto.getDataPagamento());
            pstm.setString(5, boleto.getStatusPag());
            pstm.setString(6, boleto.getObservacao());

            pstm.execute();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm);
        }
    }

    public void alterar(Boleto boleto) {
        Connection con = conexao.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("UPDATE boletos SET descricao =?,valor = ?,datavencimento =?,datapagamento =?,statuspagamento =?,observacao=? WHERE id = ?;");
            pstm.setString(1, boleto.getDescricao());
            pstm.setDouble(2, boleto.getValor());
            pstm.setString(3, boleto.getDataVencimento());
            pstm.setString(4, boleto.getDataPagamento());
            pstm.setString(5, boleto.getStatusPag());
            pstm.setString(6, boleto.getObservacao());
            pstm.setLong(7, boleto.getId());
            pstm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm);
        }
    }

    public void remover(Boleto boleto) {
        Connection con = conexao.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareCall("DELETE FROM boletos where id = ?;");
            pstm.setLong(1, boleto.getId());

            pstm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ErroSql) {

            JOptionPane.showMessageDialog(null, "Erro ao Remover:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm);
        }
    }

    public List<Boleto> ListaBoleto() {
        List<Boleto> controlesBoletos = new ArrayList<>();

        Connection con = conexao.getConnection();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement("SELECT id,descricao,valor,datavencimento,datapagamento,statuspagamento,observacao FROM boletos;");
            rs = pstm.executeQuery();
            while (rs.next()) {

                Boleto controleBoletos = new Boleto();

                controleBoletos.setId(rs.getLong("id"));
                controleBoletos.setDescricao(rs.getString("descricao"));
                controleBoletos.setValor(rs.getDouble("valor"));
                controleBoletos.setDataVencimento(rs.getString("datavencimento"));
                controleBoletos.setDataPagamento(rs.getString("datapagamento"));
                controleBoletos.setStatusPag(rs.getString("statuspagamento"));
                controleBoletos.setObservacao(rs.getString("observacao"));

                controlesBoletos.add(controleBoletos);

            }
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "EERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm, rs);
        }
        return controlesBoletos;
    }
}
