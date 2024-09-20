package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Entities.Cliente;
import Entities.Endereco;
import Entities.Produto;

public class DBConnection {
	private static Connection conn;

	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/MATERIAIS_CONSTRUCAO2";
		String user = "developer";
		String password = "@05Outubro";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println("Conexão estabelecida com sucesso");
			return connection;
		} catch (ClassNotFoundException e) {
			System.err.println("\nDriver JBDC não encontrado:" + e.getMessage());
			throw new RuntimeException(e);
		} catch(SQLException e) {
			System.err.println("\nErro ao estabelecer conexão com o banco de dados" + e.getMessage());
			throw new RuntimeException(e);
		}
	}
}

