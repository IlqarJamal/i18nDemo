/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author user
 */
public class LanguageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String data = request.getParameter("data");
        Locale locale = null;
        ResourceBundle resourceBundle = null;
        Map<String , String> map = new HashMap<String , String>();
        Gson gson = new GsonBuilder().create();
        
        try {
            if (action.equals("changeLang")) {
                if (data.equals("en")) {
                    locale = new Locale("en", "EN");
                    resourceBundle = ResourceBundle.getBundle("i18n.Bundle", locale);
                    System.out.println(resourceBundle.getString("NAME"));
                    System.out.println(resourceBundle.getString("LAST_NAME"));
                    System.out.println(resourceBundle.getString("LANGUAGE"));
                } else if (data.equals("ru")) {
                    locale = new Locale("ru", "RU");
                    resourceBundle = ResourceBundle.getBundle("i18n.Bundle", locale);
                    System.out.println(resourceBundle.getString("NAME"));
                    System.out.println(resourceBundle.getString("LAST_NAME"));
                    System.out.println(resourceBundle.getString("LANGUAGE"));
                } else if (data.equals("de")) {
                    locale = new Locale("de", "DE");
                    resourceBundle = ResourceBundle.getBundle("i18n.Bundle", locale);
                    System.out.println(resourceBundle.getString("NAME"));
                    System.out.println(resourceBundle.getString("LAST_NAME"));
                    System.out.println(resourceBundle.getString("LANGUAGE"));
                }
            }
            map.put("name", resourceBundle.getString("NAME"));
            map.put("lastname", resourceBundle.getString("LAST_NAME"));
            map.put("language", resourceBundle.getString("LANGUAGE"));
           
            response.getWriter().write(gson.toJson(map));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
