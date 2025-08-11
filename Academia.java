import java.util.ArrayList;

public class Academia {
    private ArrayList<Pessoa> pessoas = new ArrayList<>();
    private ArrayList<Plano> planos = new ArrayList<>();

    public void adicionarPessoa(Pessoa pessoa){
        for(Pessoa p : pessoas){
            if(p.getId() == pessoa.getId()){
                throw new IllegalArgumentException("Pessoa já cadastrada. ID: " + pessoa.getId());
            }
        }
        pessoas.add(pessoa);
        System.out.println("Pessoa adicionada. ID: " + pessoa.getId());
    }
    public void removerPessoa(Pessoa pessoa){
        boolean removido = pessoas.removeIf(p -> p.getId() == pessoa.getId());
        if(removido){
            System.out.println("Pessoa removida. ID: " + pessoa.getId());
        }else{
            System.out.println("Pessoa não encontrada para remoção. ID: " + pessoa.getId());
        }
    }
    public void listarPessoas(){
        if(pessoas.isEmpty()){
            System.out.println("Nenhuma pessoa cadastrada.");
            return;
        }
        System.out.println("=== Pessoas cadastradas ===");
        for(Pessoa p : pessoas){
            System.out.println("ID: " + p.getId() + ", Nome: " + p.getNome() + ", Ativo: " + p.estaAtivo());
        }
    }
    public void adicionarPlano(Plano plano){
        for(Plano p : planos){
            if(p.getNome().equalsIgnoreCase(plano.getNome())){
                throw new IllegalArgumentException("Plano já existe: " + plano.getNome());
            }
        }
        planos.add(plano);
        System.out.println("Plano adicionado: " + plano.getNome());
    }
    public void removerPlano(Plano plano){
        boolean removido = planos.removeIf(p -> p.getNome().equalsIgnoreCase(plano.getNome()));
        if(removido){
            System.out.println("Plano removido: " + plano.getNome());
        }else{
            System.out.println("Plano não encontrado: " + plano.getNome());
        }
    }
    public void listarPlanos(){
        if(planos.isEmpty()){
            System.out.println("Nenhum plano cadastrado.");
            return;
        }
        System.out.println("=== Planos disponíveis ===");
        for(Plano p : planos){
            System.out.println("Nome: " + p.getNome() + ", Preço: " + p.getPreco());
        }
    }
    public void ativarPessoa(Pessoa pessoa){
        if(pessoa.estaAtivo()){
            throw new IllegalArgumentException("Pessoa já está ativa. ID: " + pessoa.getId());
        }
        pessoa.setAtivo(true);
        System.out.println("Pessoa ativada. ID: " + pessoa.getId());
    }
    public void desativarPessoa(Pessoa pessoa){
        if(!pessoa.estaAtivo()){
            throw new IllegalArgumentException("Pessoa já está inativa. ID: " + pessoa.getId());
        }
        pessoa.setAtivo(false);
        System.out.println("Pessoa desativada. ID: " + pessoa.getId());
    }
    public void atualizarInformacoesPessoa(Pessoa pessoa, Integer novaIdade, String novoTelefone, String novoEmail){
        boolean atualizado = false;
        if(novaIdade != null && pessoa.getIdade() != novaIdade){
            pessoa.setIdade(novaIdade);
            atualizado = true;
        }
        if(novoTelefone != null && !pessoa.getTelefone().equals(novoTelefone)){
            pessoa.setTelefone(novoTelefone);
            atualizado = true;
        }
        if(novoEmail != null && !pessoa.getEmail().equals(novoEmail)){
            pessoa.setEmail(novoEmail);
            atualizado = true;
        }
        if(!atualizado){
            throw new IllegalArgumentException("Nenhuma informação nova para atualizar.");
        }
        System.out.println("Informações da pessoa atualizadas. ID: " + pessoa.getId());
    }
    public void atribuirPlanoParaPessoa(int idPessoa, Plano plano){
        Pessoa pessoa = buscarPessoaPorId(idPessoa);
        if(!pessoa.estaAtivo()){
            throw new IllegalArgumentException("Pessoa inativa. ID: " + idPessoa);
        }
        if(pessoa instanceof Aluno){
            Aluno aluno = (Aluno) pessoa;
            if(aluno.temPlano()){
                throw new IllegalArgumentException("Pessoa já tem plano. ID: " + idPessoa);
            }
            aluno.setPlano(plano);
            System.out.println("Plano atribuído à pessoa ID: " + idPessoa);
        }else{
            throw new IllegalArgumentException("Somente alunos podem ter planos.");
        }
    }
    public void alterarPlano(int idPessoa, Plano novoPlano){
        Pessoa pessoa = buscarPessoaPorId(idPessoa);
        if(!pessoa.estaAtivo()){
            throw new IllegalArgumentException("Pessoa inativa. ID: " + idPessoa);
        }
        if(pessoa instanceof Aluno){
            Aluno aluno = (Aluno) pessoa;
            if(!aluno.temPlano()){
                throw new IllegalArgumentException("Pessoa não tem plano para alterar. ID: " + idPessoa);
            }
            aluno.setPlano(novoPlano);
            System.out.println("Plano alterado para pessoa ID: " + idPessoa);
        }else{
            throw new IllegalArgumentException("Somente alunos podem ter planos.");
        }
    }
    public void removerPlanoDePessoa(int idPessoa){
        Pessoa pessoa = buscarPessoaPorId(idPessoa);
        if(!pessoa.estaAtivo()){
            throw new IllegalArgumentException("Pessoa inativa. ID: " + idPessoa);
        }
        if(pessoa instanceof Aluno){
            Aluno aluno = (Aluno) pessoa;
            if(!aluno.temPlano()){
                throw new IllegalArgumentException("Pessoa não tem plano para remover. ID: " + idPessoa);
            }
            aluno.removerPlano();
            System.out.println("Plano removido da pessoa ID: " + idPessoa);
        }else{
            throw new IllegalArgumentException("Somente alunos podem ter planos.");
        }
    }
    public void consultarPlanoDaPessoa(int idPessoa){
        Pessoa pessoa = buscarPessoaPorId(idPessoa);
        if(pessoa instanceof Aluno){
            Aluno aluno = (Aluno) pessoa;
            if(!aluno.temPlano()){
                System.out.println("Pessoa não possui plano. ID: " + idPessoa);
                return;
            }
            Plano plano = aluno.getPlano();
            System.out.println("Informações do plano da pessoa ID: " + idPessoa);
            System.out.println("Nome do Plano: " + plano.getNome());
            System.out.println("Preço: " + plano.getPreco());
            System.out.println("Duração: " + plano.getDuracaoMeses() + " meses");
            System.out.println("Status: " + (plano.estaAtivo() ? "Ativo" : "Inativo"));
        }else{
            System.out.println("Somente alunos possuem planos.");
        }
    }
    public Pessoa buscarPessoaPorId(int id){
        for(Pessoa p : pessoas){
            if(p.getId() == id){
                return p;
            }
        }
        throw new IllegalArgumentException("Pessoa não encontrada. ID: " + id);
    }
}
