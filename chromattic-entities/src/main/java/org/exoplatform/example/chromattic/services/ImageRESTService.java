package org.exoplatform.example.chromattic.services;

import java.io.InputStream;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.chromattic.api.ChromatticSession;
import org.exoplatform.example.chromattic.entities.Photo;
import org.exoplatform.services.rest.resource.ResourceContainer;
import org.exoplatform.services.wcm.utils.WCMCoreUtils;

@Path("/displayImage/")
public class ImageRESTService implements ResourceContainer {
	@Path("/{nodePath:.*}/")
	@GET
	public Response getImage(@PathParam("nodePath") String nodePath,
			@HeaderParam("If-Modified-Since") String ifModifiedSince)
			throws Exception {
		
		MOBService mobService = WCMCoreUtils.getService(MOBService.class);
		ChromatticSession session = mobService.getSession();
		Photo photo = session.findByPath(Photo.class, nodePath);
		
		InputStream inputStream = photo.getContent().getData();
		
		return Response.ok(inputStream, "image").build();
		
	}
}
