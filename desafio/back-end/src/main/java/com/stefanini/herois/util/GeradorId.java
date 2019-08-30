package com.stefanini.herois.util;

public class GeradorId {

    private final static char[] caracteres;

    static {
        caracteres = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    private GeradorId() {
    }

    public static String gerar() {
        char[] id = new char[15];
        for (int i = 0; i < id.length; i++) {
            id[i] = caracteres[RandomUtil.sorteaNumero(caracteres.length)];
        }
        return new String(id);
    }
}
