package principal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Carrera {
	private String nombreCarrera;
	private Coche[] vParticipantes;
	private int distanciaCarrera;

	public Carrera(String nombreCarrera, int distanciaCarrera) {

		this.nombreCarrera = nombreCarrera;
		this.distanciaCarrera = distanciaCarrera;
		vParticipantes = new Coche[5];
	}

	public String getNombreCarrera() {
		return nombreCarrera;
	}

	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}

	public int getDistanciaCarrera() {
		return distanciaCarrera;
	}

	public void setDistanciaCarrera(int distanciaCarrera) {
		this.distanciaCarrera = distanciaCarrera;
	}

	public void crearCoche() {
		Scanner leer = new Scanner(System.in);
		int dorsal;
		int pos=0;
		String nom;
		boolean bandera = false;
		System.out.println("Pon la dorsal del piloto");
		dorsal = leer.nextInt();
		for (int i = 0; i < vParticipantes.length; i++) {
			if (vParticipantes[i] != null && dorsal == vParticipantes[i].getDorsal()) {
				System.out.println("Esa dorsal ya se ha puesto. Introduce otra");
				i = 0;
				dorsal = leer.nextInt();
			}
		}
		leer = new Scanner(System.in);
		System.out.println("Pon el nombre del piloto");
		nom = leer.nextLine();
		for (int i = 0; i < vParticipantes.length; i++) {
			if (vParticipantes[i] == null) {
				pos = i;
				bandera = true;
			}
		}
		if (bandera) {
			vParticipantes[pos] = new Coche(nom, dorsal, distanciaCarrera);
			System.out.println ("Participante añadido");
		} else {
			System.out.println("No se puede añadir más participantes");
		}
	}
	
	public int numCoches() {
		int numCoche=0;
		for (int i = 0; i < vParticipantes.length; i++) {
			if (vParticipantes[i] != null) {
				numCoche++;
			}
		}
		return numCoche;
	}
	public int numCochesMarcha() {
		int numCocheMar=0;
		for (int i = 0; i < vParticipantes.length; i++) {
			if (vParticipantes[i] != null && vParticipantes[i].getEstado().equalsIgnoreCase("Marcha")) {
				numCocheMar++;
			}
		}
		return numCocheMar;
	}
	public int numCochesTerminado() {
		int numCocheTer=0;
		for (int i = 0; i < vParticipantes.length; i++) {
			if (vParticipantes[i] != null && vParticipantes[i].getEstado().equalsIgnoreCase("Terminado")) {
				numCocheTer++;
			}
		}
		return numCocheTer;
	}

	public boolean carreraTerminada() {
		boolean lleg=false, term=false;
		for (int i = 0; i < vParticipantes.length; i++) {
			if(vParticipantes[i].getEstado().equalsIgnoreCase("Terminado")) {
				lleg = true;
				break;
			}
		}
		for (int i = 0; i < vParticipantes.length; i++) {
			if(vParticipantes[i].getEstado().equalsIgnoreCase("Terminado") || (vParticipantes[i].getEstado().equalsIgnoreCase("Accidentado")&&lleg)) {
				term = true;
			}else {
				term = false;
				break;
			}
		}
		return term;
	}
	public boolean carreraConfigurada() {
		int partinTotal = 0;
		for (int i = 0; i < vParticipantes.length; i++) {
			if(vParticipantes[i] != null) {
				partinTotal ++;
			}
		}
		if(partinTotal>1) {
			return true;
		}else {
			return false;
		}
	}
	
	public void jugar() {
		Menu menu = new Menu();
		for (int i = 0; i < vParticipantes.length; i++) {
			if(vParticipantes[i] != null) {
				vParticipantes[i].arrancar();
			}
		}
		do {
			for (int i = 0; i < vParticipantes.length; i++) {
				Coche coche = vParticipantes[i];
				int elec;
				elec = menu.pintaMenu2();
				try {
					if(!vParticipantes[i].getEstado().equalsIgnoreCase("Terminado")) {
						switch (elec) {
						case 1:
							if(coche.getEstado().equalsIgnoreCase("Marcha")) {
								coche.acelerar();
							}
							break;
						case 2:
							if(coche.getEstado().equalsIgnoreCase("Marcha")) {
								coche.frenar();
							}
							break;
						case 3:
							if(coche.getEstado().equalsIgnoreCase("Accidentado")) {
								coche.rearrancar();
							}else {
								System.out.println("El coche no está accidentado");
							}
							break;
						default:
							break;
						}
					}
				}catch (InputMismatchException e){
					System.out.println("Dato no válido");
				}catch (Exception e) {
					System.out.println("Error detectado");
				}
				System.out.println("Participan " + numCoches() + " coches");
				System.out.println("Hay " + numCochesMarcha() + " coches arrancados");
				System.out.println("Hay " + numCochesTerminado() + " coches que han terminado");
				if(carreraTerminada()) {
					System.out.println("La carrera ha terminado");
				}else {
					System.out.println("La carrera no ha terminado");
				}
			}
		} while (carreraTerminada());
	}
}
