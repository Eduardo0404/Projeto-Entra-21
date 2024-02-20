
package DAO;

import Model.Matricula;
import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MatriculaDAO {
    
    // MÉTODOS
    public boolean AdicionarMatricula(Matricula matricula) {
        
        // comandos banco de dados
        String sql  = "INSERT INTO Matricula ";
                   sql += "(escola,ensino,turma,turno) ";
                   sql += "VALUES(?,?,?,?)";
        // conectando no banco de dados
        Connection con = Conexao.Conectar();
        
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, matricula.getEscola());
            stm.setString(2, matricula.getEnsino());
            stm.setString(3, matricula.getTurma());
            stm.setString(4,   matricula.getTurno());
            
            stm.execute();
            
        } catch (SQLException ex) {
          System.out.println("Erro:" + ex.getMessage());
          return false;
        }
        return true;
    }
    
    public List<Matricula> ListarMatriula() {
        List<Matricula> lista = new ArrayList<>();               
        // conectando no banco de dados
        Connection con = Conexao.Conectar();
        // comandos banco de dados
        String sql = "select * from Matricula order by cpf";
        
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
               Matricula matricula = new Matricula();
                   matricula.setEscola(rs.getString("escola"));
                   matricula.setEnsino(rs.getString("ensino"));
                   matricula.setTurma(rs.getString("turma"));
                   matricula.setTurno(rs.getString("turno"));
                   lista.add(matricula);
            }
            
        } catch (SQLException ex) {
          System.out.println("Erro:" + ex.getMessage());
        }
        return lista;
    }
    
    public boolean AlterarMatricula(Matricula matricula) {
        // comandos banco de dados
        String sql  = "UPDATE Matricula ";
                   sql += "set escola            = ? ,";                 
                   sql += "    ensino            = ? ,";
                   sql += "    turma             = ? ,";
                   sql += "    turno             = ? ,";                   
                  
        // conectando no banco de dados
        Connection con = Conexao.Conectar();

        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, matricula.getEscola());
            stm.setString(2, matricula.getEnsino());
            stm.setString(3, matricula.getTurma());
            stm.setString(4, matricula.getTurno());
            stm.execute();
            
        } catch (SQLException ex) {
          System.out.println("Erro:" + ex.getMessage());
          return false;
        }
        return true;
    }
    
    public boolean excluirAluno(Matricula matricula) {
        // comandos banco de dados
        String sql  = "DELETE FROM Matricula ";
               sql += "WHERE cpf = ? ";
        // conectando no banco de dados
        Connection con = Conexao.Conectar();
        
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, matricula.getCpf());
            stm.execute();
            
        } catch (SQLException ex) {
          System.out.println("Erro:" + ex.getMessage());
          return false;
        }
        return true;
    }

} // FINAL

