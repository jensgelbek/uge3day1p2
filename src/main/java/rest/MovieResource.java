
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.MovieDTO;
import facades.MovieFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author PC
 */
@Path("api")
public class MovieResource {
 private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
       
    private static final MovieFacade FACADE =  MovieFacade.getMovieFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MovieResource
     */
    public MovieResource() {
    }
    
@Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllJson() {
      
        List<MovieDTO> eld=FACADE.getAll();
        return new Gson().toJson(eld);                  
    }   
    
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getbyIdJson(@PathParam("id") int id) {
        MovieDTO el = FACADE.getById(id);
        return new Gson().toJson(el);
    }
    
    @Path("name/{title}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getbyIdJson(@PathParam("title") String title) {
        MovieDTO el = FACADE.getByName(title);
        return new Gson().toJson(el);
    }
    
@Path("/populate")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void populatedroplet() {
        FACADE.populate();
    }
   
}
