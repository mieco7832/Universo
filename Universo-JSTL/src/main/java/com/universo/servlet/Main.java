/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.universo.servlet;

import com.google.gson.Gson;
import com.universo.domain.Domain;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Main", urlPatterns = {"/main"})
public class Main extends HttpServlet {

    Domain domain;
    RequestDispatcher rd;
    String url, prefix = "view/", sufix = ".jsp";

    public Main() {
        super();
        domain = new Domain();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            url = request.getParameter("action");
            switch (url) {
                case "universo":
                    request.setAttribute("list", domain.getGalaxias());
                    rd = request.getRequestDispatcher(prefix + "universo" + sufix);
                    rd.forward(request, response);
                    break;
                case "go":
                    request.setAttribute("nombre_galaxia",
                            domain.getGalaxia(Integer.parseInt(request.getParameter("galaxia"))).getNombre());
                    request.setAttribute("list",
                            domain.getPlanetas(Integer.parseInt(request.getParameter("galaxia"))));
                    request.setAttribute("id",
                            domain.getGalaxia(Integer.parseInt(request.getParameter("galaxia"))).getGalaxia());
                    rd = request.getRequestDispatcher(prefix + "galaxia" + sufix);
                    rd.forward(request, response);
                    break;
            }
        } catch (Exception e) {
            rd = request.getRequestDispatcher(prefix + "universo" + sufix);
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        url = request.getParameter("action");
        switch (url) {
            case "newGalaxia":
                domain.createGalaxia(
                        request.getParameter("nombre"),
                        request.getParameter("descripcion"),
                        request.getParameter("url"));
                break;
            case "update":
                response.getWriter().write(new Gson().toJson(domain.getGalaxia(Integer.parseInt(request.getParameter("id")))));
                break;
            case "updateGalaxia":
                domain.updateGalaxia(
                        request.getParameter("id"),
                        request.getParameter("nombre"),
                        request.getParameter("descripcion"),
                        request.getParameter("url"));
                break;
            case "removeGalaxia":
                domain.removeGalaxia(Integer.parseInt(request.getParameter("id")));
                break;
            case "newPlaneta":
                try {
                domain.createPlaneta(
                        request.getParameter("nombre"),
                        request.getParameter("masa"),
                        request.getParameter("numero"),
                        request.getParameter("descripcion"),
                        request.getParameter("url"),
                        request.getParameter("id"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
            case "updateP":
                response.getWriter().write(new Gson().toJson(domain.getPlaneta(Integer.parseInt(request.getParameter("id")))));
                break;
            case "updatePlaneta":
                domain.updatePlaneta(
                        request.getParameter("nombre"),
                        request.getParameter("masa"),
                        request.getParameter("numero"),
                        request.getParameter("descripcion"),
                        request.getParameter("url"),
                        request.getParameter("id"),
                        request.getParameter("galaxia"));
                break;
            case "removePlaneta":
                domain.removePlaneta(Integer.parseInt(request.getParameter("id")));
                break;

        }
    }

}
