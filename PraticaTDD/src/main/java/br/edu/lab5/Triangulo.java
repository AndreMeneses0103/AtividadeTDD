package br.edu.lab5;

public class Triangulo {
    public static String classificarTriangulo(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return "Valor inválido";

        if (a + b <= c || a + c <= b || b + c <= a) return "Não é um triângulo";

        if (a == b && b == c) return "Equilátero";

        if (a == b || a == c || b == c) return "Isósceles";

        return "Escaleno";
    }
}
