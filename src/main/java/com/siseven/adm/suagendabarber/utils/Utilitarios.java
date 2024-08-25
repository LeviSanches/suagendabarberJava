package com.siseven.adm.suagendabarber.utils;

public class Utilitarios {

    /**
     * Representa uma String vazia.
     */
    public static final String STRING_EMPTY = "";

    /**
     *
     * Objetivo: Verificar se a String é nula ou vazia.
     *
     * @param string
     *            String a ser comparada.
     * @return true se a String for nula ou vazia ou false caso contr�rio.
     */
    public static boolean isEmptyOrNull(String string) {

        return (string == null || string.trim().equals(STRING_EMPTY));
    }

    /**
     * Objetivo: Verificar se o Objeto é nulo ou vazio.
     *
     * @param object Oject a ser comparada.
     * @return true, caso contrário, false
     * @see
     */
    public static boolean isEmptyOrNull(Object object) {
        // decisao
        return (object == null) || object.toString().trim().equals(STRING_EMPTY);
    }

    /**
     * Nome: removerCaracteresNaoNumericos Remover caracteres nao numericos.
     *
     * @param string
     *            the p campo
     * @return string
     * @see
     */
    public static String removerCaracteresNaoNumericos(String string) {
        if (Utilitarios.isNotEmptyOrNull(string)) {
            return string.replaceAll("[^\\d]", "");
        } else {
            return STRING_EMPTY;
        }
    }

    /**
     * Verifica se String é vazia ou nulo.
     *
     * @param string the campo
     * @return true, if is not empty or null
     */
    public static boolean isNotEmptyOrNull(String string) {
        return !isEmptyOrNull(string);
    }


}