/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AnshuL
 */
public class dbUpdateServlet extends HttpServlet {

    Connection con = null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        con = (Connection) session.getAttribute("connection");

        String insert1 = (String) session.getAttribute("insert1");
        String insert2 = (String) session.getAttribute("insert2");
        String insert3 = (String) session.getAttribute("insert3");
        String insert4 = (String) session.getAttribute("insert4");
        String insert5 = (String) session.getAttribute("insert5");
        String insert6 = (String) session.getAttribute("insert6");
        String insert7 = (String) session.getAttribute("insert7");

        String insertbutton = (String) session.getAttribute("insertion");

        String deleteoption = (String) session.getAttribute("deleteoptions");
        String deletevalue = (String) session.getAttribute("deletevalues");
        String deletion = (String) session.getAttribute("deletions");

        String updateoption = (String) session.getAttribute("updateoption");
        String setvalue = (String) session.getAttribute("setvalue");
        String operator = (String) session.getAttribute("operator");
        String getvalue = (String) session.getAttribute("getvalue");
        String updation = (String) session.getAttribute("updations");

        //HTML output....
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");

        out.println("Anshul NoteBook");
        out.println("<link href=" + "\"http://fonts.googleapis.com/css?family=Open+Sans:300,600,700\"" + "rel=" + "\"stylesheet\"" + "/>");
        out.println("<script src=" + "\"js/config.js\"" + "></script>");
        out.println("<script src=" + "\"js/skel.min.js\"" + "></script>");

        out.println("<noscript>");

        //out.println("<link rel=" + "\"stylesheet\"" + "href=" + "\"css/style.css\"" + "/>");
        out.println("</noscript>");

        out.println("<style type = \"text/css\">\n"
                + "body{ font-family: sans-serif;\n"
                + "	  background-color: white; \n"
                + "	}\n"
                + "table{ background-color: lightblue;\n"
                + "		border-collapse: collapse;\n"
                + "		border:1px solid gray; \n"
                + "	}\n"
                + "td { padding: 5px;}\n"
                + "tr:nth-child(odd){\n"
                + "background-color: white;}\n"
                + "</style>");

        out.println("</head>");
        out.println("<body>");

        out.println("<nav id=" + "\"nav\"");
        out.println("<ul class=" + "\"container\"" + ">");
        out.println("<li><a href=\"http://localhost:8090/Assignment_2/index.html\">Home</a></li>\n" +
"                <li><a href=\"http://localhost:8090/Assignment_2/searchbykeyword.html\">Keyword Search</a></li>\n" +
"                <li><a href=\"http://localhost:8090/Assignment_2/conditionsearch.html\">Condition Search</a></li>\n" +
"                <li><a href=\"http://localhost:8090/Assignment_2/insertbook.html\">Insert</a></li>\n" +
"                <li><a href=\"http://localhost:8090/Assignment_2/deletebyselect.html\">Delete</a></li>\n" +
"                <li><a href=\"http://localhost:8090/Assignment_2/updatebyselect.html\">Update</a></li>");
        out.println("</ul>");
        out.println("</nav>");

        // out.println("<div class=\"wrapper wrapper-style1 wrapper-first\">");
        out.println("<article class=\"container\" id=\"top\">");
        //out.println("<div class=\"row\">");

        out.println("<br>");
        //out.println("<div class=\"8u\">");

//main div where every thing present
        out.println("<table border=1 width=100% height=100% align=" + "left" + ">");

//calling jdbc class
//getting values as a object of array
        JDBC x = new JDBC();

        Object[] obj = x.sqlUpdate(con, insert1, insert2, insert3, insert4, insert5, insert6, insert7, insertbutton, deleteoption, deletevalue, deletion, updateoption, setvalue, operator, getvalue, updation);

        String[] array1 = (String[]) obj[0];
        String[] array2 = (String[]) obj[1];
        String[] array3 = (String[]) obj[2];
        String[] array4 = (String[]) obj[3];
        String[] array5 = (String[]) obj[4];
        String[] array6 = (String[]) obj[5];
        String[] array7 = (String[]) obj[6];
        String[] array8 = (String[]) obj[7];
        String[] array9 = (String[]) obj[8];

//values get from jdbc class
        //printing result as a html page
        out.println(updateoption);
        out.println(" " + getvalue);
        out.println(setvalue);
        out.println(" " + operator);

        out.println("<strong>Search Result</strong></br>");

        out.println("<tr>");
        out.println("<td><strong>AuthorId</strong></br>");
        for (String array11 : array1) {
            out.println(array11 + "</br>");
        }
        out.println("</td>");

        out.println("<td><strong>FirstName</strong></br>");
        for (String array21 : array2) {
            out.println(array21 + "</br>");
        }
        out.println("</td>");

        out.println("<td><strong>LastName</strong></br>");
        for (String array31 : array3) {
            out.println(array31 + "</br>");
        }

        out.println("<td><strong>AuthorID</strong></br>");
        for (String array41 : array4) {
            out.println(array41 + "</br>");
        }

        out.println("<td><strong>ISBN</strong></br>");
        for (String array51 : array5) {
            out.println(array51 + "</br>");
        }

        out.println("<td><strong>ISBN</strong></br>");
        for (String array61 : array6) {
            out.println(array61 + "</br>");
        }

        out.println("<td><strong>Title</strong></br>");
        for (String array71 : array7) {
            out.println(array71 + "</br>");
        }

        out.println("<td><strong>EditionNumber</strong></br>");
        for (String array81 : array8) {
            out.println(array81 + "</br>");
        }

        out.println("<td><strong>Copyright</strong></br>");
        for (String array91 : array9) {
            out.println(array91 + "</br>");
        }

        out.println("</td>");

        out.println("</tr>");

        out.println("</table>");

//main div closed            
        /*    out.println("</div>");
         out.println("</div>");*/
        out.println("</article>");

        //out.println(" </div>");
        out.println("</html></body>");

        //sql update function
        out.close();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
