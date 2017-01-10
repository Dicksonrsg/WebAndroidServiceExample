
package service;

import dao.ContatoDAO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Contato;

@Path("/contato")
public class ContatoService {
 
    private final ContatoDAO cdao = new ContatoDAO();
    
    @GET
    @Path("/buscar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Contato> buscarTodos(){
        return cdao.findAll();
    }
    
    @GET
    @Path("/buscar/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Contato buscarId(@PathParam("id") int id){
        return cdao.findByPrimaryKey(id);
    }   
    
    @POST
    @Path("/cadastrar")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response cadastrar(Contato contato){
        try{
            cdao.create(contato);
            return Response.status(200).entity("Contato cadastrado").build();
        }catch(Exception e){
            System.out.println("Erro: " + e.toString());
        }
        return Response.status(500).entity("flha no cadastro").build();
    }
}

/* CRUD --> SERVICE
    Create -> Post
    Read -> GET
    Update -> PUT
    Delete -> DELETE
*/