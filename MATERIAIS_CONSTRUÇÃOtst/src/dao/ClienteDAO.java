package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Connection.DBConnection;
import Entities.Cliente;
import Entities.Endereco;

public class ClienteDAO {
    public void insertClient(Cliente cliente, Endereco endereco) {
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false);

            String sqlEndereco = "INSERT INTO ENDERECO (idENDERECO, numeroENDERECO, logradouroENDERECO, bairroENDERECO, cidadeENDERECO, UF_ENDERECO) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmtEndereco = conn.prepareStatement(sqlEndereco);
            stmtEndereco.setInt(1, endereco.getId());
            stmtEndereco.setInt(2, endereco.getNumero());
            stmtEndereco.setString(3, endereco.getLogradouro());
            stmtEndereco.setString(4, endereco.getBairro());
            stmtEndereco.setString(5, endereco.getCidade());
            stmtEndereco.setString(6, endereco.getUf());
            stmtEndereco.executeUpdate();

            String sqlCliente = "INSERT INTO CLIENTE (idCliente, nomeCliente, rgCliente, cpfCliente, ENDERECO_idENDERECO) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmtCliente = conn.prepareStatement(sqlCliente);
            stmtCliente.setInt(1, cliente.getIdCliente());
            stmtCliente.setString(2, cliente.getNomeCliente());
            stmtCliente.setString(3, cliente.getRgCliente());
            stmtCliente.setString(4, cliente.getCpfCliente());
            stmtCliente.setInt(5, endereco.getId());
            stmtCliente.executeUpdate();

            conn.commit();
            System.out.println("Cliente e Endereço inseridos com sucesso!");
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            System.out.println("Erro ao inserir cliente e endereço: " + e.getMessage());
        } finally {
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
