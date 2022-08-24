
package fr.m2i.javaapirest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

@Path("/personnes")
public class AnnuaireResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Personne> list(Personne personne, @Context HttpServletRequest request) {
        AnnuaireDAO dao = new AnnuaireDAO();
        return dao.listAll();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Personne personne, @Context HttpServletRequest request) throws URISyntaxException{
        AnnuaireDAO dao = new AnnuaireDAO();
        int newPersonneId = dao.add(personne);
        URI uri = new URI("/java-api-rest/api/personnes/" + newPersonneId);
        return Response.created(uri).build();
    }
    
    @GET
    @Path("{id}")
    public Response get(@PathParam("id") int id){
       AnnuaireDAO dao = new AnnuaireDAO();
       Personne personne = dao.get(id);
       if (personne != null) {
           return Response.ok(personne, MediaType.APPLICATION_JSON).build();
       } else {
           return Response.status(Response.Status.NOT_FOUND).build();
       }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") int id, Personne personne){
        personne.setId(id);
        AnnuaireDAO dao = new AnnuaireDAO();
        if (dao.update(personne)) {
            return Response.ok().build();
        } else {
            return Response.notModified().build();
        }
    }
    
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id){
         AnnuaireDAO dao = new AnnuaireDAO();
        if (dao.delete(id)){
            return Response.ok().build();
        } else {
            return Response.notModified().build();
        }
    }
    
}
   
   
   
   
    
  
    

