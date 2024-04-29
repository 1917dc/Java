package view;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class SwingExecute {
    private JFrame frame;
    private JTabbedPane tab;

    public SwingExecute(){
        FlatDarculaLaf.setup();
        frame = new JFrame("Gerenciador de Veículos");
        tab = new JTabbedPane();

        frame.add(tab);

        SwingAddVeiculos swingAddVeiculos = new SwingAddVeiculos();
        SwingListView swingListView = new SwingListView();

        tab.add("Registrar Veículo", swingAddVeiculos);
        tab.add("Lista de Veículos", swingListView);

        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
