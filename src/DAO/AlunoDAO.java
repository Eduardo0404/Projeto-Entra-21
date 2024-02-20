package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Util.Conexao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Model.Aluno;

public class AlunoDAO {



   
    
    // MÉTODOS
    //                                          ADICIONAR
    public boolean AdicionarAluno(Aluno aluno) {
        
        // comandos banco de dados
        String sql  = "INSERT INTO Aluno ";
                   sql += "(nome, cpf, email, dataNascimento, sexo, rg, nomeResponsavel, senha, fone, dataEfetivada) ";
                   sql += "VALUES(?,?,?,?,?,?,?,?,?,?)";
        // conectando no banco de dados
        Connection con = Conexao.Conectar();
        
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, aluno.getNome());
            stm.setString(2, aluno.getCpf());
            stm.setString(3, aluno.getEmail());
            stm.setDate(4,   aluno.getDataNascimento());
            stm.setString(5, aluno.getSexo());
            stm.setString(6, aluno.getRg());
            stm.setString(7, aluno.getNomeResponsavel());
            stm.setString(8, aluno.getSenha());
            stm.setString(9, aluno.getFone());
            stm.setDate(10, aluno.getDataEfetivada());
            stm.execute();
            
        } catch (SQLException ex) {
          System.out.println("Erro:" + ex.getMessage());
          return false;
        }
        return true;
    }
    //                                          LISTAR
    public List<Aluno> ListarAluno() {
        List<Aluno> lista = new ArrayList<>();               
        // conectando no banco de dados
        Connection con = Conexao.Conectar();
        // comandos banco de dados
        String sql = "select * from Aluno order by cpf";
        
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
               Aluno aluno = new Aluno();
                   aluno.setNome(rs.getString("nome"));
                   aluno.setCpf(rs.getString("cpf"));
                   aluno.setEmail(rs.getString("email"));
                   aluno.setDataNascimento(rs.getDate("dataNascimento"));
                   aluno.setSexo(rs.getString("sexo"));
                   aluno.setRg(rs.getString("rg"));
                   aluno.setNomeResponsavel(rs.getString("nomeResponsavel"));
                   aluno.setSenha(rs.getString("senha"));
                   aluno.setFone(rs.getString("fone"));
                   aluno.setDataEfetivada(rs.getDate("dataEfetivada"));
               lista.add(aluno);
            }
            
        } catch (SQLException ex) {
          System.out.println("Erro:" + ex.getMessage());
        }
        return lista;
    }
    //                                          ALTERAR
    public boolean AlterarAluno(Aluno aluno) {
        // comandos banco de dados
        String sql  = "UPDATE Aluno ";
                   sql += "set nome            = ? ,";                 
                   sql += "    email           = ? ,";
                   sql += "    dataNascimento  = ? ,";
                   sql += "    sexo            = ? ,";                   
                   sql += "    rg              = ? ,";
                   sql += "    nomeResponsavel = ? ,";
                   sql += "    senha           = ? ,";                   
                   sql += "    fone            = ? ,";
                   sql += "    dataEfetivada   = ? ";  
                   sql += "    where cpf = ? ";
        // conectando no banco de dados
        Connection con = Conexao.Conectar();

        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, aluno.getNome());
            stm.setString(2, aluno.getEmail());
            stm.setDate(3, aluno.getDataNascimento());
            stm.setString(4, aluno.getSexo());
            stm.setString(5, aluno.getRg());
            stm.setString(6, aluno.getNomeResponsavel());
            stm.setString(7, aluno.getSenha());
            stm.setString(8, aluno.getFone());
            stm.setDate(9, aluno.getDataEfetivada());
            stm.setString(10, aluno.getCpf());
            stm.execute();
            
        } catch (SQLException ex) {
          System.out.println("Erro:" + ex.getMessage());
          return false;
        }
        return true;
    }
    //                                          EXCLUIR
    public boolean removerAluno(String cpf) {
        Aluno aluno = new Aluno();
        cpf = aluno.getCpf();
        // comandos banco de dados
        String sql  = "DELETE FROM Aluno ";
               sql += "WHERE cpf = ? ";
        // conectando no banco de dados
        Connection con = Conexao.Conectar();
        
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, cpf);
            stm.execute();
            return true;
        } catch (SQLException ex) {
          System.out.println("Erro:" + ex.getMessage());
          return false;
        
        }
        
    }
    //                                          VALIDAR
    public boolean validarLogin (String email, String senha){
    // Manda como parametro para ele duas variaveis para ele procurar no banco de dados!
 
            boolean existe = false;
            String sql = "select email, senha from Aluno where email = ? and senha = ?";
            Connection con = Conexao.Conectar();
            
            try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, email);
            stm.setString(2, senha);
            ResultSet rs = stm.executeQuery();
            
            if (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setEmail(rs.getString("email"));
                aluno.setSenha(rs.getString("senha"));
                existe = true;
            }
            
            } catch (SQLException ex) {
          System.out.println("Erro:" + ex.getMessage());
          return false;
        }
 
            return existe;
    }

    

    

} // FINAL
