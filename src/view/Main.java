package view;
import dao.UsuarioDao;
import model.Usuario;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
    	exibirMenu();
    }
    
    private static void exibirMenu() {
    	UsuarioDao dao = new UsuarioDao();
        while (true) {
            String[] opcoes = {"Salvar usuário", "Listar usuários", "Buscar por e-mail", "Sair"};
            int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu de Usuários",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            switch (escolha) {
                case 0:
                    String email = JOptionPane.showInputDialog("Digite o e-mail:");
                    String senha = JOptionPane.showInputDialog("Digite a sua senha:");
                    Usuario usuario = new Usuario(email, senha);
                    dao.addUsuario(usuario);
                    JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso!");
                    break;
                case 1:
                	if (dao.listarUsuarios().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhum usuário cadastrado.");
                    } else {
                        StringBuilder mensagem = new StringBuilder("Lista de usuários:\n");
                        List<Usuario> listaUsuarios = dao.listarUsuarios();
                        for (Usuario usuario1 : listaUsuarios ) {
                            mensagem.append(usuario1.toString()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, mensagem.toString());
                    }
                    break;
                case 2:
                 
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saindo do programa.");
                    System.exit(0);
            }
        }
    }
    
}