package view;


import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import controller.AlunoDAO;
import model.Aluno;

public class SwingInterface {
	public SwingInterface() {
		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new FlowLayout());
		
		var buttonCriar = new JButton("Registrar Aluno");
		var buttonListar = new JButton("Listar Alunos");
		
		buttonCriar.addActionListener(e -> {
			var swingAddAluno =  new SwingAddAluno();
		});
		
		buttonListar.addActionListener(e -> {
			var swingTable = new SwingTable();
		});
		
		frame.add(buttonCriar);
		frame.add(buttonListar);
		
		frame.setVisible(true);
	}
}
