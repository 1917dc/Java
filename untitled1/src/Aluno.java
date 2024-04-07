public class Aluno {
    private String cpf;
    private String nome;
    private String dataNascimento;

    public Aluno(String cpf,  String nome, String dataNascimento) {
        setCpf(cpf);
        setNome(nome);
        setDataNascimento(dataNascimento);
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }
}
