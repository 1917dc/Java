package view;

import controller.VeiculoDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.stream.Collectors;

public class SwingListView extends JPanel{
    private VeiculoDAO veiculoDAO = new VeiculoDAO();
    private JTable table = tableCreate();
    public SwingListView(){
        veiculoDAO = new VeiculoDAO();
        JPanel panelListView = new JPanel();
        panelListView.setLayout(new FlowLayout());

        JPanel controllerPanel = createEditPanel();


        panelListView.add(createPane());
        panelListView.add(controllerPanel);
        add(panelListView);
    }

    private JPanel createEditPanel() {
        JPanel controllerPanel = new JPanel();
        JButton buttonEdit = new JButton("Editar");
        JButton buttonDelete = new JButton("Delete");
        controllerPanel.setLayout(new GridBagLayout());

        controllerPanel.add(buttonEdit, pos(0,0));
        controllerPanel.add(buttonDelete, pos(0,1));

        buttonEdit.addActionListener(e ->{
            System.out.println(table.getSelectedColumn());
        });

        return controllerPanel;
    }

    private GridBagConstraints pos(int x, int y) {
        var cts = new GridBagConstraints();
        cts.gridx = x;
        cts.gridy = y;
        cts.insets = new Insets( 10, 10, 10, 10);
        return cts;
    }

    public JScrollPane createPane(){
        JScrollPane scrollPane = new JScrollPane(tableCreate());
        return scrollPane;
    }

    public JTable tableCreate(){
        var tableDone = new JTable();
        tableDone.setDefaultEditor(Object.class, null);

        String[][] data = veiculoDAO.fetchAll()
                .stream()
                .map(veiculo -> new String[]{veiculo.getNome(), veiculo.getAno(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getCaracteristica()})
                .collect(Collectors.toList())
                .toArray(new String[0][0]);
        String[] columnNames = {"NOME", "ANO", "MARCA", "MODELO", "CARAC. ESPECÍFICA"};

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        tableDone.setModel(tableModel);
        return tableDone;
    }
}
