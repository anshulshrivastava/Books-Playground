/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AnshuL
 */
public class dbQuery extends HttpServlet {

    ResultSet rs = null;
    PreparedStatement pst = null;
    Connection con = null;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {

            //http session connection persistence
            HttpSession session = request.getSession(false);
            con = (Connection) session.getAttribute("connection");

            //getting parameters from html
            //String search = (String) session.getAttribute("keyword1");
            //String condition2 = (String) session.getAttribute("conditions");
            
            String firstname = (String) session.getAttribute("FirstName");
            String lastname = (String) session.getAttribute("LastName");
           
            String book1 = (String) session.getAttribute("ISBN");
            String book2 = (String) session.getAttribute("title");
            String book3 = (String) session.getAttribute("EditionNumber");
            String book4 = (String) session.getAttribute("Copyright");

            String keyword = (String) session.getAttribute("keyword");

            String tablename = (String) session.getAttribute("tablename");
            String columnname = (String) session.getAttribute("columnname");
            
            String operator = (String) session.getAttribute("operator");
            String operatorvalue = (String) session.getAttribute("operatorvalue");

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
            out.println(" <li><a href=\"http://localhost:8090/Assignment_2/index.html\">Home</a></li>\n" +
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
            JDBC j = new JDBC();

            Object[] obj = j.sqlQuery(con, keyword, firstname, lastname, book1, book2, book3, book4, tablename, columnname, operator, operatorvalue);

            
            
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
            
            out.println("<strong>Search Result</strong></br>");

            out.println("<tr>");
            out.println("<td><strong>AuthorId</strong></br>");
            for (int x = 0; x < array1.length; x++) {
                out.println(array1[x] + "</br>");
            }
            out.println("</td>");

            out.println("<td><strong>FirstName</strong></br>");
            for (int x = 0; x < array2.length; x++) {
                out.println(array2[x] + "</br>");
            }
            out.println("</td>");

            out.println("<td><strong>LastName</strong></br>");
            for (int x = 0; x < array3.length; x++) {
                out.println(array3[x] + "</br>");
            }

            out.println("<td><strong>AuthorID</strong></br>");
            for (int x = 0; x < array4.length; x++) {
                out.println(array4[x] + "</br>");
            }

            out.println("<td><strong>ISBN</strong></br>");
            for (int x = 0; x < array5.length; x++) {
                out.println(array5[x] + "</br>");
            }

            out.println("<td><strong>ISBN</strong></br>");
            for (int x = 0; x < array6.length; x++) {
                out.println(array6[x] + "</br>");
            }

            out.println("<td><strong>Title</strong></br>");
            for (int x = 0; x < array7.length; x++) {
                out.println(array7[x] + "</br>");
            }

            out.println("<td><strong>EditionNumber</strong></br>");
            for (int x = 0; x < array8.length; x++) {
                out.println(array8[x] + "</br>");
            }

            out.println("<td><strong>Copyright</strong></br>");
            for (int x = 0; x < array9.length; x++) {
                out.println(array9[x] + "</br>");
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
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
