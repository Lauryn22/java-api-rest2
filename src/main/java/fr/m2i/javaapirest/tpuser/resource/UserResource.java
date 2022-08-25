
package fr.m2i.javaapirest.tpuser.resource;

import fr.m2i.javaapirest.tpuser.dao.UserDAO;
import fr.m2i.javaapirest.tpuser.model.User;
import fr.m2i.javaapirest.tpuser.util.SessionHelper;

import java.util.List;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/users")
public class UserResource {
    
        private UserDAO userDAO;
        public UserResource(){
            
            userDAO = new UserDAO();
        }
            
    // URI : /
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        System.out.println("Endpoint : getUsers");
               
        return userDAO.findAll();
    }
    
    // URI : /POST/users
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(User user) {
          userDAO.create(user);
          
        if (userDAO.create(user) == false) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("An error occurred").build();
        } else {
            return Response.status(Response.Status.CREATED)
                    .entity(" User successfully created").build();
        }
        
    }
    
   
}
