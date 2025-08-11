public class Aluno extends Pessoa {
    private Plano plano;

    public Aluno(String nome, int idade, String email, String telefone){
        super(nome, idade, email, telefone);
        this.plano = null;
    }
    public Plano getPlano(){
        return plano;
    }
    public void setPlano(Plano plano){
        this.plano = plano;
    }
    public boolean temPlano(){
        return plano != null;
    }
    public void removerPlano(){
        this.plano = null;
    }
    public void visualizarInformacoesDoPlano(){
        if(plano == null){
            System.out.println("Nenhum plano atribuído.");
            return;
        }
        System.out.println("Nome do Plano: " + plano.getNome());
        System.out.println("Preço: " + plano.getPreco());
        System.out.println("Duração: " + plano.getDuracaoMeses() + " meses");
        System.out.println("Status: " + (plano.estaAtivo() ? "Ativo" : "Inativo"));
    }
}
