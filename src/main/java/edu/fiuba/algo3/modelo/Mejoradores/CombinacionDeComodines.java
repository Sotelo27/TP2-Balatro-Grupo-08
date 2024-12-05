package edu.fiuba.algo3.modelo.Mejoradores;
import edu.fiuba.algo3.modelo.Mejoras.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class CombinacionDeComodines implements IMejorador{
	private  List<Comodin> comodines;
	private  String nombre;
	private  String descripcion;

	public CombinacionDeComodines() {

	}
	public CombinacionDeComodines(String nombre, List<Comodin> comodines) {
		this.nombre = nombre;
		this.comodines = comodines;
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
}