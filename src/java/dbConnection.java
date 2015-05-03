/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AnshuL
 */
public class dbConnection extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            Connection con = null;

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://cs2.bradley.edu:3306/books_ashrivastava2", "username", "password");

            //String n=request.getParameter("userName");  
            out.print("Welcome  " + con);

            HttpSession session = request.getSession();
            session.setAttribute("connection", con);

            String keyword = request.getParameter("word");

            String authors1 = request.getParameter("author1");
            String authors2 = request.getParameter("author2");

            session.setAttribute("FirstName", authors1);
            session.setAttribute("LastName", authors2);
            session.setAttribute("keyword", keyword);

            String book1 = request.getParameter("book1");
            String book2 = request.getParameter("book2");
            String book3 = request.getParameter("book3");
            String book4 = request.getParameter("book4");

            session.setAttribute("ISBN", book1);
            session.setAttribute("title", book2);
            session.setAttribute("EditionNumber", book3);
            session.setAttribute("Copyright", book4);

            String tablename = request.getParameter("table");
            String columnname = request.getParameter("column");
            session.setAttribute("tablename", tablename);
            session.setAttribute("columnname", columnname);

            String operator = request.getParameter("operator");
            session.setAttribute("operator", operator);

            String operatorvalue = request.getParameter("operatorvalue");
            session.setAttribute("operatorvalue", operatorvalue);

            String deleteoptions = request.getParameter("deleteoption");
            String deletevalues = request.getParameter("deletevalue");
            String deletions = request.getParameter("deletion");
            session.setAttribute("deleteoptions", deleteoptions);
            session.setAttribute("deletevalues", deletevalues);
            session.setAttribute("deletions", deletions);

            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/dbQuery");

            requestDispatcher.forward(request, response);

            //   out.print("<a href='dbQuery'>visit</a>");  
            out.println("</html></body>");
            out.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            //connection code
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://cs2.bradley.edu:3306/books_ashrivastava2", "username", "password");

            //connection session post method
            HttpSession session = request.getSession();
            session.setAttribute("connection", con);

// do login code here
            //insert parameters and set into sessions..
            String insertbutton = request.getParameter("insertion");
            String insert1 = request.getParameter("insert1");
            String insert2 = request.getParameter("insert2");
            String insert3 = request.getParameter("insert3");
            String insert4 = request.getParameter("insert4");
            String insert5 = request.getParameter("insert5");
            String insert6 = request.getParameter("insert6");
            String insert7 = request.getParameter("insert7");
            session.setAttribute("insert1", insert1);
            session.setAttribute("insert2", insert2);
            session.setAttribute("insert3", insert3);
            session.setAttribute("insert4", insert4);
            session.setAttribute("insert5", insert5);
            session.setAttribute("insert6", insert6);
            session.setAttribute("insert7", insert7);

            String deleteoptions = request.getParameter("deleteoption");
            String deletevalues = request.getParameter("deletevalue");
            String deletions = request.getParameter("deletion");
            session.setAttribute("deleteoptions", deleteoptions);
            session.setAttribute("deletevalues", deletevalues);
            session.setAttribute("deletions", deletions);

            
             String updations = request.getParameter("updation");
            String updateoptions = request.getParameter("updateoption");
            String setvalues = request.getParameter("setvalue");
            String operatorz = request.getParameter("operator");
            String getvalues = request.getParameter("getvalue");
            session.setAttribute("updateoption", updateoptions);
            session.setAttribute("setvalue", setvalues);
            session.setAttribute("operator", operatorz);
            session.setAttribute("getvalue", getvalues);
            session.setAttribute("updations", updations);

            //insertion is submit button for chechk in JDBC class which one is ISNERT.
            session.setAttribute("insertion", insertbutton);

            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/dbUpdateServlet");
            requestDispatcher.forward(request, response);

            //Deletion sessioin set and Parameter get CODE
            //It sends data to "dbUpdateServlet" servlet for further processing..
        } catch (Exception e) {

            System.out.println("Post Method Error");
        }

    }

}
