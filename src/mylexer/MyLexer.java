/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylexer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import mylexer.tokens.Yytoken;

/**
 *
 * @author pavel
 */
public class MyLexer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, java.io.IOException {
        //String path = "P:/JavaProject/MyLexer/src/mylexer/lexer.flex";
        //generateLexer(path);
        //path = "P:/JavaProject/MyLexer/src/mylexer/test.txt";
        try {
            Yylex lex = new Yylex(new FileReader(args[0]));
        
        
            Yytoken token;
            do {
                token = lex.yylex();
                if(token != null)
                    System.out.print(token);
                else break;
            } while(true);
        } catch (FileNotFoundException ex){
            System.out.print("Не найден файл " + args[0]);
        }
        
    }
    public static void generateLexer(String path)
    {
        File file = new File(path);
        jflex.Main.generate(file);
    }
}
