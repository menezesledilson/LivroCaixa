package financeiro.DAO;

import Conexao.conexao;
import financeiro.MODEL.Vendas;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;

public class VendaDao {

    public void adicionar(Vendas vendas) {

        Connection con = conexao.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("INSERT INTO venda (cliente,celular,datavenda,nomecarro,anocarro,placacarro,chassicarro,pagamento,comissao,observacao) values (?,?,?,?,?,?,?,?,?,?)");
            pstm.setString(1, vendas.getNomeCliente());
            pstm.setString(2, vendas.getCelular());
            pstm.setString(3, vendas.getDataVenda());
            pstm.setString(4, vendas.getModelCarro());
            pstm.setInt(5, vendas.getAnoCarro());
            pstm.setString(6, vendas.getPlacaCarro());
            pstm.setString(7, vendas.getChassi());
            pstm.setString(8, vendas.getStatus());
            pstm.setDouble(9, vendas.getComissao());
            pstm.setString(10, vendas.getObservacao());

            pstm.execute();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm);
        }
    }

    public void alterar(Vendas vendas) {
        Connection con = conexao.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = con.prepareStatement("UPDATE venda SET cliente=?, celular=?, datavenda=?, nomecarro=?, anocarro=?, placacarro=?, chassicarro=?, pagamento=?, comissao=?, observacao=? WHERE id=?");

            pstm.setString(1, vendas.getNomeCliente());
            pstm.setString(2, vendas.getCelular());
            pstm.setString(3, vendas.getDataVenda());
            pstm.setString(4, vendas.getModelCarro());
            pstm.setInt(5, vendas.getAnoCarro());
            pstm.setString(6, vendas.getPlacaCarro());
            pstm.setString(7, vendas.getChassi());
            pstm.setString(8, vendas.getStatus());
            pstm.setDouble(9, vendas.getComissao());
            pstm.setString(10, vendas.getObservacao());
            pstm.setLong(11, vendas.getId());  // Adicionei a definição do ID (ou o nome correto, se for diferente)

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ErroSql) {
            ErroSql.printStackTrace();  // Adicionei a impressão do rastreamento de pilha
            JOptionPane.showMessageDialog(null, "Erro ao alterar no banco.", "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm);
        }
    }

    public void remover(Vendas vendas) {
        Connection con = conexao.getConnection();
        PreparedStatement pstm = null;
        try {

            pstm = con.prepareStatement("DELETE FROM venda WHERE id = ?");
            pstm.setLong(1, vendas.getId());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ErroSql) {

            JOptionPane.showMessageDialog(null, "Erro ao Remover:" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm);
        }
    }

    public List<Vendas> listaVenda() {

        List<Vendas> controleVendas = new ArrayList<>();
        Connection con = conexao.getConnection();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = con.prepareStatement("SELECT id, cliente, celular, datavenda, nomecarro, anocarro, placacarro, chassicarro, pagamento, comissao, observacao FROM venda  order by id DESC; ");
            rs = pstm.executeQuery();
            while (rs.next()) {

                Vendas controleVenda = new Vendas();
                controleVenda.setId(rs.getLong("id"));
                controleVenda.setNomeCliente(rs.getString("cliente"));
                controleVenda.setCelular(rs.getString("celular"));
                controleVenda.setDataVenda(rs.getString("datavenda"));
                controleVenda.setModelCarro(rs.getString("nomecarro"));
                controleVenda.setAnoCarro(rs.getInt("anocarro"));
                controleVenda.setPlacaCarro(rs.getString("placacarro"));
                controleVenda.setChassi(rs.getString("chassicarro"));
                controleVenda.setStatus(rs.getString("pagamento"));
                controleVenda.setComissao(rs.getDouble("comissao"));
                controleVenda.setObservacao(rs.getString("observacao"));

                controleVendas.add(controleVenda);
            }
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "EERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm, rs);
        }
        return controleVendas;
    }
}
