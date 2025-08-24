public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Johnny", 19, "jgabrielwrk@gmail.com", "83982235507");
        ConexaoMySql conexao = new ConexaoMySql();

        conexao.adicionarPessoaBD(p1);
    }
}
