package com.company;

public class OperacionsBanc {

    public static boolean verifyDNI(String dni) {

        if (dni.length() != 9) {
            return false;
        }

        String numerosDNI = "";
        char letraDNI = dni.charAt(dni.length() - 1);
        letraDNI = Character.toUpperCase(letraDNI);

        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P',
                'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
                'H', 'L', 'C', 'K', 'E'};

        for (int i = 0; i < dni.length() - 1; i++) {
            numerosDNI += dni.charAt(i);
        }

        int residuo = Integer.parseInt(numerosDNI) % 23;

        for (int j = 0; j < 23; j++) {
            if (residuo == j) {
                if (letraDNI == letras[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
