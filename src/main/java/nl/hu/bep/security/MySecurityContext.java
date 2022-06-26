package nl.hu.bep.security;

import nl.hu.bep.domeinmodel.Medewerker;

import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

public class MySecurityContext implements SecurityContext {
    private Medewerker ingelogdeMedewerker;
    private boolean isSecure;

    public MySecurityContext(Medewerker ingelogdeMedewerker, boolean isSecure) {
        this.ingelogdeMedewerker = ingelogdeMedewerker;
        this.isSecure = isSecure;
    }

    @Override
    public Principal getUserPrincipal() {

        return (Principal) ingelogdeMedewerker;
    }

    @Override
    public boolean isUserInRole(String role) {
        return false;
    }

    @Override
    public boolean isSecure() {
        return isSecure;
    }

    @Override
    public String getAuthenticationScheme() {
        return "Token-Based-Auth-Scheme";
    }
}