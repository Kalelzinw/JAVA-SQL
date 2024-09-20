package dao;

import Entities.Compra;
import Entities.Ficha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class FichaDAO {
	public FichaDAO() {
       
    }
    private Connection connection;

    public FichaDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertFicha(Ficha ficha) throws SQLException {
        String sql = "INSERT INTO FICHA_CONTROLE (numeroFICHA_CONTROLE, descricaoFICHA_CONTROLE, dataFICHA_CONTROLE, compra_idCOMPRA) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, ficha.getNumeroFichaControle());
            stmt.setString(2, ficha.getDescricaoFichaControle());
            stmt.setDate(3, new java.sql.Date(ficha.getDataFichaControle().getTime()));
           
            stmt.executeUpdate();
        }
    }
}

