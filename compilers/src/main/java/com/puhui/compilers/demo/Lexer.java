package com.puhui.compilers.demo;

import com.puhui.compilers.utils.CommonUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by wentong on 2016/6/27.
 * 词法解析器
 */
public class Lexer {

    public static void main(String[] args) {
        new Lexer().runLexer();
    }

    public void runLexer() {
        while (!match(EOI)) {
            System.out.println("Token: " + token() + " ,Symbol: " + yytext);
            advance();
        }
    }

    public static final int EOI = 0;
    public static final int SEMI = 1; // 分号
    public static final int PLUS = 2; // 加号
    public static final int TIMES = 3; // 乘号
    public static final int LP = 4;
    public static final int RP = 5;
    public static final int NUM_OR_ID = 6; // 数字
    public static final int NO_SENSE_NUMBER = -10;
    public static Map<Character, Integer> RETURN_OPERATOR = new HashMap<>();
    public static Map<Character, Integer> NONE_RETURN_OPERATOR = new HashMap<>();

    static {
        RETURN_OPERATOR.put('+', PLUS);
        RETURN_OPERATOR.put('*', TIMES);
        RETURN_OPERATOR.put(';', SEMI);
        NONE_RETURN_OPERATOR.put('(', NO_SENSE_NUMBER);
        NONE_RETURN_OPERATOR.put(')', NO_SENSE_NUMBER);
        NONE_RETURN_OPERATOR.put('\n', NO_SENSE_NUMBER);
        NONE_RETURN_OPERATOR.put('\t', NO_SENSE_NUMBER);
        NONE_RETURN_OPERATOR.put(' ', NO_SENSE_NUMBER);
    }

    private int lookAhead = -1;

    public String yytext = "";
    public int yyleng = 0;
    public int lineNo = 0;

    private String input_buffer = "";
    private String current = "";

    private int lex() {
        while (true) {
            while (current.equals("")) {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    if (scanner.hasNext()) {
                        String line = scanner.nextLine();
                        if ("end".equals(line)) {
                            break;
                        }
                        input_buffer += line;
                    } else {
                        break;
                    }

                }
                scanner.close();
                // 如果没有输入
                if (input_buffer.length() == 0) {
                    return EOI;
                }
                current = input_buffer;
                input_buffer = "";
                lineNo++;
            }

            for (int i = 0; i < current.length(); i++) {
                yyleng = 0;
                yytext = current.substring(0, 1);
                char c = current.charAt(i);
                if (RETURN_OPERATOR.containsKey(c)) {
                    current = current.substring(1);
                    return RETURN_OPERATOR.get(c);
                } else if (NONE_RETURN_OPERATOR.containsKey(c)) {
                    current = current.substring(1);
                    // 是数字的时候
                } else {
                    if (!CommonUtils.isNumberOrAlphabetic(current.charAt(i))) {
                        System.out.println("Ignoring illegal input: " + current.charAt(i));
                    } else {
                        // 把数字解析完整，比如 1234 这样的
                        while (CommonUtils.isNumberOrAlphabetic(current.charAt(i))) {
                            i++;
                            yyleng++;
                        }
                        yytext = current.substring(0, yyleng);
                        current = current.substring(yyleng);
                        return NUM_OR_ID;
                    }

                }
//                switch (current.charAt(i)) {
//
//                }
            }
        }

    }

    private String token() {
        String token = "";
        switch (lookAhead) {
            case EOI:
                token = "EOI";
                break;
            case PLUS:
                token = "PLUS";
                break;
            case TIMES:
                token = "TIMES";
                break;
            case NUM_OR_ID:
                token = "NUM_OR_ID";
                break;
            case SEMI:
                token = "SEMI";
                break;
            case LP:
                token = "LP";
                break;
            case RP:
                token = "RP";
                break;
        }

        return token;
    }

    public boolean match(int token) {
        if (lookAhead == -1) {
            lookAhead = lex();
        }

        return token == lookAhead;
    }

    public void advance() {
        lookAhead = lex();
    }
}
