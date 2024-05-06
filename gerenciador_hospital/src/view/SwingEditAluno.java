package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controller.AlunoDAO;
import model.Aluno;

public class SwingEditAluno {
	private AlunoDAO alunoDAO = new AlunoDAO();
	public SwingEditAluno() {
		var frame = new JFrame();
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		var panelAdd = new JPanel();
		panelAdd.setLayout(new GridBagLayout());
		
		var labelNome = new JLabel("NOME");
		var fieldNome = new JTextField(10);
		
		var labelCPF = new JLabel("CPF");
		var fieldCPF = new JTextField(10);
		
		var labelCurso = new JLabel("CURSO");
		var fieldCurso = new JTextField(10);
		
		var buttonSalvar = new JButton("Salvar");
		buttonSalvar.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, "Aluno salvo com sucesso!");
			var nome = fieldNome.getText();
			var cpf = fieldCPF.getText();
			var curso = fieldCurso.getText();
			var aluno = new Aluno(nome, cpf, curso);
			
			alunoDAO.edit(aluno);
			fieldNome.setText("");
			fieldCPF.setText("");
			fieldCurso.setText("");
			frame.dispose();
		});
		
		
		panelAdd.add(labelNome, pos(0,0));
		panelAdd.add(fieldNome, pos(1,0));
		
		panelAdd.add(labelCPF, pos(0,1));
		panelAdd.add(fieldCPF, pos(1,1));
		
		panelAdd.add(labelCurso, pos(0,2));
		panelAdd.add(fieldCurso, pos(1,2));
		
		panelAdd.add(buttonSalvar, pos(0,3));
		
		
		frame.add(panelAdd);
		frame.setVisible(true);
	}
	public GridBagConstraints pos(int x, int y) {
		var pos = new GridBagConstraints();
		pos.gridx = x;
		pos.gridy = y;
		pos.insets = new Insets(10, 10, 10, 10);
		return pos;
	}
}
