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
    private Gson gson = new Gson();

    public ServletAccountantByID() {
        super();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            Long id= ParserRequest.ParseRequestLong(request);
            RepositoryAccountant repositoryAccountant =new RepositoryAccountantImpl() ;
            Accountant accountant=repositoryAccountant.findOne(id);
            String employeeJsonString = this.gson.toJson(accountant);

            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(employeeJsonString);
            out.flush();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Accountant accountant= new Accountant();
        accountant.setTask("post");
        accountant.setId(12l);

        String employeeJsonString = this.gson.toJson(accountant);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(employeeJsonString);
        out.flush();
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Accountant accountant= new Accountant();
        accountant.setTask("delete");
        accountant.setId(122l);

        String employeeJsonString = this.gson.toJson(accountant);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(employeeJsonString);
        out.flush();
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Accountant accountant= new Accountant();
        accountant.setTask("22312");
        accountant.setId(121232l);

        String employeeJsonString = this.gson.toJson(accountant);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(employeeJsonString);
        out.flush();
    }
}


