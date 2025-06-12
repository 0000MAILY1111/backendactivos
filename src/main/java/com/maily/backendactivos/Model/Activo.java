package com.maily.backendactivos.Model;

import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "activos")
public class Activo {
	@Id
	private String _id;
	private String nombre;
	private String descripcion;
	private Categoria categoria;
	private String fechaAdquisicion;
	private String precio;
	private String estado;
	
	
	public Activo() {
		this._id = UUID.randomUUID().toString();
	}

	public Activo(String _id) {
		 this._id = _id;
	}
	
	public Activo(String nombre, String descripcion, Categoria categoria, String fechaAdquisicion,String precio, String estado) {
		this._id = UUID.randomUUID().toString();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.fechaAdquisicion = fechaAdquisicion;
		this.precio = precio;
		this.estado = estado;
	}
	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getFechaAdquisicion() {
		return fechaAdquisicion;
	}

	public void setFechaAdquisicion(String fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	        Activo activo = (Activo) o;

	        return _id.equals(activo._id);
	    }

		@Override
	    public int hashCode() {
	        return _id.hashCode();
	    }

	    @Override
	    public String toString() {
	        return "Activo{" +
	                "id=" + _id +
	                ", firstName='" + nombre + '\'' +
	                ", lastName='" + descripcion + '\'' +
	                '}';
	    }
	
}
