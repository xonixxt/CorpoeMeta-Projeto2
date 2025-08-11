public interface InterfaceAdmin {
    void adicionarPessoa(Pessoa pessoa);
    void removerPessoa(Pessoa pessoa);
    void listarPessoas();
    void adicionarPlano(Plano plano);
    void removerPlano(Plano plano);
    void listarPlanos();
    void ativarPessoa(Pessoa pessoa);
    void desativarPessoa(Pessoa pessoa);
    void atualizarInformacoesPessoa(Pessoa pessoa, Integer novaIdade, String novoTelefone, String novoEmail);
    void adicionarPlanoPessoa(int idPessoa, Plano plano);
    void alterarPlano(int idPessoa, Plano novoPlano);
    void removerPlanoPessoa(int idPessoa);
    void consultarPlanoDaPessoa(int idPessoa);
}
