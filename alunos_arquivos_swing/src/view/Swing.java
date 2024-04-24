package view;

import controller.AlunoDAO;
import model.Aluno;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Swing extends JFrame {
    private AlunoDAO alunoDAO;
    private TabelaAlunos tabelaAlunos;

    private JFrame frame;
    private JTable table;
    private JTabbedPane tab;

    private JPanel panel;

    public Swing() {
        frame = new JFrame();
        frame.setTitle("Tabela de Alunos UnDF");

        tab = new JTabbedPane();
        frame.add(tab);

        TabelaAlunos tabelaAlunos = new TabelaAlunos();

        tab.add("Tabela de Alunos", tabelaAlunos);
        tab.add("Adicionar Aluno", new AdicionarAlunos(tabelaAlunos));

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(500, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
