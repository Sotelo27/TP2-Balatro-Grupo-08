package edu.fiuba.algo3.modelo.Mejoradores;
import edu.fiuba.algo3.modelo.Mejoras.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class CombinacionDeComodines implements IMejorador{
	private final List<Comodin> comodines;
	private final String nombre;
	private final String descripcion;

	@JsonCreator
	public CombinacionDeComodines(@JsonProperty("nombre") String nombre,@JsonProperty("descripcion") String descripcion, @JsonProperty("comodines") List<Comodin> comodines) {
		this.nombre = nombre;
		this.comodines = comodines;
		this.descripcion = descripcion;
	}
	public CombinacionDeComodines(String nombre, List<Comodin> comodines) {
		this.nombre = nombre;
		this.comodines = comodines;
		this.descripcion = "";
	}
	@Override
	public void mejorar(IMejorable mejorable){
		for (Comodin comodin: this.comodines){
			comodin.mejorar(mejorable);
		}
	}

}