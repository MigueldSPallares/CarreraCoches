package principal;

import java.util.Random;

public class Coche {
	private String nombrePiloto;
	private int dorsal;
	private double distancia;
	private String estado;
	private int potencia;
	private double velocidad;
	private double kmRecorridos;
	
	public Coche(String nombrePiloto, int dorsal, double distancia) {
		this.nombrePiloto = nombrePiloto;
		this.dorsal = dorsal;
		this.distancia = distancia;
		this.estado = "PARADO";
		this.potencia = 50;
		this.velocidad = 0;
		this.kmRecorridos = 0;
	}

	public String getNombrePiloto() {
		return nombrePiloto;
	}

	public void setNombrePiloto(String nombrePiloto) {
		this.nombrePiloto = nombrePiloto;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public String getEstado() {
		return estado;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public double getKmRecorridos() {
		return kmRecorridos;
	}
	
	public int getPotencia() {
		return potencia;
	}
	
	public void arrancar() {
		estado = "MARCHA";
	}
	
	public void acelerar() {
		Random r = new Random();
		int x = r.nextInt(potencia+1);
		velocidad = velocidad+x;
		if(velocidad>=200) {
			estado = "ACCIDENTADO";
			velocidad = 0;
		}else {
			kmRecorridos = kmRecorridos+velocidad;
			if(kmRecorridos>distancia) {
				System.out.println("Kilometros recorridos" + distancia);
			}else {
				System.out.println("Kilometros recorridos: " + kmRecorridos);
			}
		}
		System.out.println("Velocidad: "+velocidad);
	}

	public void frenar() {
		Random r = new Random();
		int x = r.nextInt(potencia+1);
		
		if(velocidad>=x) {
			velocidad = velocidad-x;
			kmRecorridos = kmRecorridos+x;
		}else {
			velocidad = 0;
			kmRecorridos = kmRecorridos+velocidad;
		}
		if(kmRecorridos>distancia) {
			System.out.println("Kilometros recorridos" + distancia);
		}else {
			System.out.println("Kilometros recorridos: " + kmRecorridos);
		}
		System.out.println("Velocidad: " + velocidad);
	}
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	public void setKmRecorridos(double kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void rearrancar() {
		estado="MARCHA";
	}
}
