

import javax.swing.*;

public class FibonacciApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
            new FibonacciFrame();
        });
    }
}