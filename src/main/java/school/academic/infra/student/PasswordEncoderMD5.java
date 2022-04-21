package school.academic.infra.student;

import school.academic.domain.student.PasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncoderMD5 implements PasswordEncoder {

    @Override
    public String encoderPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("erro ao gerar hash da senha");
        }
    }

    @Override
    public boolean validatePassword(String passwordEncoder, String password) {
        return passwordEncoder.equals(encoderPassword(password));
    }
}
