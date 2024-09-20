package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Connection.DBConnection;
import Entities.Compra;

public class CompraDAO {
    public void realizarCompra(Compra compra) {
        Connection conn = null;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO Compra (idCompra, codigoPRODUTO, idCLIENTE, quantidade_produtosCOMPRA, valorTotalCOMPRA) VALUES (?, ?, ?, ?, ?)";

        try {
            conn = DBConnection.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, compra.getIdCompra());
            stmt.setInt(2, compra.getCodigoProduto());
            stmt.setInt(3, compra.getIdCliente());
            stmt.setInt(4, compra.getQuantidadeProdutosCompra());
            stmt.setFloat(5, compra.getValorTotalCompra());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao realizar compra: " + e.getMessage());
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
}
