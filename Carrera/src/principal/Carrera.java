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
		int pos = 0;
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
				break;
			}
		}
		if (bandera) {
			vParticipantes[pos] = new Coche(nom, dorsal, distanciaCarrera);
			System.out.println("Participante a�adido");
		} else {
			System.out.println("No se puede a�adir m�s participantes");
		}
	}

	public int numCoches() {
		int numCoche = 0;
		for (int i = 0; i < vParticipantes.length; i++) {
			if (vParticipantes[i] != null) {
				numCoche++;
			}
		}
		return numCoche;
	}

	public int numCochesMarcha() {
		int numCocheMar = 0;
		for (int i = 0; i < vParticipantes.length; i++) {
			if (vParticipantes[i] != null && vParticipantes[i].getEstado().equalsIgnoreCase("Marcha")) {
				numCocheMar++;
			}
		}
		return numCocheMar;
	}

	public int numCochesTerminado() {
		int numCocheTer = 0;
		for (int i = 0; i < vParticipantes.length; i++) {
			if (vParticipantes[i] != null && vParticipantes[i].getEstado().equalsIgnoreCase("Terminado")) {
				numCocheTer++;
			}
		}
		return numCocheTer;
	}

	public boolean poderRearrancar() {
		boolean lleg = true;
		for (Coche coche : vParticipantes) {
			if (coche.getEstado().equalsIgnoreCase("Terminado")) {
				lleg = false;
				break;
			}
		}
		return lleg;
	}

	public boolean carreraTerminada() {
		boolean term = true;
		for (int i = 0; i < numCoches(); i++) {
			Coche coche = vParticipantes[i];
			if (coche != null) {
				if (coche.getEstado().equalsIgnoreCase("Marcha")) {
					term = false;
					break;
				}
			}
		}return term;

	}

	public boolean carreraConfigurada() {
		int partinTotal = 0;
		for (int i = 0; i < vParticipantes.length; i++) {
			if (vParticipantes[i] != null) {
				partinTotal++;
			}
		}
		if (partinTotal > 1) {
			return true;
		} else {
			return false;
		}
	}

	public void jugar() {
		Menu menu = new Menu();
		for (int i = 0; i < vParticipantes.length; i++) {
			if (vParticipantes[i] != null) {
				vParticipantes[i].arrancar();
			}
		}
		do {
			for (int i = 0; i < vParticipantes.length; i++) {
				Coche coche = vParticipantes[i];
				int elec;
				if (coche != null) {
					if (!coche.getEstado().equalsIgnoreCase("Terminado")) {
						System.out.println("Corredor " + (i + 1));
						elec = menu.pintaMenu2();
						try {
							switch (elec) {
							case 1:
								if (coche.getEstado().equalsIgnoreCase("Marcha")) {
									coche.acelerar();
								}
								break;
							case 2:
								if (coche.getEstado().equalsIgnoreCase("Marcha")) {
									coche.frenar();
								}
								break;
							case 3:
								if (coche.getEstado().equalsIgnoreCase("Accidentado")) {
									coche.rearrancar();
								} else {
									System.out.println("El coche no est� accidentado");
								}
								break;
							default:
								break;
							}
							if (coche.getKmRecorridos() >= getDistanciaCarrera()) {
								coche.setEstado("Terminado");
							}
						} catch (InputMismatchException e) {
							System.out.println("Dato no v�lido");
						} catch (Exception e) {
							System.out.println("Error detectado");
						}
						System.out.println("Participan " + numCoches() + " coches");
						System.out.println("Hay " + numCochesMarcha() + " coches arrancados");
						System.out.println("Hay " + numCochesTerminado() + " coches que han terminado");
						if (carreraTerminada()) {
							System.out.println("La carrera ha terminado");
						} else {
							System.out.println("La carrera no ha terminado");
						}
					}
				}
			}
		} while (!carreraTerminada());
	}
}
