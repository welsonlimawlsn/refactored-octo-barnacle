package com.stefanini.herois.util;

import java.util.Random;

public class RandomUtil {

    private static final Random RANDOM;

    static {
        RANDOM = new Random();
    }

    public static int sorteaNumero(int max) {
        return RANDOM.nextInt(max);
    }
}
