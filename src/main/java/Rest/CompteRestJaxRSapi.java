package Rest;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import Entities.Compte;
import Repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.logging.Logger;

@Component
@Path("/banque")
public class CompteRestJaxRSapi {
    private static final Logger logger = Logger.getLogger(CompteRestJaxRSapi.class.getName());
    @Autowired
    private CompteRepository compteRepository;

    public CompteRestJaxRSapi() {
    }

    @Path("/compte")
    @GET
    @Produces({"application/xml", "application/json"})
    public List<Compte> listComptes() {
        logger.info("listComptes called");
        return this.compteRepository.findAll();
    }

    @Path("/compte")
    @POST
    @Consumes({"application/json", "application/xml"})
    @Produces({"application/json", "application/xml"})
    public Compte save(Compte c) {
        logger.info("save called with: " + c);
        return (Compte)this.compteRepository.save(c);
    }

    @Path("/compte/{id}")
    @PUT
    @Consumes({"application/json", "application/xml"})
    @Produces({"application/json", "application/xml"})
    public Compte update(@PathParam("id") Long id, Compte compte) {
        logger.info("update called with id: " + id + " and compte: " + compte);
        Compte existingcompte = (Compte)this.compteRepository.findById(id).orElse((Object)null);
        if (existingcompte != null) {
            existingcompte.setSolde(compte.getSolde());
            existingcompte.setDateCreation(compte.getDateCreation());
            existingcompte.setTypeCompte(compte.getTypeCompte());
            return (Compte)this.compteRepository.save(existingcompte);
        } else {
            return null;
        }
    }

    @Path("/compte/{id}")
    @DELETE
    @Produces({"application/json", "application/xml"})
    public void delete(@PathParam("id") Long id) {
        logger.info("delete called with id: " + id);
        this.compteRepository.deleteById(id);
    }
}

