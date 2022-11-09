package ejercicioFinal.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_guerrero")
public class Guerrero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String tipo;
	
	private double puntosAtaque;
	
	private double puntosDefensa;
	
	private double puntosVida;

	
	
	
	
	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public String getTipo() {
		return tipo;
	}





	public void setTipo(String tipo) {
		this.tipo = tipo;
	}





	public double getPuntosAtaque() {
		return puntosAtaque;
	}





	public void setPuntosAtaque(double puntosAtaque) {
		this.puntosAtaque = puntosAtaque;
	}





	public double getPuntosDefensa() {
		return puntosDefensa;
	}





	public void setPuntosDefensa(double puntosDefensa) {
		this.puntosDefensa = puntosDefensa;
	}





	public double getPuntosVida() {
		return puntosVida;
	}





	public void setPuntosVida(double puntosVida) {
		this.puntosVida = puntosVida;
	}





	public Guerrero() {
		super();
	}





	public Guerrero(int id, String nombre, String tipo, double puntosAtaque, double puntosDefensa, double puntosVida) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.puntosAtaque = puntosAtaque;
		this.puntosDefensa = puntosDefensa;
		this.puntosVida = puntosVida;
	}





	@Override
	public String toString() {
		return String.format("Guerrero [id=%s, nombre=%s, tipo=%s, puntosAtaque=%s, puntosDefensa=%s, puntosVida=%s]",
				id, nombre, tipo, puntosAtaque, puntosDefensa, puntosVida);
	}
	
	
	
	
}
