package edu.uniajc.dto;

import java.util.Date;

import edu.uniajc.model.Cliente;
import edu.uniajc.model.Tercero;

public class FacturaDTO {

	private int codigo;
	private Cliente cliente;
	private Tercero tercero;
	private Date fecha;
	private String nombreCompletoCliente;
	private int idCliente;
	private String nombreCompletoTercero;
	private int idTercero;
	
	
	public String getNombreCompletoCliente() {
		return nombreCompletoCliente;
	}
	public void setNombreCompletoCliente(String nombreCompletoCliente) {
		this.nombreCompletoCliente = nombreCompletoCliente;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombreCompletoTercero() {
		return nombreCompletoTercero;
	}
	public void setNombreCompletoTercero(String nombreCompletoTercero) {
		this.nombreCompletoTercero = nombreCompletoTercero;
	}
	public int getIdTercero() {
		return idTercero;
	}
	public void setIdTercero(int idTercero) {
		this.idTercero = idTercero;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Tercero getTercero() {
		return tercero;
	}
	public void setTercero(Tercero tercero) {
		this.tercero = tercero;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
}
