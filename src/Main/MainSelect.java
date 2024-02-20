package Main;

import java.util.List;
import DAO.AlunoDAO;
import Model.Aluno;

public class MainSelect {

    public static void main(String[] args) {

        AlunoDAO alunoDAO = new AlunoDAO();
        List<Aluno> lista = alunoDAO.ListarAluno();
        for (Aluno aluno : lista)
             System.out.println(aluno);


    } // FINAL
} // FINAL
