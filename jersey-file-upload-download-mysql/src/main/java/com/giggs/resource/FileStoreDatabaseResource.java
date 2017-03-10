package com.giggs.resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.giggs.entity.Filestore;
import com.giggs.provider.DatabaseException;
import com.giggs.repository.FilestoreRepository;
import com.giggs.util.RespuestaGeneral;

@Path("files")
public class FileStoreDatabaseResource {

	private FilestoreRepository filestoreRepository;

	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response uploadFile(@FormDataParam("file") File file,
			@FormDataParam("file") FormDataContentDisposition fileInputDetails, 
			@FormDataParam("id") String id,
			@FormDataParam("description") String description, @FormDataParam("fileYear") String fileYear,
			@FormDataParam("department") String department) throws DatabaseException, IOException {

		FileInputStream inputStream = new FileInputStream(file);
		byte[] fileBytes = new byte[(int) file.length()];
		inputStream.read(fileBytes);
		inputStream.close();

		Filestore filestore = new Filestore();
		filestore.setId(id);
		filestore.setDescription(description);
		filestore.setFileYear(fileYear);
		filestore.setDepartment(department);
		filestore.setFileBlob(fileBytes);

		filestoreRepository.save(filestore);

		return Response.ok(new RespuestaGeneral(200, "El archivo ha subido satisfactoriamente."))
				.build();

	}

}
