package com.maily.backendactivos.Model;

import java.util.Random;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "alquilers")
public class Alquiler {
	@Id
	private Long alquilerId;
	private  Activo activo;
	private Cliente cliente;
	private String fechaInicio;
    private String fechaFin;
    private String monto;
    private String descripcion;
	
	public Alquiler() {
		 this.alquilerId = new Random().nextLong();
	}

	public Alquiler(Long alquilerId) {
		 this.alquilerId = alquilerId;
	}
	
	public Alquiler( Cliente cliente, Activo activo,String fechaInicio,String fechaFin, String monto, String descripcion) {
		 this.alquilerId = new Random().nextLong();
		this.cliente = cliente;
		this.activo = activo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.monto = monto;
		this.descripcion = descripcion;
	}
	
	
	 public Long getAlquilerId() {
		return alquilerId;
	}

	public void setAlquilerId(Long alquilerId) {
		this.alquilerId = alquilerId;
	}

	public Object getActivo() {
		return activo;
	}

	public void setActivo(Activo activo) {
		this.activo = activo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
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

	        Alquiler alquiler = (Alquiler) o;

	        return alquilerId.equals(alquiler.alquilerId);
	    }

		@Override
	    public int hashCode() {
	        return alquilerId.hashCode();
	    }

	 
	
}
