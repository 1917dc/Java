import javax.swing.*;

import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Teste");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 600);

        JPanel panelFields = new JPanel(new GridBagLayout());
        JPanel panelOptions = new JPanel(new FlowLayout());

        panelFields.add(new JLabel("Nome: "), pos(0,0));
        JTextField nome = new JTextField(20);
        panelFields.add(nome, pos(1,0));

        panelFields.add(new JLabel("Sobrenome: "), pos(0,2));
        JTextField sobrenome = new JTextField(20);
        panelFields.add(sobrenome, pos(1,2));

        panelFields.add(new JLabel("CPF: "), pos(0,3));
        JTextField cpf = new JTextField(20);
        panelFields.add(cpf, pos(1,3));

        panelFields.add(new JLabel("Email: "), pos(0,4));
        JTextField email = new JTextField(20);
        panelFields.add(email, pos(1,4));

        String[] options = {"Solteiro", "Casado", "Divorciado", "Viúvo"};
        JComboBox<String> estadoCivil = new JComboBox<>(options);
        estadoCivil.addActionListener(e -> {
            System.out.println(estadoCivil.getSelectedItem());
        });

        panelFields.add(new JLabel("Estado Civil: "), pos(0,5));
        panelFields.add(estadoCivil, pos(1,5));

        JButton btn = new JButton("Salvar");
        panelOptions.add(btn, BorderLayout.CENTER);

        frame.add(panelFields, BorderLayout.CENTER);
        frame.add(panelOptions, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    static GridBagConstraints pos(int x, int y){
        var cts = new GridBagConstraints();
        cts.gridx = x;
        cts.gridy = y;
        cts.insets = new Insets(10, 10, 10, 10);
        return cts;
    }
}