package view;

import controller.AlunoDAO;
import model.Aluno;

import javax.swing.*;
import java.awt.*;

public class AdicionarAlunos extends JPanel {
    private AlunoDAO alunoDAO;
    private TabelaAlunos tabelaAlunos;

    private JTextField nomeField;
    private JTextField cpfField;
    private JTextField cursoField;

    private JButton submitButton;
    public AdicionarAlunos(TabelaAlunos tabelaAlunos){
        this.tabelaAlunos = tabelaAlunos;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new JLabel("Nome:"));
        nomeField = new JTextField(5);
        add(nomeField);

        add(new JLabel("CPF:"));
        cpfField = new JTextField(5);
        add(cpfField);

        add(new JLabel("Curso:"));
        cursoField = new JTextField(5);
        add(cursoField);

        submitButton = new JButton("Adicionar Aluno");
        add(submitButton);

        submitButton.addActionListener(e -> registrarAluno());

        submitButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Aluno adicionado com sucesso!");
        });
    }

    private void registrarAluno() {
        alunoDAO = new AlunoDAO();

        String nome = nomeField.getText();
        String cpf = cpfField.getText();
        String curso = cursoField.getText();

        alunoDAO.salvar(new Aluno(nome, cpf, curso));
        tabelaAlunos.atualizarTabela();

        nomeField.setText("");
        cpfField.setText("");
        cursoField.setText("");
    }
}
