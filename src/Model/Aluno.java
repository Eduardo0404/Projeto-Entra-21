package Model;

import java.sql.Date;

public class Aluno {
    
    // VARIAVEIS
    private String nome;
    private String cpf;
    private String email;
    private Date   dataNascimento;
    private String sexo;
    private String rg;
    private String senha;
    private String nomeResponsavel;
    private String fone;
    private Date   dataEfetivada;    

    public Aluno() {}

    public Aluno(String nome, String cpf, String email, Date dataNascimento, String sexo, String rg, String nomeResponsavel, String senha, String fone, Date dataEfetivada) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.rg = rg;
        this.nomeResponsavel = nomeResponsavel;
        this.senha = senha;
        this.fone = fone;
        this.dataEfetivada = dataEfetivada;
    }
      
    
    // GETTERS AND SETTERS
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public Date getDataEfetivada() {
        return dataEfetivada;
    }

    public void setDataEfetivada(Date dataEfetivada) {
        this.dataEfetivada = dataEfetivada;
    }

    @Override
    public String toString() {
        return "Aluno{" + "nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo + ", rg=" + rg + ", nomeResponsavel=" + nomeResponsavel + ", senha=" + senha + ", fone=" + fone + ", dataEfetivada=" + dataEfetivada + '}';
    }
    
    
    
} // FINAL
