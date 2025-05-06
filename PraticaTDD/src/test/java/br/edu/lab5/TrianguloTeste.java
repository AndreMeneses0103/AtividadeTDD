package br.edu.lab5;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TrianguloTeste {
    
    @ParameterizedTest
    @MethodSource("casosDeTesteTriangulo")
    public void testarClassificacaoTriangulo(int a, int b, int c, String esperado) {
        String resultado = Triangulo.classificarTriangulo(a, b, c);
        Assertions.assertEquals(esperado, resultado);
    }

    private static Stream<Arguments> casosDeTesteTriangulo() {
        return Stream.of(
            // Triângulo escaleno válido
            Arguments.of(3, 4, 5, "Escaleno"),

            // Triângulo isósceles válido (3 permutações)
            Arguments.of(5, 5, 3, "Isósceles"),
            Arguments.of(5, 3, 5, "Isósceles"),
            Arguments.of(3, 5, 5, "Isósceles"),

            // Triângulo equilátero válido
            Arguments.of(4, 4, 4, "Equilátero"),

            // Um valor zero
            Arguments.of(0, 4, 5, "Valor inválido"),
            Arguments.of(3, 0, 5, "Valor inválido"),
            Arguments.of(3, 4, 0, "Valor inválido"),

            // Um valor negativo
            Arguments.of(-3, 4, 5, "Valor inválido"),
            Arguments.of(3, -4, 5, "Valor inválido"),
            Arguments.of(3, 4, -5, "Valor inválido"),

            // Soma de dois lados igual ao terceiro (3 permutações)
            Arguments.of(2, 3, 5, "Não é um triângulo"),
            Arguments.of(3, 5, 2, "Não é um triângulo"),
            Arguments.of(5, 2, 3, "Não é um triângulo"),

            // Soma de dois lados menor que o terceiro (3 permutações)
            Arguments.of(2, 2, 5, "Não é um triângulo"),
            Arguments.of(2, 5, 2, "Não é um triângulo"),
            Arguments.of(5, 2, 2, "Não é um triângulo"),

            // Três valores iguais a zero
            Arguments.of(0, 0, 0, "Valor inválido")
        );
    }
}
