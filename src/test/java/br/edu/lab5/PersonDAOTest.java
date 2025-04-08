package br.edu.lab5;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PersonDAOTest {

    @Test
    public void nomeNulo() {
        Person p = new Person(1, null, 25, List.of(new Email(1, "a@email.com")));
        List<String> erros = new PersonDAO().isValidToInclude(p);
        assertTrue(erros.contains("Nome deve conter pelo menos duas partes (nome e sobrenome) compostas por letras"));
    }

    @Test
    public void nomeInvalido() {
        Person p = new Person(1, "João", 25, List.of(new Email(1, "a@email.com")));
        List<String> erros = new PersonDAO().isValidToInclude(p);
        assertTrue(erros.contains("Nome deve conter pelo menos duas partes (nome e sobrenome) compostas por letras"));
    }

    @Test
    public void idadeInvalida() {
        Person p = new Person(1, "João Silva", 0, List.of(new Email(1, "a@email.com")));
        List<String> erros = new PersonDAO().isValidToInclude(p);
        assertTrue(erros.contains("Idade deve estar entre 1 e 200"));
    }

    @Test
    public void emailsNulos() {
        Person p = new Person(1, "João Silva", 30, null);
        List<String> erros = new PersonDAO().isValidToInclude(p);
        assertTrue(erros.contains("Pessoa deve possuir pelo menos um e-mail"));
    }

    @Test
    public void emailsVazios() {
        Person p = new Person(1, "João Silva", 30, Collections.emptyList());
        List<String> erros = new PersonDAO().isValidToInclude(p);
        assertTrue(erros.contains("Pessoa deve possuir pelo menos um e-mail"));
    }

    @Test
    public void emailInvalido() {
        Person p = new Person(1, "João Silva", 30, List.of(new Email(1, "errado")));
        List<String> erros = new PersonDAO().isValidToInclude(p);
        assertTrue(erros.contains("E-mail inválido: errado"));
    }

    @Test
    public void umEmailValidoUmInvalido() {
        Person p = new Person(1, "João Silva", 30, List.of(
            new Email(1, "joao@email.com"),
            new Email(2, "errado")
        ));
        List<String> erros = new PersonDAO().isValidToInclude(p);
        assertTrue(erros.contains("E-mail inválido: errado"));
    }

    @Test
    public void tudoValido() {
        Person p = new Person(1, "João Silva", 30, List.of(new Email(1, "joao@empresa.com")));
        List<String> erros = new PersonDAO().isValidToInclude(p);
        assertTrue(erros.isEmpty());
    }

    @Test
    public void chamaSave() {
        Person p = new Person(1, "João Silva", 30, List.of(new Email(1, "a@email.com")));
        new PersonDAO().save(p);
        assertTrue(true);
    }
}
