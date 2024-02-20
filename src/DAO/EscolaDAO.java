package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Util.Conexao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Model.Escola;

public class EscolaDAO {
    
    // MÉTODOS
    public boolean AdicionarAluno(Escola escola) {
        
        // comandos banco de dados
        String sql  = "INSERT INTO Escola ";
                   sql += "(nome, cpf, email, dataNascimento, sexo, rg, nomeResponsavel, fone, dataEfetivada) ";
                   sql += "VALUES(?,?,?,?,?,?,?,?,?)";
        // conectando no banco de dados
        Connection con = Conexao.Conectar();
        
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, escola.getNome());
            stm.setString(2, escola.getCpf());
            stm.setString(3, escola.getEmail());
            stm.setDate(4, escola.getDataNascimento());
            stm.setString(5, escola.getSexo());
            stm.setString(6, escola.getRg());
            stm.setString(7, escola.getNomeResponsavel());
            stm.setString(8, escola.getFone());
            stm.setDate(9, escola.getDataEfetivada());
            stm.execute();
            
        } catch (SQLException ex) {
          System.out.println("Erro:" + ex.getMessage());
          return false;
        }
        return true;
    }
    
    public List<Escola> ListarAluno() {
        List<Escola> lista = new ArrayList<>();               
        // conectando no banco de dados
        Connection con = Conexao.Conectar();
        // comandos banco de dados
        String sql = "select * from Escola order by cpf";
        
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
               Escola escola = new Escola();
                   escola.setNome(rs.getString("nome"));
                   escola.setCpf(rs.getString("cpf"));
                   escola.setEmail(rs.getString("email"));
                   escola.setDataNascimento(rs.getDate("dataNascimento"));
                   escola.setSexo(rs.getString("sexo"));
                   escola.setRg(rs.getString("rg"));
                   escola.setNomeResponsavel(rs.getString("nomeResponsavel"));
                   escola.setFone(rs.getString("fone"));
                   escola.setDataEfetivada(rs.getDate("dataEfetivada"));
               lista.add(escola);
            }
            
        } catch (SQLException ex) {
          System.out.println("Erro:" + ex.getMessage());
        }
        return lista;
    }
    
    public boolean AlterarAluno(Escola escola) {
        // comandos banco de dados
        String sql  = "UPDATE Escola ";
                   sql += "set nome            = ? ,";                 
                   sql += "    email           = ? ,";
                   sql += "    dataNascimento  = ? ,";
                   sql += "    sexo            = ? ,";                   
                   sql += "    rg              = ? ,";
                   sql += "    nomeResponsavel = ? ,";               
                   sql += "    fone            = ? ,";
                   sql += "    dataEfetivada   = ? ";  
                   sql += "    where cpf       = ? ";
        // conectando no banco de dados
        Connection con = Conexao.Conectar();

        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, escola.getNome());
            stm.setString(2, escola.getEmail());
            stm.setDate(3, escola.getDataNascimento());
            stm.setString(4, escola.getSexo());
            stm.setString(5, escola.getRg());
            stm.setString(6, escola.getNomeResponsavel());
            stm.setString(7, escola.getFone());
            stm.setDate(8, escola.getDataEfetivada());
            stm.setString(9, escola.getCpf());
            stm.execute();
            
        } catch (SQLException ex) {
          System.out.println("Erro:" + ex.getMessage());
          return false;
        }
        return true;
    }
    
    public boolean excluirAluno(Escola escola) {
        // comandos banco de dados
        String sql  = "DELETE FROM Escola ";
               sql += "WHERE cpf = ? ";
        // conectando no banco de dados
        Connection con = Conexao.Conectar();
        
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, escola.getCpf());
            stm.execute();
            
        } catch (SQLException ex) {
          System.out.println("Erro:" + ex.getMessage());
          return false;
        }
        return true;
    }

} // FINAL
