package com.accountant.servlet;


import com.accountant.repository.RepositoryAccountant;
import com.accountant.repository.RepositoryAccountantImpl;
import com.accountant.util.ParserRequest;
import com.google.gson.Gson;
import com.accountant.domain.Accountant;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



@WebServlet(urlPatterns = { "/accountant/*" })
public class ServletAccountantByID extends HttpServlet {


    private static final long serialVersionUID = 1L;


    public ServletAccountantByID() {
        super();
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            Long id= ParserRequest.ParseRequestLong(request);
            RepositoryAccountant repositoryAccountant =new RepositoryAccountantImpl() ;
            Accountant accountant=repositoryAccountant.findOne(id);


            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(accountant);
            out.flush();

    }


    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id= ParserRequest.ParseRequestLong(request);
        RepositoryAccountant repositoryAccountant =new RepositoryAccountantImpl() ;
        repositoryAccountant.delete(id);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(201);
        out.flush();
    }


}


