package LeonardoVilelaPinheiro_Atividade08.janelas;

import LeonardoVilelaPinheiro_Atividade08.BDVeiculos;

import javax.swing.*;
import java.awt.*;
import java.awt.print.PrinterException;

public class ListPasseio {
    private static ListPasseio instance;

    public JFrame tela = new JFrame("Imprimir / Excluir todos");
    private JTable table;
    public static BDVeiculos bancoDeVeiculos = BDVeiculos.getBDVeiculos();

    private static JButton btImprimirTodos = new JButton("Imprimir Todos");
    private static JButton btExcluirTodos = new JButton("Excluir Todos");
    private static JButton btSair = new JButton("Sair");

    {
        btSair.addActionListener(e -> {
            tela.dispose();
        });

        btImprimirTodos.addActionListener(e -> {
            try { table.print(); }
            catch (SecurityException | PrinterException ex) {
                ex.printStackTrace();
            }
        });

        btExcluirTodos.addActionListener(e -> {
            BDVeiculos.getBDPas().clear();
        });
    }

    public static JFrame getFrame() {
        if (instance == null) {
            instance = new ListPasseio();
        }

        return instance.tela;
    }

    private ListPasseio() {
        Object[][] cells =
                {
                        {"Mercury", 2440.0, 0, false, Color.YELLOW},
                        {"Venus", 6052.0, 0, false, Color.YELLOW},
                        {"Earth", 6378.0, 1, false, Color.BLUE},
                        {"Mars", 3397.0, 2, false, Color.RED},
                        {"Jupiter", 71492.0, 16, true, Color.ORANGE},
                        {"Saturn", 60268.0, 18, true, Color.ORANGE},
                        {"Uranus", 25559.0, 17, true, Color.BLUE},
                        {"Neptune", 24766.0, 8, true, Color.BLUE},
                        {"Pluto", 1137.0, 1, false, Color.BLACK}
                };

        String[] columnNames = {"Planet", "Radius", "Moons", "Gaseous"};

        table = new JTable(cells, columnNames);
        table.setAutoCreateRowSorter(true);
        tela.add(new JScrollPane(table), BorderLayout.CENTER);

        var buttonPanel = new JPanel();
        buttonPanel.add(btImprimirTodos);
        buttonPanel.add(btExcluirTodos);
        buttonPanel.add(btSair);

        tela.add(buttonPanel, BorderLayout.SOUTH);
        tela.pack();
    }
}
