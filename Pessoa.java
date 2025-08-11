public class Pessoa {
    private static int proximoId = 0;
    private final int id;
    private String nome;
    private int idade;
    private String email;
    private String telefone;
    private boolean ativo;

    public Pessoa(String nome, int idade, String email, String telefone){
        validarNome(nome);
        validarIdade(idade);
        validarEmail(email);
        validarTelefone(telefone);
        this.id = ++proximoId;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.telefone = telefone;
        this.ativo = false;
    }
    private void validarNome(String nome){
        if(nome == null || nome.isBlank()){
            throw new IllegalArgumentException("Nome inválido.");
        }
    }
    private void validarIdade(int idade){
        if(idade <= 0){
            throw new IllegalArgumentException("Idade deve ser positiva.");
        }
    }
    private void validarEmail(String email){
        if(email == null || !email.contains("@")){
            throw new IllegalArgumentException("Email inválido.");
        }
    }
    private void validarTelefone(String telefone){
        if(telefone == null || !telefone.matches("\\d{11}")){
            throw new IllegalArgumentException("Telefone deve ter 11 dígitos, somente números.");
        }
    }
    public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public int getIdade(){
        return idade;
    }
    public String getEmail(){
        return email;
    }
    public String getTelefone(){
        return telefone;
    }
    public boolean estaAtivo(){
        return ativo;
    }
    public void setAtivo(boolean ativo){
        this.ativo = ativo;
    }
    public void setIdade(int idade){
        validarIdade(idade);
        this.idade = idade;
    }
    public void setEmail(String email){
        validarEmail(email);
        this.email = email;
    }
    public void setTelefone(String telefone){
        validarTelefone(telefone);
        this.telefone = telefone;
    }
}
