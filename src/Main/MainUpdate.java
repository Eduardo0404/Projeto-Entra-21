package Main;

import DAO.AlunoDAO;
import Model.Aluno;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;

public class MainUpdate {

    public static void main(String[] args) {

        Aluno aluno = new Aluno();
        AlunoDAO alunoDAO = new AlunoDAO();
                
        aluno.setNome("Edu");
        aluno.setCpf("111.111.111-11");
        aluno.setEmail("orthmann2811@gmail.com");
        LocalDate DataNascimento = LocalDate.of(2003, Month.NOVEMBER, 27);
        aluno.setSexo("masculino");
        aluno.setRg("1.111.111");
        aluno.setNomeResponsavel("Leticia Ribeiro");
        aluno.setSenha("1234");
        aluno.setFone("(11)11111-1111");
        LocalDate DataEfetivada = LocalDate.now();
        
        //tratamento de data
        Date dataEfetivada = java.sql.Date.valueOf(DataEfetivada);
        Date dataNascimento = java.sql.Date.valueOf(DataNascimento);
        
        aluno.setDataNascimento(dataNascimento);
        aluno.setDataEfetivada(dataEfetivada);
        
        if (alunoDAO.AlterarAluno(aluno)) {
            System.out.println("Registro Alterado com sucesso");
        };

    } // FINAL
} // FINAL
