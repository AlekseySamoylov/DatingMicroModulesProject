package com.alekseysamoylov.dating.test;

import com.alekseysamoylov.dating.test.stream.FileRead;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by alekseysamoylov on 5/15/17.
 */
public class StringConstantsToEnumFormatter {

    private static final String NAME_REG_EX = "CODE_[^\\s]* = \"\\n*[^\"]";

    private static final String ENUM_HEADER = "public enum Name { \n";
    private static final String ENUM_HEADER_1 = "(Code.";
    private static final String ENUM_HEADER_2 = "), \n";
    private static final String ENUM_HEADER_3 = "); \n";
    private static final String ENUM_BODY_1 = "case(Code.";
    private static final String ENUM_BODY_2 = "): \n return ";
    private static final String ENUM_BODY_3 = "; \n";
    private static final String ENUM_FOOTER_1 = "private static final ";
    private static final String ENUM_FOOTER_2 = " = \"";
    private static final String ENUM_FOOTER_3 = "; \n";

    private static String result = "";


    private static Map<String, String> enumMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Pattern namePattern = Pattern.compile(NAME_REG_EX);

        Matcher nameMatcher = namePattern.matcher(FileRead.process("constants.java", (bufferedReader -> {
            try {
                return bufferedReader.readLine() + bufferedReader.readLine() + bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        })));

        if (nameMatcher.find()) {
            String[] twoParts = nameMatcher.group().split(" = \"");
            String name = twoParts[0];
            String value = twoParts[1];
            enumMap.put(name, value);


        }
        enumMap.forEach((key, value) -> {
            result += (key + ENUM_HEADER_1 + key + ENUM_HEADER_2);
        });
        enumMap.forEach((key, value) -> {
            result += (ENUM_BODY_1 + key + ENUM_BODY_2);
        });
        System.out.println(result);

    }
}
