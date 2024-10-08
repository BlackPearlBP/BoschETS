package BO;

public class User {
    private long cpf;
    public long getCpf() {
        return cpf;
    }
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    private String nome;
    
    private String endereco1;
    public String getEndereco1() {
        return endereco1;
    }
    public void setEndereco1(String endereco1) {
        this.endereco1 = endereco1;
    }
    private String endereco2;
    public String getEndereco2() {
        return endereco2;
    }
    public void setEndereco2(String endereco2) {
        this.endereco2 = endereco2;
    }
    private String bairro;
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    private String cidade;
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    private String estado;
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    private int cep;
    public int getCep() {
        return cep;
    }
    public void setCep(int cep) {
        this.cep = cep;
    }
    private int idade;
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    private boolean primeira_compra;
    public boolean isPrimeira_compra() {
        return primeira_compra;
    }
    public void setPrimeira_compra(boolean primeira_compra) {
        this.primeira_compra = primeira_compra;
    }
    private String data_nascimento;
    public String getData_nascimento() {
        return data_nascimento;
    }
    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
