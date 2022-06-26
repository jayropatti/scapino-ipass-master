package nl.hu.bep.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import nl.hu.bep.domeinmodel.Medewerker;
import nl.hu.bep.security.AuthenticationResource;
import nl.hu.bep.security.MySecurityContext;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthorizationFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        boolean secure = containerRequestContext.getSecurityContext().isSecure();
        MySecurityContext mySecurityContext = new MySecurityContext(null,secure);
        System.out.println("werkt");

        String header = containerRequestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        if (header != null && header.startsWith("Bearer ")){
            String token = header.split(" ")[1].trim();

            try {
                JwtParser parser = Jwts.parser().setSigningKey(AuthenticationResource.key);
                Claims claim = parser.parseClaimsJws(token).getBody();
                String medewerkerNaam = claim.getSubject();
                System.out.println("De medewerker naam komt overeen");

                for (Medewerker medewerker : Medewerker.getAlleMedewerkers()){
                    if (Medewerker.getNaam().equals(medewerkerNaam)){
                        mySecurityContext = new MySecurityContext(medewerker, secure);
                        break;
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("JWT invalid for request");
            }
        }
        containerRequestContext.setSecurityContext((SecurityContext) mySecurityContext);
    }
}