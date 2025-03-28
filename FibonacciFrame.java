

import javax.swing.*;

public class FibonacciFrame extends JFrame {
    public FibonacciFrame() {
        setTitle("Gerador de Sequência Fibonacci");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null); 
        
        FibonacciPanel panel = new FibonacciPanel();
        add(panel);
        
        setVisible(true);
    }
}