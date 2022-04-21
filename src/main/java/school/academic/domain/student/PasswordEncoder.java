package school.academic.domain.student;

public interface PasswordEncoder {

    String encoderPassword(String password);

    boolean validatePassword(String passwordEncoder, String password);
}
