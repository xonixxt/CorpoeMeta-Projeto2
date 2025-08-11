public class Plano {
    private String nome;
    private double preco;
    private int duracaoMeses;
    private boolean ativo;

    public Plano(String nome, double preco, int duracaoMeses){
        validarNome(nome);
        validarPreco(preco);
        validarDuracao(duracaoMeses);
        this.nome = nome;
        this.preco = preco;
        this.duracaoMeses = duracaoMeses;
        this.ativo = true;
    }
    private void validarNome(String nome){
        if(nome == null || nome.isBlank()){
            throw new IllegalArgumentException("Nome do plano inválido.");
        }
    }
    private void validarPreco(double preco){
        if(preco <= 0){
            throw new IllegalArgumentException("Preço deve ser positivo.");
        }
    }
    private void validarDuracao(int duracao){
        if(duracao <= 0){
            throw new IllegalArgumentException("Duração deve ser positiva.");
        }
    }
    public String getNome(){
        return nome;
    }
    public double getPreco(){
        return preco;
    }
    public int getDuracaoMeses(){
        return duracaoMeses;
    }
    public boolean estaAtivo(){
        return ativo;
    }
    public void ativar(){
        this.ativo = true;
    }
    public void desativar(){
        this.ativo = false;
    }
}
