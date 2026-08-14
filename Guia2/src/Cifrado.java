import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Cifrado {

	public static void main(String[] args) throws IOException{

		///COMENTARIO PRUEBA GITHUB
		///COMENTARIO PRUEBA GITHUB2	
		BufferedReader entrada =new BufferedReader(new InputStreamReader(System.in));

		// ================================================
		// MENSAJE QUE INGRESA EL USUARIO
		// ================================================
		//System.out.print("Ingrese el mensaje: ");
		String mensaje1 = "Hola Mundo Java"; //entrada.readLine();
		String mensaje2 = "Anita lava la tina";//entrada.readLine();
		String mensaje3 = "Wxor Jyxbq"; //entrada.readLine();
		int desplazamiento = 3;  //Integer.parseInt(entrada.readLine())


		// ================================================
		// ARREGLO DE SIMULACIÓN SOLICITADO
		// ================================================

		int[] opciones = {1, 2, 3, 4, 5};

		int opcion = 0;

		// ================================================
		// MENÚ PRINCIPAL
		// ================================================

		do {

			System.out.println();
			System.out.println("==============================================");
			System.out.println("       SISTEMA DE CIFRADO CÉSAR");
			System.out.println("==============================================");
			System.out.println(opciones[0] + ". Cifrar un mensaje");
			System.out.println(opciones[1] + ". Descifrar un mensaje");
			System.out.println(opciones[2] + ". Analizar frecuencia de caracteres");
			System.out.println(opciones[3] + ". Verificar si un mensaje es palindromo");
			System.out.println(opciones[4] + ". Salir");
			System.out.println("=============================================="); 

			System.out.print("Seleccione una opción: ");

			opcion = Integer.parseInt(entrada.readLine());

			switch (opcion) {

			// ========================================
			// OPCIÓN 1 - CIFRAR
			// ========================================
			case 1:

				System.out.print("Seleccione opcion 1 para cifrar y opcion 2 para recifrar: ");
				int seleccion = Integer.parseInt(entrada.readLine());

				if (seleccion == 1) { 

					String mensajeCifrado =
							CifradoCesar.cifrar(mensaje1, desplazamiento);

					System.out.println();
					System.out.println("----- CIFRADO -----");
					System.out.println("Mensaje original:  " + mensaje1);
					System.out.println("Desplazamiento:    " + desplazamiento);
					System.out.println("Mensaje cifrado:   " + mensajeCifrado);

					break;
				}				

				else {

					System.out.println("cuantas veces se recifrara: ");
					int veces = Integer.parseInt(entrada.readLine());
					String mensajeRepetirCifrado =
							CifradoCesar.repetirCifrado(mensaje1, desplazamiento, veces);

					System.out.println();
					System.out.println("----- CIFRADO -----");
					System.out.println("Mensaje original:  " + mensaje1);
					System.out.println("Desplazamiento:    " + desplazamiento);
					System.out.println("Mensaje Recifrado: " + mensajeRepetirCifrado);
					System.out.println("Se recifro  :      "+ veces + " veces" );

					break;					
				}
				// ========================================
				// OPCIÓN 2 - DESCIFRAR
				// ========================================
			case 2:

				System.out.println("Ingrese el mensaje cifrado que desea descifrar: ");

				String mensajeCifradoUsuario = mensaje3;
				//entrada.readLine();

				System.out.println("Ingrese el desplazamiento utilizado: ");

				int desplazamientoDescifrar =10;
				//Integer.parseInt(entrada.readLine());

				String mensajeDescifrado =
						CifradoCesar.descifrar(
								mensajeCifradoUsuario,
								desplazamientoDescifrar
								);

				System.out.println();
				System.out.println("----- DESCIFRADO -----");
				System.out.println("Mensaje cifrado:    "+ mensajeCifradoUsuario);
				System.out.println("Desplazamiento:     "+ desplazamientoDescifrar);
				System.out.println("Mensaje descifrado: " + mensajeDescifrado
						);

				break;

				// ========================================
				// OPCIÓN 3 - FRECUENCIA
				// ========================================
			case 3:

				String frecuencia =
				CifradoCesar.analizarFrecuencia(mensaje1);

				System.out.println();
				System.out.println("----- FRECUENCIA -----");
				System.out.println("Mensaje analizado: " + mensaje1);
				System.out.println();
				System.out.println(frecuencia);

				break;

				// ========================================
				// OPCIÓN 4 - PALÍNDROMO
				// ========================================
			case 4:

				String normalizado =
				mensaje2.replace(" ", "").toLowerCase();

				boolean resultadoPalindromo = CifradoCesar.esPalindromo(mensaje2);
				System.out.println();
				System.out.println("----- PALÍNDROMO -----");
				System.out.println("Texto analizado: " + mensaje2);
				System.out.println("Texto normalizado: " + normalizado);
				System.out.println("¿Es palíndromo? "+ resultadoPalindromo);
				break;
				// ========================================
				// OPCIÓN 5 - SALIR
				// ========================================
			case 5:
				System.out.println();
				System.out.println("Saliendo del sistema...");
				System.out.println("Programa finalizado.");		
				break;
				// ========================================
				// OPCIÓN INVÁLIDA
				// ========================================
			default:
				System.out.println();
				System.out.println("Opción inválida.");
				break;
			}

		}
		while (opcion != 5); 

	}

}      