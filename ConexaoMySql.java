import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexaoMySql {
    private static final String URL = "jdbc:mysql://localhost:3306/corpoemeta";
    private static final String USER = "root";
    private static final String PASS = "root";

    public void adicionarPessoaBD(Pessoa pessoa) {
        String sql = "INSERT INTO Pessoa(nome, idade, email, telefone, ativo) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getIdade());
            stmt.setString(3, pessoa.getEmail());
            stmt.setString(4, pessoa.getTelefone());
            stmt.setBoolean(5, pessoa.estaAtivo());
            stmt.executeUpdate();
            System.out.println("Pessoa adicionada com sucesso ao BD.");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar pessoa: " + e.getMessage());
        }
    }

    public void atualizarPessoaBD(Pessoa pessoa) {
        String sql = "UPDATE Pessoa SET nome = ?, idade = ?, email = ?, telefone = ?, ativo = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getIdade());
            stmt.setString(3, pessoa.getEmail());
            stmt.setString(4, pessoa.getTelefone());
            stmt.setBoolean(5, pessoa.estaAtivo());
            stmt.setInt(6, pessoa.getId());
            stmt.executeUpdate();
            System.out.println("Atualização executada com sucesso no BD.");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar pessoa: " + e.getMessage());
        }
    }

    public void removerPessoaBD(int id) {
        String sql = "DELETE FROM Pessoa WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Pessoa removida com sucesso no BD.");
        } catch (SQLException e) {
            System.out.println("Erro ao remover pessoa: " + e.getMessage());
        }
    }
}
