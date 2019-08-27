package br.com.welson.fibonacci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Fibonacci {

    public static void main(String[] args) {

        List<Integer> fibonacci = new ArrayList<>(Arrays.asList(0, 1));
        for (int i = 0; i < 8; i++) {
            fibonacci.add(fibonacci.get(i) + fibonacci.get(i + 1));
        }
        System.out.println(fibonacci);

        Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]}).limit(10).map(f -> f[0]).forEach(System.out::println);
    }
}
