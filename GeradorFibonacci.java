

import java.util.ArrayList;
import java.util.List;

public class GeradorFibonacci {
    
    public List<Integer> generateSequence(int count) {
        List<Integer> sequencia = new ArrayList<>();
        
        if (count <= 0) return sequencia;
        
        sequencia.add(0);
        if (count == 1) return sequencia;
        
        sequencia.add(1);
        for (int i = 2; i < count; i++) {
            int next = sequencia.get(i-1) + sequencia.get(i-2);
            sequencia.add(next);
        }
        
        return sequencia;
    }

    public String formatarSequencia(List<Integer> sequencia) {
        if (sequencia.isEmpty()) return "";
        
        StringBuilder sb = new StringBuilder();
        int qtdPorLinha = 20;  
        
        for (int i = 0; i < sequencia.size(); i++) {
            if (i > 0) {
                sb.append(", ");
                if (i % qtdPorLinha == 0) {
                    sb.append("\n");  
                }
            }
            sb.append(sequencia.get(i));
        }
        
        return sb.toString();
    }
    
}
