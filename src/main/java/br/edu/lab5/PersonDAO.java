package br.edu.lab5;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    public List<String> isValidToInclude(Person p) {
        List<String> erros = new ArrayList<>();

        if (p.getName() == null || !p.getName().matches("^[A-Za-zÀ-ÿ]+( [A-Za-zÀ-ÿ]+)+$")) {
            erros.add("Nome deve conter pelo menos duas partes (nome e sobrenome) compostas por letras");
        }

        if (p.getAge() < 1 || p.getAge() > 200) {
            erros.add("Idade deve estar entre 1 e 200");
        }

        List<Email> emails = p.getEmails();
        if (emails == null || emails.isEmpty()) {
            erros.add("Pessoa deve possuir pelo menos um e-mail");
        } else {
            for (Email email : emails) {
                String emailStr = email.getName();
                if (!emailStr.matches(".+@.+\\..+")) {
                    erros.add("E-mail inválido: " + emailStr);
                }
            }
        }

        return erros;
    }

    public void save(Person p) {
    }
}
