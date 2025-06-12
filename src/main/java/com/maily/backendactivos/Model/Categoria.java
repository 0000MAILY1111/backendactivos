package com.maily.backendactivos.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="categoria")
public class Categoria {
	@Id
	private String _id;
	private String nombre;
	private String descripcion;
	
	
	public Categoria() {
		
	}

	public Categoria(String _id) {
		 this._id = _id;
	}

	public Categoria( String _id,String nombre, String descripcion) {
		 this._id = _id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        Categoria categoria = (Categoria) o;

	        return _id.equals(categoria._id);
	    }

		@Override
	    public int hashCode() {
	        return _id.hashCode();
	    }

	    @Override
	    public String toString() {
	        return "Activo{" +
	                "id=" + _id +
	                ", nombre='" + nombre + '\'' +
	                ", descripcion='" + descripcion + '\'' +
	                '}';
	    }
}
