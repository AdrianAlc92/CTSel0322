package herencia;

public class Lados {

	public static void main(String[] args) {
		Triangulo t1 = new Triangulo();
		
		t1.base = 4.0;
		t1.altura= 4.0;
		t1.estilo= "Estilo 1";
		
		System.out.println("Informacion para t1: ");
		t1.mostrarEstilo();
		t1.mostrarDimension();
		System.out.println("El area es "+t1.area());
		
		Triangulo t2 = new Triangulo();
		System.out.println();
		
		t2.base = 8.0;
		t2.altura= 12.0;
		t2.estilo= "Estilo 2";
		
		System.out.println("Informacion para t2: ");
		t2.mostrarEstilo();
		t2.mostrarDimension();
		System.out.println("El area es "+t2.area());
		
	}

}
