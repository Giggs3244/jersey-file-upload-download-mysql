package com.giggs.provider;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import com.giggs.util.RespuestaGeneral;

public class DatabaseException extends Exception implements ExceptionMapper<DatabaseException> {

	private static final long serialVersionUID = 1L;

	public DatabaseException(String mensaje) {
		super(mensaje);
	}

	public DatabaseException(String mensaje, Exception exception) {
		super(mensaje, exception);
	}

	@Override
	public Response toResponse(DatabaseException exception) {
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(new RespuestaGeneral(500, "No se pudo guardar la entidad."))
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

}
