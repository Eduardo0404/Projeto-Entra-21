package Main;

import DAO.AlunoDAO;

public class MainValidaLogin {

    public static void main(String[] args) {
    AlunoDAO alunoDAO = new AlunoDAO();
    String email = "orthmann2811@gmail.com";
    String senha = "1234";
    
    boolean resposta = alunoDAO.validarLogin(email, senha);
    if (resposta == true){
        System.out.println("login realizado com sucesso!");
    
    }else {
        System.out.println("login não realizado!\n Favor conferir o usuario e senha digitado!");
    }
 


    } // FINAL
} // FINAL
