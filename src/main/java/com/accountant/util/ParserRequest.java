package com.accountant.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class ParserRequest {

    public static Long ParseRequestLong(HttpServletRequest request) throws ServletException {

        String[] pathInfo = request.getPathInfo().split("/");
        if (pathInfo.length != 2) {
            throw new ServletException("неправильный запрос");
        }
        Long id = Long.parseLong(pathInfo[1]);

        return Long.parseLong(pathInfo[1]);
    }
}

