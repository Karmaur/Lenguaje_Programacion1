public class CifradoCesar {

	
	// =====================================================
    // MÉTODO CIFRAR
    // =====================================================
	
    static String cifrar(String mensaje, int desplazamiento) {

        String resultado = "";

        for (int i = 0; i < mensaje.length(); i++) {

            char ch = mensaje.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {

                ch = (char) (((ch - 'A' + desplazamiento) % 26) + 'A');

            } else if (ch >= 'a' && ch <= 'z') {

                ch = (char) (((ch - 'a' + desplazamiento) % 26) + 'a');
            }

            resultado += ch;
        }

        return resultado;
    }


// =====================================================
// MÉTODO DESCIFRAR
// =====================================================

static String descifrar(String mensajeCifrado, int desplazamiento) {

    String resultado = "";

    for (int i = 0; i < mensajeCifrado.length(); i++) {

        char ch = mensajeCifrado.charAt(i);

        // Si es mayúscula
        if (ch >= 'A' && ch <= 'Z') {

            ch = (char) (((ch - 'A' - desplazamiento + 26) % 26) + 'A');

        // Si es minúscula
        } else if (ch >= 'a' && ch <= 'z') {

            ch = (char) (((ch - 'a' - desplazamiento + 26) % 26) + 'a');
        }

        resultado += ch;
    }

    return resultado;
}


// =====================================================
// MÉTODO FRECUENCIA
// =====================================================
static String analizarFrecuencia(String mensaje) {

    int contadorA = 0;
    int contadorE = 0;
    int contadorI = 0;
    int contadorO = 0;
    int contadorU = 0;

    int consonantes = 0;

    for (int i = 0; i < mensaje.length(); i++) {

        char ch = Character.toLowerCase(mensaje.charAt(i));

        if (ch == 'a') {

            contadorA++;

        } else if (ch == 'e') {

            contadorE++;

        } else if (ch == 'i') {

            contadorI++;

        } else if (ch == 'o') {

            contadorO++;

        } else if (ch == 'u') {

            contadorU++;

        } else if (ch >= 'a' && ch <= 'z') {

            consonantes++;
        }
    }

    String reporte =
            "Vocal 'a': " + contadorA + "\n" +
            "Vocal 'e': " + contadorE + "\n" +
            "Vocal 'i': " + contadorI + "\n" +
            "Vocal 'o': " + contadorO + "\n" +
            "Vocal 'u': " + contadorU + "\n" +
            "Total consonantes: " + consonantes;

    return reporte;
}


//=====================================================
//MÉTODO PANLINDROMO
//=====================================================

static boolean esPalindromo(String texto) {

    // Eliminar espacios y convertir a minúsculas
    String normalizado = texto.replace(" ", "").toLowerCase();

    // Comparar desde ambos extremos
    for (int i = 0; i < normalizado.length() / 2; i++) {

        char izquierda = normalizado.charAt(i);

        char derecha =
                normalizado.charAt(normalizado.length() - 1 - i);

        if (izquierda != derecha) {

            return false;
        }
    }

    return true;
}
}