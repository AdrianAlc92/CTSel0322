package arreglos;

public class ArreglosUnidimencional {

	public static void main(String[] args) {
		// Ejemplo de declaracion arrays
		int intArray[];
		int[] intArray2;
		long longArray[];

		String[] arr;
		// asigna memoria para 5 posiciones
		arr = new String[5];

		arr[0] = "cero";
		arr[1] = "uno";
		arr[2] = "dos";
		arr[3] = "tres";
		arr[4] = "cuatro";

		System.out.println("El elemento en la posicion 2 es: " + arr[2]);
		System.out.println("El elemento en la posicion 2 es: " + arr[4]);

		for (int i = 0; i < arr.length; i++) {
			System.out.println("Elemento en el indice: " + i + ": " + arr[i]);
		}
		
		System.out.println();
		String[] sArray = new String[] { "cero", "uno" };
		for (int i = 0; i < sArray.length; i++) {
			System.out.println("Elemento en el indice: " + i + ": " + arr[i]);
		}
	}

}
