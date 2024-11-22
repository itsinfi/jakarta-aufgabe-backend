package org.rosinenhasser.jakarta.cat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("cats/")
public class CatController extends HttpServlet {

    @Inject
    private CatService catService; 

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            System.out.println("Test");
            System.out.println(request);
            System.out.println(response);
            // get cats
            List<CatEntity> catEntities = catService.readAll();

            // Setzen des Inhalts-Typs der Antwort (z.B. HTML)
            response.setContentType("application/json");
            // Writer zum Schreiben der Antwort holen
            PrintWriter out = response.getWriter();
            // JSON-Ausgabe generieren
            out.println(catEntities);
        }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            // Setzen des Inhalts-Typs der Antwort (z.B. HTML)
            response.setContentType("application/json");

            // JSON-Body der Anfrage lesen
            System.out.println(request);
            BufferedReader reader = request.getReader();
            CatEntity cat = objectMapper.readValue(reader, CatEntity.class);
            // CatEntity cat = objectMapper.readValue(reader, CatEntity.class);
            catService.create(cat);

            // Writer zum Schreiben der Antwort holen
            PrintWriter out = response.getWriter();
            // HTML-Ausgabe generieren
            out.println(request);
            }

        @Override
        protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try {
                    long id = Long.parseLong(request.getParameter("id"));
                    catService.delete(id);
                    response.getWriter().write("Deleted cat with id: " + id);
                } catch (Exception e) {
                    response.getWriter().write("Error deleting cat:" + e);
                }
            }

}