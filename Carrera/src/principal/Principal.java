package principal;

import java.util.InputMismatchException;
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
					if(carrera.carreraConfigurada()) {
						
					}else {
						System.out.println("La carrera requiere al menos dos participantes");
					}
					if(c!=null) {
						c.arrancar();
						do{
							leer = new Scanner(System.in);
							int elec;
							System.out.println("1- Acelerar");
							System.out.println("2- Frenar");
							System.out.println("3- Rearrancar");
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
										System.out.println("El coche está arrancado");
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
					carrera.crearCoche();
					break;
				case 3:
					System.out.println("Saliendo");
					break;
				}
			}catch (InputMismatchException e) {
				System.out.println("Dato no válido");
			}catch (Exception e) {
				System.out.println("Error detectado");
			}
		}while(opcion!=3);
	}
}