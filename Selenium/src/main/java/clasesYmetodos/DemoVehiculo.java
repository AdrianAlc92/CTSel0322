package clasesYmetodos;

public class DemoVehiculo {

	public static void main(String[] args) {
		Vehiculo minivan = new Vehiculo();

		int rango;

		// Asignar valores a campos minivan

		minivan.pasajeros = 9;
		minivan.capacidad = 15;
		minivan.km = 20;

		// Calcular el rango asumiento un tanque lleno

		rango = minivan.capacidad * minivan.km;
		System.out.println(
				"La minivan puede llevar " + minivan.pasajeros + " pasajeros con un rango de " + rango + " kilometros");

	}

}
