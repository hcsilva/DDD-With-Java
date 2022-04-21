package school.shared.domain;

public class CPF {

    private String number;

    public CPF(String number) {
        if (number == null || !number.matches("[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}-?[0-9]{2}")) {
            throw new IllegalArgumentException("CPF Inválido");
        }

        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
