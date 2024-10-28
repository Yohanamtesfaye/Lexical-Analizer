import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LexicalAnalyzer {
    private Stack<String> stack;
    private Map<String, Object> symbolTable;
    private StringBuilder buffer;

    public LexicalAnalyzer() {
        stack = new Stack<>();
        symbolTable = new HashMap<>();
        buffer = new StringBuilder();
    }

    public void analyze(String input) {
        String[] tokens = input.split("\\s+");
        
        for (String token : tokens) {
            buffer.append(token).append(" ");
            stack.push(token);
        }

        parseTokens();
    }

    private void parseTokens() {
        while (!stack.isEmpty()) {
            String token = stack.pop();
            if (token.matches("\\d+")) {
                // Integer value
                processValue(token);
            } else if (token.equals("=")) {
                // Assignment operator
                processAssignment();
            } else if (token.equals("int")) {
                // Data type
                processDataType(token);
            } else if (token.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
                // Identifier
                processIdentifier(token);
            } else {
                System.out.println("Unrecognized token: " + token);
            }
        }

        buffer.setLength(0); 
    }

    private void processValue(String value) {
        if (!symbolTable.containsKey("value")) {
            symbolTable.put("value", Integer.parseInt(value));
        }
    }

    private void processAssignment() {
        if (!symbolTable.containsKey("assignment")) {
            symbolTable.put("assignment", "=");
        }
    }

    private void processDataType(String dataType) {
        if (!symbolTable.containsKey("dataType")) {
            symbolTable.put("dataType", dataType);
        }
    }

    private void processIdentifier(String identifier) {
        if (!symbolTable.containsKey("identifier")) {
            symbolTable.put("identifier", identifier);
        }
    }

    public void displaySymbolTable() {
        System.out.println("Symbol Table:");
        for (Map.Entry<String, Object> entry : symbolTable.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        LexicalAnalyzer lexer = new LexicalAnalyzer();

   
        lexer.analyze("int age = 25");
        lexer.displaySymbolTable();

        // Check different order
        System.out.println("\nTesting different order:");
        lexer.analyze("age = 25 int");
        lexer.displaySymbolTable();
    }
}
