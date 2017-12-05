package edu.uniajc.dto;


import java.io.Serializable;

import edu.uniajc.model.Factura;
import edu.uniajc.model.Producto;

public class DetalleFacturaDTO implements Serializable {

	@Override
	public String toString() {
		return "DetalleFacturaDTO [identificador=" + identificador + ", codigo=" + codigo + ", factura=" + factura.getCodigo()
				+ ", producto=" + producto.getCodigo() + ", cantidad=" + cantidad 
				+ ", descProducto=" + descProducto + ", precioProducto=" + precioProducto + "]";
	}
	private int identificador;
	private int codigo;
	private Factura factura;
	private Producto producto;
	private Integer cantidad;
	private Integer idProducto;
	private Integer idFactura;
	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}
	private String descProducto;
	private double precioProducto;
	
	public DetalleFacturaDTO() {
	}
	
	public DetalleFacturaDTO(int identificador) {
		this.identificador = identificador;
	}
	
	
	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getDescProducto() {
		return descProducto;
	}
	public void setDescProducto(String descProducto) {
		this.descProducto = descProducto;
	}
	public double getPrecioProducto() {
		return precioProducto;
	}
	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}
	
	
	
	
	
}
