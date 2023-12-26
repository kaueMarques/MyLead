package dev.mkaue.LeedsDeClientesLojasTal.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneUtil {

    /**
     * Verifica se o número de telefone fornecido corresponde ao formato padrão brasileiro.
     *
     * <p>O formato aceito inclui 8 ou 9 dígitos consecutivos, sem contar caracteres especiais.
     *
     * @param telefone O número de telefone a ser verificado.
     * @return {@code true} se o número de telefone estiver no formato padrão brasileiro,
     *         {@code false} caso contrário.
     */
    public static boolean isTelefoneBrasileiro(String telefone) {
        String regex = "\\d{9}|\\d{8}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(telefone);
        return matcher.matches();
    }
}
