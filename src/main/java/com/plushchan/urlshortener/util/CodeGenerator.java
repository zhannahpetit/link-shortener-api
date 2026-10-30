package com.plushchan.urlshortener.util;

import java.util.Random;

public final class CodeGenerator {
    private static final String characters =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    private CodeGenerator() {}

    public static String generateCode() {
        StringBuilder code = new StringBuilder();
        Random random = new Random();

        for(int i = 0; i < 7; i++) {
            int randomIndex = random.nextInt(characters.length());

            code.append(characters.charAt(randomIndex));
        }

        return code.toString();
    }
}
