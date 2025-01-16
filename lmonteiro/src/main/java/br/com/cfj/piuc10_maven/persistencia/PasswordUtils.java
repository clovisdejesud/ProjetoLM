package br.com.cfj.piuc10_maven.persistencia;

public class PasswordUtils {

    public boolean checkPassword(String senhaDigitada, String senhaArmazenada) {
        return senhaDigitada.equals(senhaArmazenada);
    }

    public static boolean isSequential(String password) {
        if (password == null || password.length() <= 7) {
            return false;
        }

        for (int i = 0; i < password.length() - 1; i++) {
            char current = password.charAt(i);
            char next = password.charAt(i + 1);

            if (next - current == i+1 || next - current == i-(-1)) {
                return true;
            }
        }
        return false;
    }

}
