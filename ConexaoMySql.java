import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConexaoMySql {
private static final String URL = "jdbc:mysql://localhost:3306/corpoemeta";
private static final String USER = "root";
private static final String PASSWORD = "root";

public void testandoConexao(){
    try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
        System.out.println("Conexão estabelecida com sucesso.");
    }
    catch (SQLException exception){
        System.out.println("Erro ao estabelecer conexão: " + exception.getMessage());
    }
}
}
