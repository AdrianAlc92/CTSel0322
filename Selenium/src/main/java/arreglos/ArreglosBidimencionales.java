package arreglos;

public class ArreglosBidimencionales {

	public static void main(String[] args) {
		int arr[][]= {{2,7,9},{3,6,1},{7,4,2}};
		
		System.out.println(arr[2][1]);
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]);
				System.out.println(arr[i][j]);
			}
			System.out.println();
		}

	}

}
