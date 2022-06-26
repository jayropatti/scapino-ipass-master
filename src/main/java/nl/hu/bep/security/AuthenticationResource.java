package nl.hu.bep.security;


import nl.hu.bep.domeinmodel.Medewerker;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.Key;
import java.util.AbstractMap;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

class AuthenticationRequest{
    public String gebruikersnaam;
    public String wachtwoord;
}

@Path("/login")
public class AuthenticationResource {
    public static Key key =  MacProvider.generateKey();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginWebservice(AuthenticationRequest loginData){
        for (Medewerker medewerker : Medewerker.getAlleMedewerkers()){
            if (medewerker.getNaam().equals(loginData.gebruikersnaam) && medewerker.getWachtwoord().equals(loginData.wachtwoord)){
                String jwt = Jwts.builder()
                        .setSubject(loginData.gebruikersnaam)
                        .claim("role", medewerker.getNaam())
                        .signWith(SignatureAlgorithm.HS512, key)
                        .compact();

            }
        }
        return Response.ok(406).entity(new AbstractMap.SimpleEntry<>("Error", "Medewerker bestaat niet")).build();
    }

}
