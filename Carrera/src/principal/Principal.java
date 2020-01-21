package principal;

import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		Coche c = null;
		int opcion=0;
		
		//Dime los datos de la carrera
		
		Carrera carrera = new Carrera("Informatica Race", 200);
		
		Menu menu = new Menu();
		do {
			try {
				opcion = menu.pintaMenu();
				switch (opcion) {
				case 1:
					if(c!=null) {
						c.arrancar();
						do{
							leer = new Scanner(System.in);
							int elec;
							System.out.println("Ponga 1 si quiere acelerar, 2 si quiere frenar o 3 si quiere rearrancar");
							try {
								elec = leer.nextInt();
								if(elec==1) {
									if(c.getEstado().equalsIgnoreCase("MARCHA")) {
									c.acelerar();
									}
								}else if(elec==2) {
									if(c.getEstado().equalsIgnoreCase("MARCHA")) {
										c.frenar();
									}
								}
								if(elec==3) {
									if(c.getEstado().equalsIgnoreCase("ACCIDENTADO")) {
										c.rearrancar();
									}else {
										System.out.println("El coche est� arrancado");
									}
								}
							} catch (Exception e) {
								// TODO: handle exception
							}
						}while(c.getKmRecorridos()<c.getDistancia());
						c.setEstado("TERMINADO");
						c.setVelocidad(0);
						c.setKmRecorridos(0);
					}else {
						System.out.println("Carrera no configurada");
					}
					break;
				case 2:
					
					break;
				case 3:
					System.out.println("Saliendo");
					break;
				}
			}catch (Exception e) {
				System.out.println("Dato no v�lido");
			}
		}while(opcion!=3);
	}
}