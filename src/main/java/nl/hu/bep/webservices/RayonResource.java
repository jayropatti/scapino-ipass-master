package nl.hu.bep.webservices;

import nl.hu.bep.domeinmodel.Filiaal;
import nl.hu.bep.domeinmodel.Rayon;

import javax.json.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.StringReader;
import java.util.List;


@Path("filialen")
public class RayonResource {
    private JsonObject filiaalObject(Filiaal filiaal){
        JsonObjectBuilder job = Json.createObjectBuilder();
        if (filiaal == null){
            job.add("result", JsonValue.NULL);
        } else{
            job.add("naam", filiaal.getNaam());
            job.add("filiaalnummer", filiaal.getFiliaalnummer());
            job.add("adres", filiaal.getAdres());
            job.add("postcode", filiaal.getPostcode());
        }
        return job.build();
    }

    private JsonArray alleFilialenJsonArray(List<Filiaal> filialen){
        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (Filiaal filiaal : filialen){
            jab.add(filiaalObject(filiaal));
        }
        return jab.build();
    }

    @GET
    @Path("{filiaalnummer}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getFiliaal(@PathParam("filiaalnummer") String cd){
        Filiaal filiaal = Rayon.getRayon().getFiliaalCode(cd);
        return filiaalObject(filiaal).toString();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getFilialen(){
        List<Filiaal> filialen = Rayon.getRayon().getFilialen();
        return alleFilialenJsonArray(filialen).toString();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String voegFiliaalToe(String jsonBody) {
        StringReader stringReader = new StringReader(jsonBody);
        JsonReader jsonReader = Json.createReader(stringReader);

        JsonObject jsonObject = jsonReader.readObject();

        String naam = jsonObject.getString("naam");
        String filiaalnummer = jsonObject.getString("filiaalnummer");
        String adres = jsonObject.getString("adres");
        String postcode = jsonObject.getString("postcode");

        Filiaal newFiliaal = new Filiaal(naam, filiaalnummer, adres, postcode);

        JsonObjectBuilder job = Json.createObjectBuilder();

        if (Rayon.getRayon().addFiliaal(newFiliaal)) {
            job.add("result", "success");
        } else {
            job.add("result", "failed");
        }

        return job.build().toString();
    }


}
