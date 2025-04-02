import java.util.*;
import java.sql.*;

public class Main {
    
    // 1. Campo público sem encapsulamento
    public String nome = "teste";
    
    // 2. Variável estática mutável
    public static int contador = 0;
    
    // 3. Constante não final
    public static String CONSTANTE = "VALOR";
    
    // 4. Conexão SQL com vazamento de recursos
    public List<String> getNomesDoBanco() throws SQLException {
        List<String> nomes = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=123456");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT nome FROM pessoas WHERE id = " + System.getenv("USER_ID")); // SQL Injection
            
            while(rs.next()) {
                nomes.add(rs.getString(1)); // Uso de índice numérico
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e); // Logging inadequado
        }
        return nomes;
    }
    
    // 5. Método complexo com muitas responsabilidades
    public void processarTudo(String input) {
        if(input == null) return;
        
        // 6. Comparação de strings com ==
        if(input == "SPECIAL") {
            System.out.println("Input especial");
        } else {
            // 7. Concatenação ineficiente em loop
            String result = "";
            for(int i = 0; i < 100; i++) {
                result += input; // Deveria usar StringBuilder
            }
            System.out.println(result);
        }
        
        // 8. Número mágico
        if(input.length() > 50) {
            System.out.println("Input muito longo");
        }
        
        // 9. Dead store
        int x = 10;
        x = 20;
    }
    
    // 10. Duplicação de código
    public void processarTudoNovamente(String input) {
        if(input == null) return;
        
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
    
    // 11. Método nunca usado
    private String metodoInutil() {
        return "nunca usado";
    }
    
    // 12. Exceção genérica
    public void metodoCritico() throws Exception {
        try {
            int y = 100 / 0;
        } catch (Exception e) {
            // 13. Exceção ignorada
        }
    }
    
    // 14. Uso de vetor desnecessário
    public void exemploArray() {
        int[] nums = new int[10];
        for(int i = 0; i <= 10; i++) { // 15. Possível ArrayIndexOutOfBounds
            nums[i] = i;
        }
    }
    
    // 16. Método vazio
    public void naoFazNada() {}
}