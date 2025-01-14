package br.com.cfj.piuc10_maven.persistencia;


public class PasswordUtils {

    public boolean checkPassword(String senhaDigitada, String senhaArmazenada) {
        return senhaDigitada.equals(senhaArmazenada);
    }

}
