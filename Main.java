import java.util.*;
import java.sql.*;

public class Main {
    
    // 1. Uso de campo público (violação de encapsulamento)
    public String nome;
    
    // 2. Uso de variável estática não final
    private static int contador = 0;
    
    // 3. Conexão SQL não fechada (problema de resource leak)
    public List<String> getNomesDoBanco() {
        List<String> nomes = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT nome FROM pessoas");
            
            while(rs.next()) {
                nomes.add(rs.getString("nome"));
            }
            // 4. Falta fechar rs, stmt e conn (SQL resource leak)
        } catch (SQLException e) {
            // 5. Logging inadequado (apenas printStackTrace)
            e.printStackTrace();
        }
        return nomes;
    }
    
    // 6. Método complexo com muitas responsabilidades
    public void processarTudo(String input) {
        if(input != null) {
            // 7. Uso de == para comparar strings
            if(input == "SPECIAL") {
                System.out.println("Input especial");
            } else {
                // 8. Concatenação de strings em loop
                String result = "";
                for(int i = 0; i < 100; i++) {
                    result += input;
                }
                System.out.println(result);
            }
            
            // 9. Uso de número mágico
            if(input.length() > 50) {
                System.out.println("Input muito longo");
            }
        }
        
        // 10. Retorno sem valor em método void
        return;
    }
    
    // 11. Duplicação de código (método quase idêntico ao anterior)
    public void processarTudoNovamente(String input) {
        if(input != null) {
            if(input == "SPECIAL") {
                System.out.println("Input especial");
            } else {
                String result = "";
                for(int i = 0; i < 100; i++) {
                    result += input;
                }
                System.out.println(result);
            }
            
            if(input.length() > 50) {
                System.out.println("Input muito longo");
            }
        }
        
        return;
    }
    
    // 12. Método não utilizado (dead code)
    private String metodoNuncaUsado() {
        return "inútil";
    }
    
    // 13. Exceção genérica (deveria ser mais específica)
    public void metodoPerigoso() throws Exception {
        // 14. Ignorando exceção
        try {
            int x = 10 / 0;
        } catch (Exception e) {}
    }
}