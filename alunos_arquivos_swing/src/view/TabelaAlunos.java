package view;

import controller.AlunoDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.stream.Collectors;

public class TabelaAlunos extends JPanel {
    private JTable table;
    private AlunoDAO alunoDAO;

    public TabelaAlunos(){
        table = new JTable();
        alunoDAO = new AlunoDAO();

        JScrollPane scrollPane = criarTabela();
        add(scrollPane);
    }

    public JScrollPane criarTabela(){
        String[][] data = alunoDAO.getAlunos()
                .stream()
                .map(aluno -> new String[]{aluno.nome(), aluno.cpf(), aluno.curso()})
                .collect(Collectors.toList())
                .toArray(new String[0][0]);
        String[] columnNames = {"NOME", "CPF", "CURSO"};

        table = new JTable(data, columnNames);
        table.setBounds(30, 40, 200, 300);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);
        table.setGridColor(Color.WHITE);
        table.setRowHeight(25);
        table.setShowGrid(false);

        JScrollPane scrollPane = new JScrollPane(table);
        return scrollPane;
    }
    public void atualizarTabela(){
        String[][] data = alunoDAO.getAlunos()
                .stream()
                .map(aluno -> new String[]{aluno.nome(), aluno.cpf(), aluno.curso()})
                .collect(Collectors.toList())
                .toArray(new String[0][0]);
        String[] columnNames = {"NOME", "CPF", "CURSO"};

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table.setModel(model);
    }
}
