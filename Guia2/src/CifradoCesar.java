import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class CifradoCesar {

	public static void main(String[] args) throws IOException{

		BufferedReader entrada =new BufferedReader(new InputStreamReader(System.in));

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



			// ================================================
			// MENSAJE QUE INGRESA EL USUARIO
			// ================================================

			System.out.print("Seleccione una opción: ");
			opcion = Integer.parseInt(entrada.readLine());

			// ================================================
			// VARIABLES CICLO DO-WHILE
			// ================================================

			int desplazamiento;
			String mensaje;     

			switch (opcion) {

			// ========================================
			// OPCIÓN 1 - CIFRAR
			// ========================================
			case 1:

				System.out.print("Ingrese el Mensaje: ");
				mensaje = entrada.readLine();
				System.out.print("Ingrese el desplazamiento: ");
				desplazamiento = Integer.parseInt(entrada.readLine());

				System.out.print("Seleccione opcion 1 para cifrar\nSeleccione opcion 2 para recifrar\n");
				int seleccion = Integer.parseInt(entrada.readLine());

				if (seleccion == 1) { 

					String mensajeCifrado =Cifrado.cifrar(mensaje, desplazamiento);

					System.out.println();
					System.out.println("----- CIFRADO -----");
					System.out.println("Mensaje original:  " + mensaje);
					System.out.println("Desplazamiento:    " + desplazamiento);
					System.out.println("Mensaje cifrado:   " + mensajeCifrado);

					break;
				}				

				else {

					System.out.println("cuantas veces se recifrara: ");
					int veces = Integer.parseInt(entrada.readLine());
					String mensajeRepetirCifrado =Cifrado.repetirCifrado(mensaje, desplazamiento, veces);

					System.out.println();
					System.out.println("----- CIFRADO -----");
					System.out.println("Mensaje original:  " + mensaje);
					System.out.println("Desplazamiento:    " + desplazamiento);
					System.out.println("Mensaje Recifrado: " + mensajeRepetirCifrado);
					System.out.println("Se recifro  :      "+ veces + " veces" );

					break;					
				}
				// ========================================
				// OPCIÓN 2 - DESCIFRAR
				// ========================================
			case 2:
				System.out.print("Ingrese el Mensaje: ");
				mensaje = entrada.readLine();

				System.out.print("Ingrese el desplazamiento: ");
				desplazamiento = Integer.parseInt(entrada.readLine());

				System.out.println("Ingrese el mensaje cifrado que desea descifrar: ");

				String mensajeCifradoUsuario = mensaje;
				//entrada.readLine();

				System.out.println("Ingrese el desplazamiento utilizado: ");


				String mensajeDescifrado =Cifrado.descifrar(mensajeCifradoUsuario,desplazamiento);

				System.out.println();
				System.out.println("----- DESCIFRADO -----");
				System.out.println("Mensaje cifrado:    "+ mensajeCifradoUsuario);
				System.out.println("Desplazamiento:     "+ desplazamiento);
				System.out.println("Mensaje descifrado: " + mensajeDescifrado
						);

				break;

				// ========================================
				// OPCIÓN 3 - FRECUENCIA
				// ========================================
			case 3:

				System.out.print("Ingrese el Mensaje: ");
				mensaje = entrada.readLine();

				String frecuencia =Cifrado.analizarFrecuencia(mensaje);

				System.out.println();
				System.out.println("----- FRECUENCIA -----");
				System.out.println("Mensaje analizado: " + mensaje);
				System.out.println();
				System.out.println(frecuencia);

				break;

				// ========================================
				// OPCIÓN 4 - PALÍNDROMO
				// ========================================
			case 4:
				System.out.print("Ingrese el Mensaje: ");
				mensaje = entrada.readLine();
				String normalizado =
						mensaje.replace(" ", "").toLowerCase();

				boolean resultadoPalindromo = Cifrado.esPalindromo(mensaje);
				System.out.println();
				System.out.println("----- PALÍNDROMO -----");
				System.out.println("Texto analizado: " + mensaje);
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