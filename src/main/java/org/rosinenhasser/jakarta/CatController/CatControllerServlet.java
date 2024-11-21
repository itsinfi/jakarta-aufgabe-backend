package org.rosinenhasser.jakarta.CatController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.rosinenhasser.jakarta.cat.CatEntity;
import org.rosinenhasser.jakarta.cat.CatService;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getCats")
public class CatControllerServlet extends HttpServlet {

    @Inject
    private CatService catService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            System.out.println("Test");
            System.out.println(request);
            System.out.println(response);
            // get cats
            List<CatEntity> catEntities = new ArrayList<CatEntity>();
            catEntities = catService.readAll();

            // Setzen des Inhalts-Typs der Antwort (z.B. HTML)
            response.setContentType("text/html");
            // Writer zum Schreiben der Antwort holen
            PrintWriter out = response.getWriter();
            // HTML-Ausgabe generieren
            out.println(catEntities.toString());


        }

}