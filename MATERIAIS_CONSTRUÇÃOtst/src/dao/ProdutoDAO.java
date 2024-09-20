package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection.DBConnection;
import Entities.Produto;

public class ProdutoDAO {  
    public void inserirProduto(Produto produto) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBConnection.getConnection();
            String sql = "INSERT INTO PRODUTO (codigoPRODUTO, descricaoPRODUTO, preco_unitarioPRODUTO) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, produto.getCodigoProduto());
            stmt.setString(2, produto.getDescricaoProduto());
            stmt.setFloat(3, produto.getPrecoUnitarioProduto());
            stmt.executeUpdate();
            System.out.println("Produto inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Produto buscarProdutoPorCodigo(int codigo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Produto produto = null;

        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT * FROM PRODUTO WHERE codigoPRODUTO = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codigo);
            rs = stmt.executeQuery();

            if (rs.next()) {
                produto = new Produto(
                    rs.getInt("codigoPRODUTO"),
                    rs.getString("descricaoPRODUTO"),
                    rs.getFloat("preco_unitarioPRODUTO")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar produto: " + e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return produto;
    }
}
