package encapsulamiento;

public class Encapsulamiento_Demo {

	public static void main(String[] args) {
		Encap_ejemplo en = new Encap_ejemplo();
		
		en.setTipo(10);
		
		System.out.println("El tipo es: " + en.getTipo());
	}

}
