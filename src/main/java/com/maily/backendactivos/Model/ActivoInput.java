package com.maily.backendactivos.Model;

import org.springframework.data.annotation.Id;

public class ActivoInput {
	@Id
	private String _id;
	private String nombre;
	private String descripcion;
	private Categoria categoria;
	private String fechaAdquisicion;
	private String precio;
	private String estado;
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
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
