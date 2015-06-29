package com.malsolo.javaee7.descanso.web;

import java.net.URI;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author jbbarquero
 */
@Path("/occurrence")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class OccurrenceResource {

    //TODO:
    //0. Configure and deploy applicaion
    //1. Media types (JSON, XML...)
    //2. OccurrenceRepository injected
    //3. Database (embedded?)
    @Context
    private UriInfo uriInfo;

    private final OccurrenceRepository repo = new OccurrenceRepository();

    @GET
    public Response getAllOccurrences() {
        return Response.ok(new Occurrences(repo.findAll())).build();
    }

    @GET
    @Path("{id}")
    public Response getOccurrence(@PathParam("id") Long id) {
        Occurrence occurrence = repo.find(id);
        if (occurrence == null) {
            throw new NotFoundException();
        }
        return Response.ok(occurrence).build();
    }

    @POST
    public Response createOccurrence(Occurrence occurrence) {
        if (occurrence == null) {
            throw new BadRequestException();
        }

        repo.persist(occurrence);
        URI occurrenceUri = uriInfo.getAbsolutePathBuilder().path(occurrence.getId().toString()).build();
        return Response.created(occurrenceUri).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteOccurrence(@PathParam("id") Long id) {
        Occurrence occurrence = repo.remove(id);
        if (occurrence == null) {
            throw new NotFoundException();
        }
        return Response.noContent().build();
    }
}
