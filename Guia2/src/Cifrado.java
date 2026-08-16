import java.io.BufferedReader;
import java.io.IOException;

public class Cifrado {

	// MÉTODO CIFRAR

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

	// MÉTODO DESCIFRAR

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

	// MÉTODO FRECUENCIA

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


	//MÉTODO PANLINDROMO

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


	// MÉTODO REPETIR CIFRADO

	static String repetirCifrado(String mensaje, int desplazamiento, int veces) {

		String resultado = mensaje;

		for (int i = 0; i < veces; i++) {


			resultado = cifrar(resultado,desplazamiento);
			System.out.println ("Ciclo No "+ (i+1) +" " + resultado);



		}

		return resultado;
	}
	
	
		// CONTROL ERROR ENTERO
	
	static int leerEntero(BufferedReader entradaNumero) throws IOException {
	    int numero;

	    while (true) {
	        try {
	            numero = Integer.parseInt(entradaNumero.readLine());
	            while (numero<=0) { 
	            	System.out.println("Error: debe ingresar un número entero positivo mayor que 0.");
	            	System.out.print("Intente nuevamente: ");
	            	numero = Integer.parseInt(entradaNumero.readLine());
	            	
	            }
	            return numero;

	        } catch (NumberFormatException e) {
	            System.out.println("Error: debe ingresar un número entero.");
	            System.out.print("Intente nuevamente: ");
	        }
	    }
	}
	
	
	// RESTRINGIR ENTRADAS
		public static String leerSoloLetras(BufferedReader entradaTexto) throws IOException							
		{
		    String texto;
	 
		    do																									// Solicita el texto hasta que cumple las condiciones
		    {
		        texto = entradaTexto.readLine();
	 
		        if (!texto.matches("[a-zA-Z ]+"))																// Solo letras del álfabeto inglés, espacios y uno o varios carácteres
		        {
		            System.out.println("Error: solo se permiten letras y espacios"); // 
		            System.out.print("Intente nuevamente: ");
		        }
	 
		    }
		    while (!texto.matches("[a-zA-Z ]+"));																// Solo letras del álfabeto inglés, espacios y uno o varios carácteres
	 
		    return texto;
		}
	
	
	
	
}