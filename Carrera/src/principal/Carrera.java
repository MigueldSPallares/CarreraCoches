package principal;

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
		String nom;
		double distancia;
		System.out.println("Pon el nombre del piloto");
		nom = leer.nextLine();
		System.out.println("Pon la dorsal del piloto");
		dorsal = leer.nextInt();
		System.out.println("Pon la distancia de la carrera");
		distancia = leer.nextDouble();
	}

	
	
}
