// /main/java/br/edu/espacos/App.java
package br.edu.espacos;

import br.edu.espacos.client.EspacosClient;
import br.edu.espacos.view.LoginFrame;
import br.edu.espacos.view.MainFrame;
import br.edu.espacos.model.Usuario;

import javax.swing.*;

public class App extends JFrame { // App agora estende JFrame para ser o "owner"
    private EspacosClient client;

    public App() {
        // Configurações básicas do JFrame principal (pode ser invisível)
        setTitle("Sistema de Gestão de Espaços Acadêmicos");
        setSize(1, 1); // Tamanho mínimo, pois será apenas um contêiner
        setUndecorated(true); // Sem bordas ou barra de título
        setVisible(false); // Inicia invisível
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Garante que o programa feche quando este frame for fechado
    }

    public static void main(String[] args) {
        // Definir o Look and Feel do sistema
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace(); // Melhor logar o erro
        }

        SwingUtilities.invokeLater(() -> {
            App app = new App(); // Cria a instância principal da aplicação
            app.client = new EspacosClient();

            // Tenta conectar ao servidor antes de exibir a tela de login
            if (!app.client.conectar("localhost", 12346)) {
                JOptionPane.showMessageDialog(null, "Não foi possível conectar ao servidor. Verifique se o servidor está em execução.", "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
                return;
            }

            app.showLoginScreen(); // Chama o método para exibir a tela de login
        });
    }

    // Método para exibir a tela de login
    public void showLoginScreen() {
        LoginFrame loginFrame = new LoginFrame(this, client); // Passa 'this' (a instância de App) como owner
        loginFrame.setVisible(true);

        // Após o LoginFrame ser fechado (dispose()), verifica o resultado
        if (loginFrame.isLoginSucesso()) {
            Usuario usuario = loginFrame.getUsuarioLogado();

            if (usuario != null) {
                // Passa 'this' (a instância de App) como parentFrame para MainFrame
                MainFrame mainFrame = new MainFrame(this, client, usuario.getNome(), usuario.getTipo().name(), usuario.getId());
                mainFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Erro: Dados do usuário logado não encontrados.", "Erro", JOptionPane.ERROR_MESSAGE);
                client.desconectar();
                System.exit(1);
            }
        } else {
            // Se o login não foi bem-sucedido (cancelado ou erro), desconecta e sai
            client.desconectar();
            System.exit(0);
        }
    }

    // Método chamado por MainFrame quando o logout ocorre
    public void reopenLogin() {
        // Garante que a conexão do cliente está fechada antes de reabrir o login
        if (client.isConectado()) {
            client.desconectar();
        }
        // Tenta reconectar antes de mostrar a tela de login novamente
        if (!client.conectar("localhost", 12346)) {
            JOptionPane.showMessageDialog(null, "Não foi possível reconectar ao servidor. Verifique se o servidor está em execução.", "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
            return;
        }
        showLoginScreen(); // Reabre a tela de login
    }
}
