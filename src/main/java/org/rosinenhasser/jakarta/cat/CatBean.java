package org.rosinenhasser.jakarta.cat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Named("catManager")
@SessionScoped
public class CatBean implements Serializable {
    private static final String API_URL = "http://localhost:8080/jakarta-aufgabe-backend/rest/cats/";

    private List<CatEntity> allCats;
    private CatEntity specificCatDetails;
    private CatEntity newCat = new CatEntity();
    private CatEntity updateCat = new CatEntity();
    private int specificCatId;
    private int updateCatId;
    private int deleteCatId;

    public List<CatEntity> getAllCats() {
    Client client = ClientBuilder.newClient();
    String response = client.target(API_URL)
                            .request(MediaType.APPLICATION_JSON)
                            .get(String.class);
    Jsonb jsonb = JsonbBuilder.create();
    allCats = jsonb.fromJson(response, new ArrayList<CatEntity>() {}.getClass().getGenericSuperclass());
    return allCats;
}

    public void getCatDetails() {
        Client client = ClientBuilder.newClient();
        specificCatDetails = client.target(API_URL + "details?id=" + specificCatId)
                .request(MediaType.APPLICATION_JSON).get(CatEntity.class);
    }

    public void createCat() {
        Client client = ClientBuilder.newClient();
        Response response = client.target(API_URL).request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(newCat, MediaType.APPLICATION_JSON));
        if (response.getStatus() == 200) {
            newCat = new CatEntity();
        }
    }

    public void updateCat() {
        Client client = ClientBuilder.newClient();
        client.target(API_URL + "?id=" + updateCatId).request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(updateCat, MediaType.APPLICATION_JSON));
    }

    public void deleteCat() {
        Client client = ClientBuilder.newClient();
        client.target(API_URL + "?id=" + deleteCatId).request().delete();
    }

    public String catToString(CatEntity cat) {
        if (cat == null) {
            return "Invalid cat data";
        }
        return cat.getId() + ": " + cat.getName() + " (" + cat.getSpecies() + ", " 
               + cat.getAge() + " years old, " + (cat.getIsVegan() ? "vegan" : "not vegan") + ")";
    }
    
}
