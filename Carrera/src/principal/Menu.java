package principal;

import java.util.Scanner;

public class Menu {
	public int pintaMenu() {
		Scanner leer = new Scanner(System.in);
		int opc = 0;
		do {
			System.out.println("1- Empezar la carrera");
			System.out.println("2- Registrar piloto");
			System.out.println("3- Salir");
			opc = leer.nextInt();
		}while(opc>3 || opc<1);
		return opc;
	}
	public int pintaMenu2() {
		Scanner leer = new Scanner(System.in);
		int opc = 0;
		do {
			System.out.println("1- Acelerar");
			System.out.println("2- Frenar");
			System.out.println("3- Rearrancar");
		}while(opc>3 || opc<1);
		return opc;
	}
}
