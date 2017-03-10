package com.giggs.util;

public class RespuestaGeneral {

	private int codigo;
	private String mensaje;

	public RespuestaGeneral() {
		// no-args constructor
	}

	public RespuestaGeneral(int codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
