public class Administrador extends Pessoa {
    private Academia academia;

    public Administrador(String nome, int idade, String email, String telefone, Academia academia){
        super(nome, idade, email, telefone);
        this.academia = academia;
    }

    public Pessoa buscarPessoaPorId(int id){
        return academia.buscarPessoaPorId(id);
    }

    public void adicionarPessoa(Pessoa pessoa){
        academia.adicionarPessoa(pessoa);
    }

    public void removerPessoa(Pessoa pessoa){
        academia.removerPessoa(pessoa);
    }

    public void adicionarPlano(Plano plano){
        academia.adicionarPlano(plano);
    }

    public void removerPlano(Plano plano){
        academia.removerPlano(plano);
    }

    public void listarPessoas(){
        academia.listarPessoas();
    }

    public void listarPlanos(){
        academia.listarPlanos();
    }

    public void ativarPessoa(Pessoa pessoa){
        academia.ativarPessoa(pessoa);
    }

    public void desativarPessoa(Pessoa pessoa){
        academia.desativarPessoa(pessoa);
    }

    public void atualizarInformacoesPessoa(Pessoa pessoa, Integer novaIdade, String novoTelefone, String novoEmail){
        academia.atualizarInformacoesPessoa(pessoa, novaIdade, novoTelefone, novoEmail);
    }

    public void adicionarPlanoPessoa(int idPessoa, Plano plano){
        academia.atribuirPlanoParaPessoa(idPessoa, plano);
    }

    public void alterarPlano(int idPessoa, Plano novoPlano){
        academia.alterarPlano(idPessoa, novoPlano);
    }

    public void removerPlanoPessoa(int idPessoa){
        academia.removerPlanoDePessoa(idPessoa);
    }

    public void consultarPlanoDaPessoa(int idPessoa){
        academia.consultarPlanoDaPessoa(idPessoa);
    }
}
