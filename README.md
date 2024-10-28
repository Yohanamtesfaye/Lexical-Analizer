#Lexical Analyzer for Variable Declaration in Java

This Java program is a simple lexical analyzer designed to parse variable declarations like int age = 25. It uses a stack to process tokens, a buffer to hold temporary data, and a symbol table to store recognized components. The program identifies the dataType, identifier, assignment, and value tokens in any order.
Features

    Token Classification: Recognizes int, variable names, assignment operators (=), and integer values.
    Symbol Table: Stores each part of the declaration, including data type, identifier name, and value.
    Order Flexibility: Successfully parses tokens even if they're in a non-standard order (e.g., age = 25 int).

Usage

    Run the LexicalAnalyzer with an input string (e.g., int age = 25).
    View the symbol table output to see each part identified and stored.
