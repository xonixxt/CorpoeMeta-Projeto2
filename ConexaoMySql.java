import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class ConexaoMySql{
    private static final String URL = "jdbc:mysql://localhost:3306/corpoemeta";
    private static final String USER = "root";
    private static final String PASS = "root";

    public void adicionarBD(Pessoa pessoa){
        String sql = "INSERT INTO Pessoa (nome, idade, email, telefone, ativo) VALUES (?, ?, ?, ?, ?)";
        try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getIdade());
            stmt.setString(3, pessoa.getEmail());
            stmt.setString(4, pessoa.getTelefone());
            stmt.setBoolean(5, pessoa.estaAtivo());

            stmt.executeUpdate();
            System.out.println("Pessoa adicionada com sucesso ao Banco de Dados.");
        }catch(SQLException exception){
            System.out.println("Erro ao adicionar pessoa: " + exception.getMessage());
        }
    }
}