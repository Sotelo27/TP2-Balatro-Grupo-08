package edu.fiuba.algo3.modelo.Mejoradores;
import edu.fiuba.algo3.modelo.ICarta;
import edu.fiuba.algo3.modelo.IComprador;
import edu.fiuba.algo3.modelo.Mejoras.*;

import java.util.List;

public class CombinacionDeComodines implements IMejorador, ICarta{
	private  List<Comodin> comodines;
	private  String nombre;
	private  String descripcion;

	public CombinacionDeComodines() {

	}
	public CombinacionDeComodines(String nombre,String descripcion, List<Comodin> comodines) {
		this.nombre = nombre;
		this.comodines = comodines;
		this.descripcion = descripcion;
	}

	public void setComodines(List<Comodin> comodines) {
		this.comodines = comodines;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public void mejorar(IMejorable mejorable){
		for (Comodin comodin: this.comodines){
			comodin.mejorar(mejorable);
		}
	}
	@Override
    public String getNombre() {
		return this.nombre;
    }

	@Override
	public String getDescripcion() {
		return descripcion;
	}

	@Override
	public String getImagen() {
		return "/images/jokers/JokerCombinado.png";
	}

	@Override
	public void asignarAComprador(IComprador comprador) {
		comprador.comprarComodin(this);
	}

	@Override
	public ICarta getCarta(){
		return this;
	}
}