package sistemaagenda;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TelaPrincipal {

    // Gerenciador centralizado de contatos
    static class GerenciadorDeContatos {
        private List<Contato> contatos = new ArrayList<>();

        public void adicionar(Contato contato) {
            contatos.add(contato);
        }

        public List<Contato> listar() {
            return contatos;
        }

        public void apagar(int index) {
            if (index >= 0 && index < contatos.size()) {
                contatos.remove(index);
            }
        }
    }

    // Classe de contato simples, agregando as quatro classes de negócio
    static class Contato {
        private Nome nome;
        private Telefone telefone;
        private Email email;
        private DataNascimento data;

        public Contato(Nome nome, Telefone telefone, Email email, DataNascimento data) {
            this.nome = nome;
            this.telefone = telefone;
            this.email = email;
            this.data = data;
        }

        @Override
        public String toString() {
            return nome + " | " + telefone + " | " + email + " | " + data;
        }
    }

    public static void main(String[] args) {
        GerenciadorDeContatos gerenciador = new GerenciadorDeContatos();

        JFrame frame = new JFrame("Gerenciador de Contatos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new GridLayout(8, 2, 5, 5));
        frame.setLocationRelativeTo(null);

        JLabel labelNome = new JLabel("Nome:");
        JTextField campoNome = new JTextField();

        JLabel labelSobrenome = new JLabel("Sobrenome:");
        JTextField campoSobrenome = new JTextField();

        JLabel labelTelefone = new JLabel("Telefone:");
        JTextField campoTelefone = new JTextField();

        JLabel labelEmail = new JLabel("Email:");
        JTextField campoEmail = new JTextField();

        JLabel labelData = new JLabel("Data Nascimento (dd/MM/yyyy):");
        JTextField campoData = new JTextField();

        JButton botaoEnviar = new JButton("Adicionar");
        JButton botaoListar = new JButton("Listar Contatos");
        JButton botaoApagar = new JButton("Apagar Contato (último)");

        JTextArea resultado = new JTextArea();
        resultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(resultado);

        // Adicionando componentes ao frame
        frame.add(labelNome); frame.add(campoNome);
        frame.add(labelSobrenome); frame.add(campoSobrenome);
        frame.add(labelTelefone); frame.add(campoTelefone);
        frame.add(labelEmail); frame.add(campoEmail);
        frame.add(labelData); frame.add(campoData);
        frame.add(botaoEnviar); frame.add(botaoListar);
        frame.add(botaoApagar); frame.add(scroll);

        // Botão Adicionar
        botaoEnviar.addActionListener(e -> {
            Nome nome = new Nome(campoNome.getText(), campoSobrenome.getText());
            Telefone telefone = new Telefone(campoTelefone.getText());
            Email email = new Email(campoEmail.getText());
            DataNascimento data = new DataNascimento(campoData.getText());

            Contato contato = new Contato(nome, telefone, email, data);
            gerenciador.adicionar(contato);

            // Limpar campos
            campoNome.setText("");
            campoSobrenome.setText("");
            campoTelefone.setText("");
            campoEmail.setText("");
            campoData.setText("");

            JOptionPane.showMessageDialog(frame, "Contato adicionado com sucesso!");
        });

        // Botão Listar Contatos
        botaoListar.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            int i = 1;
            for (Contato c : gerenciador.listar()) {
                sb.append(i++).append(". ").append(c).append("\n");
            }
            resultado.setText(sb.toString());
        });

        // Botão Apagar Contato (último)
        botaoApagar.addActionListener(e -> {
            List<Contato> lista = gerenciador.listar();
            if (!lista.isEmpty()) {
                gerenciador.apagar(lista.size() - 1);
                JOptionPane.showMessageDialog(frame, "Último contato apagado!");
            } else {
                JOptionPane.showMessageDialog(frame, "Não há contatos para apagar.");
            }
        });

        frame.setVisible(true);
    }
}
