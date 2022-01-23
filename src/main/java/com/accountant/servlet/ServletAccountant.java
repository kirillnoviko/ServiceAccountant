package com.accountant.servlet;

import com.accountant.domain.Accountant;
import com.accountant.repository.RepositoryAccountant;
import com.accountant.repository.RepositoryAccountantImpl;
import com.accountant.util.ParserRequest;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet(urlPatterns = { "/accountant" })
public class ServletAccountant extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ServletAccountant() {
        super();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RepositoryAccountant repositoryAccountant =new RepositoryAccountantImpl() ;
        List<Accountant> accountant=repositoryAccountant.findAll();


        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(200);
        out.print(accountant);
        out.flush();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Gson g = new Gson();
        Accountant accountant = g.fromJson(request.getReader(), Accountant.class);
        RepositoryAccountant repositoryAccountant =new RepositoryAccountantImpl() ;
        repositoryAccountant.save(accountant);


        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(200);
        out.print(accountant);
        out.flush();

    }


    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Gson g = new Gson();
        Accountant accountant = g.fromJson(request.getReader(), Accountant.class);
        RepositoryAccountant repositoryAccountant =new RepositoryAccountantImpl() ;
        repositoryAccountant.update(accountant);


        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(200);
        out.print(accountant);
        out.flush();
    }
}
