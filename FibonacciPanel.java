

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FibonacciPanel extends JPanel {
    private final GeradorFibonacci service;
    private JTextField entrada;
    private JTextArea resultado;
    private JButton gerarBotao;
    private JLabel statusPanel;

    public FibonacciPanel() {
        this.service = new GeradorFibonacci();
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        
        JPanel entradaPanel = new JPanel(new BorderLayout(5, 5));
        entrada = new JTextField();
        entrada.setFont(new Font("Monospaced", Font.PLAIN, 14));
        
        
        entrada.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                }
            }
        });

        gerarBotao = new JButton("Gerar Sequência");
        gerarBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateSequence();
            }
        });

        entradaPanel.add(new JLabel("Quantidade de números:"), BorderLayout.NORTH);
        entradaPanel.add(entrada, BorderLayout.CENTER);
        entradaPanel.add(gerarBotao, BorderLayout.SOUTH);

        
        resultado = new JTextArea();
        resultado.setEditable(false);
        resultado.setFont(new Font("Monospaced", Font.PLAIN, 14));
        resultado.setLineWrap(true);  
        resultado.setWrapStyleWord(false); 
        JScrollPane resultadoPanel = new JScrollPane(resultado);
        resultadoPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        
        statusPanel = new JLabel(" ");
        statusPanel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        statusPanel.setForeground(Color.BLACK);

        add(entradaPanel, BorderLayout.NORTH);
        add(resultadoPanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);
    }

    private void generateSequence() {
        String input = entrada.getText();
        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Digite um número válido", 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int valor = Integer.parseInt(input);
            if (valor <= 0 || valor > 1000) {
                JOptionPane.showMessageDialog(this, 
                    "Digite um número entre 1 e 1000", 
                    "Erro", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            
            String sequence = service.formatarSequencia(service.generateSequence(valor));
            
            resultado.setText(sequence);
            statusPanel.setText("Sequência gerada com " + valor + " números. Use a barra de rolagem para ver mais.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Número inválido", 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    
}