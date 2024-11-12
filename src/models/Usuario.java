package models;

public class Usuario {

    private String nome;
    private String cpf;
    private int idade;

    public Usuario (String nome, String cpf, int idade){
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return STR."\{nome};\{cpf};\{idade}";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void getInfo(){
        System.out.println("--------------------------------");
        System.out.println("NOME: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("IDADE: " + idade);
        System.out.println("--------------------------------");
    }
}
