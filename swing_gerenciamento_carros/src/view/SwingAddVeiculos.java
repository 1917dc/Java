package view;

import controller.VeiculoDAO;
import model.Caminhao;
import model.Carro;
import model.Moto;

import javax.swing.*;
import java.awt.*;

public class SwingAddVeiculos extends JPanel {
    private VeiculoDAO veiculoDAO = new VeiculoDAO();

    private JButton buttonRegistrar;
    private JPanel panelRegistrar;
    private JFrame frameInformacoes;

    private String[] veiculos = {"Carro", "Moto", "Caminhão"};
    private JComboBox tipoVeiculo = new JComboBox(veiculos);

    private String[] tiposCombustivel = {"Alcoól", "Etanol", "Gasolina"};
    private JComboBox combustivelBox = new JComboBox(tiposCombustivel);

    private String[] tiposCilindradas = {"Baixa", "Média", "Alta"};
    private JComboBox cilindradasBox = new JComboBox(tiposCilindradas);

    private JTextField cargaField = new JTextField();

    public SwingAddVeiculos(){
        JPanel registroPanel = registrarVeiculo();
        add(registroPanel);
    }

    private JPanel registrarVeiculo() {
        panelRegistrar = new JPanel();
        panelRegistrar.setLayout(new FlowLayout());

        var buttonSalvar = new JButton("Salvar");
        buttonSalvar.addActionListener(e -> {
            informacoesVeiculo();
        });

        panelRegistrar.add(tipoVeiculo);
        panelRegistrar.add(buttonSalvar);

        return panelRegistrar;
    }

    private void informacoesVeiculo() {
        frameInformacoes = new JFrame("Informações de Veículo");
        frameInformacoes.setLayout(new GridBagLayout());

        var panelFields = new JPanel();
        panelFields.setLayout(new GridBagLayout());

        var panelSave = new JPanel();
        panelSave.setLayout(new FlowLayout());

        frameInformacoes.add(panelFields, pos(0,0));
        frameInformacoes.add(panelSave, pos(0,1));

        panelFields.add(new JLabel("Nome"), pos(0, 1));
        var nomeField = new JTextField(10);
        panelFields.add(nomeField, pos(1,1));

        panelFields.add(new JLabel("Marca"), pos(0,2));
        var marcaField = new JTextField(10);
        panelFields.add(marcaField, pos(1,2));

        panelFields.add(new JLabel("Modelo"), pos(0,3));
        var modeloField = new JTextField(10);
        panelFields.add(modeloField, pos(1,3));

        panelFields.add(new JLabel("Ano"), pos(0,4));
        var anoField = new JTextField(10);
        panelFields.add(anoField,pos(1,4));


        if(tipoVeiculo.getSelectedItem().equals("Carro")){
            panelFields.add(new JLabel("Combustível"), pos(0,5));
            panelFields.add(combustivelBox,pos(1,5));
        } else if(tipoVeiculo.getSelectedItem().equals("Moto")){
            panelFields.add(new JLabel("Cilindradas"), pos(0,6));
            panelFields.add(cilindradasBox, pos(1,6));
        } else if(tipoVeiculo.getSelectedItem().equals("Caminhão")){
            panelFields.add(new JLabel("Carga"), pos(0,7));
            cargaField = new JTextField(5);
            panelFields.add(cargaField, pos(1,7));
        }
        var buttonSalvar = new JButton("Salvar");
        buttonSalvar.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(null,"Você deseja mesmo salvar?");

            if(choice == JOptionPane.YES_OPTION){
                String nome = nomeField.getText();
                String marca = marcaField.getText();
                String modelo = modeloField.getText();
                String ano = anoField.getText();
                String tipo = tipoVeiculo.getSelectedItem().toString();

                if(tipoVeiculo.getSelectedItem().equals("Carro")){
                    String combustivel = combustivelBox.getSelectedItem().toString();
                    veiculoDAO.save(new Carro(nome, marca, modelo, ano, combustivel, tipo));
                } else if(tipoVeiculo.getSelectedItem().equals("Moto")){
                    String cilindradas = cilindradasBox.getSelectedItem().toString();
                    veiculoDAO.save(new Moto(nome, marca, modelo, ano, cilindradas, tipo));
                } else if(tipoVeiculo.getSelectedItem().equals("Caminhão")){
                    String carga = cargaField.getText();
                    veiculoDAO.save(new Caminhao(nome, marca, modelo, ano, carga, tipo));
                }
                JOptionPane.showMessageDialog(null, "Veículo salvo com sucesso!");
                frameInformacoes.dispose();
            } else if(choice == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "Veículo não foi salvo.");
                frameInformacoes.dispose();
            }

        });
        panelSave.add(buttonSalvar);

        frameInformacoes.setLocationRelativeTo(null);
        frameInformacoes.setSize(800, 600);
        frameInformacoes.setVisible(true);
    }

    public static GridBagConstraints pos(int x, int y){
        var cts = new GridBagConstraints();
        cts.gridx = x;
        cts.gridy = y;
        cts.insets = new Insets( 10, 10, 10, 10);
        return cts;
    }
}
