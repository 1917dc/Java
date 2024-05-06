package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import controller.AlunoDAO;

public class SwingTable extends JPanel{
	private AlunoDAO alunoDAO = new AlunoDAO();
	private JTable table = new JTable();
	private JScrollPane tableDone = scrollPane();
	private SwingEditAluno swingEditAluno;
	private JFrame frame = new JFrame();
	public SwingTable() {
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		var panelEdit = new JPanel();
		panelEdit.setLayout(new GridBagLayout());
		
		panelEdit.setLayout(new BorderLayout());
		
		panelEdit.add(editPanelCreate(), BorderLayout.EAST);
		panelEdit.add(tableDone, BorderLayout.CENTER);
		
		frame.add(panelEdit);
		frame.setVisible(true);
	}
	private JPanel editPanelCreate() {
		JPanel editPanel = new JPanel();
		editPanel.setLayout(new GridBagLayout());
		
		var buttonEdit = new JButton("Editar");
		var buttonDelete = new JButton("Excluir");
		
		editPanel.add(buttonEdit, pos(0,0));
		editPanel.add(buttonDelete, pos(0,1));
		
		buttonEdit.addActionListener(e -> {
			swingEditAluno = new SwingEditAluno();
			frame.dispose();
		});
		
		buttonDelete.addActionListener(e -> {
			var alunos = alunoDAO.fetchAll();
			var alunoDelete = alunos.get(table.getSelectedRow());
			alunoDAO.delete(alunoDelete);
			JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso");
			frame.dispose();
		});
		
		return editPanel;
	}
	
	private DefaultTableModel tableCreate() {
		String[][] data = alunoDAO.fetchAll()
				.stream()
				.map(aluno -> new String[] {aluno.getNome(), aluno.getCpf(), aluno.getCurso()})
				.collect(Collectors.toList())
				.toArray(new String[0][0]);
		String[] columnNames = {"NOME", "CPF", "CURSO"};
		
		var tableModel = new DefaultTableModel(data, columnNames);
		return tableModel;
	}
	
	public void scrollPaneUpdate() {
		tableCreate().fireTableDataChanged();
	}
	
	private JScrollPane scrollPane() {
		table.setModel(tableCreate());
		return new JScrollPane(table);
	}
	
	public GridBagConstraints pos(int x, int y) {
		var pos = new GridBagConstraints();
		pos.gridx = x;
		pos.gridy = y;
		pos.insets = new Insets(10, 10, 10, 10);
		return pos;
	}
	
}
