package com.maily.backendactivos.Model;

import java.util.Random;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "clientes")
public class Cliente {
	@Id
	private Long clienteId;
	private String nombre;
	private String cedula;
	private String celular;
	private String fechaNacimiento;
	private String direccion;
	
	
	public Cliente() {
		 this.clienteId = new Random().nextLong();
	}

	public Cliente(Long clienteId) {
		 this.clienteId = clienteId;
	}
	
	public Cliente(String nombre, String cedula, String celular, String fechaNacimiento,String direccion) {
		 this.clienteId = new Random().nextLong();
		this.nombre = nombre;
		this.cedula = cedula;
		this.celular = celular;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
	}
	
	 public Long getclienteId() {
		return clienteId;
	}

	public void setclienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	

	@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        Cliente cliente = (Cliente) o;

	        return clienteId.equals(cliente.clienteId);
	    }

		@Override
	    public int hashCode() {
	        return clienteId.hashCode();
	    }

	  
	
}
