package school.academic.domain.student;

import school.shared.domain.CPF;

import java.util.ArrayList;
import java.util.List;

//Aggreate Root
public class Student {

    //this class is a entity. Because,
    // the attribute CPF differentiates one student from another.

    private CPF cpf;
    private String name;
    private Email email;
    private String password;
    private List<Telephone> telephones = new ArrayList<>();

    public Student(CPF cpf, String name, Email email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    //Invariantes
    /*
    Invariantes nada mais são do que regras de negócio que precisam ser verificadas para garantir sua consistência.
     */
    public void addTelephone(String ddd, String numero) {
        if (this.telephones.size() == 2) {
            throw new IllegalArgumentException("Numero maximo de telefones atingido!");
        }

        this.telephones.add(new Telephone(ddd, numero));
    }

    public CPF getCpf() {
        return this.cpf;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return this.email.getAddress();
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }
}
