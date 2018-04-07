package mcgdp.cont.main;

public class Main {
	public static void main(String[]args) {
		Sys sistema = new Sys();								// Inicio de sistema
		sistema.init();
		System.out.println(args);								// Impresión de inicio
	}
}