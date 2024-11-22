package org.rosinenhasser.jakarta.CatController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.rosinenhasser.jakarta.cat.CatEntity;
import org.rosinenhasser.jakarta.cat.CatService;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cats")
public class CatController extends HttpServlet {

    @Inject
    private CatService catService;

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

        // Hier kannst du mit dem empfangenen Objekt arbeiten
        // Beispiel: System.out.println(myObject);

            // Writer zum Schreiben der Antwort holen
            PrintWriter out = response.getWriter();
            // HTML-Ausgabe generieren
            out.println(request);
            }

}