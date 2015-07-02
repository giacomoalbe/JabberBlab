package servlet; 

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.util.ByteArrayDataSource;
 
public class SendEmail extends HttpServlet{
 @Override
 public void doGet(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {


 String result;
 // Recipient's email ID needs to be mentioned.
 String to = "jabberblabcinema@gmail.com";

 // Sender's email ID needs to be mentioned
 String from = request.getParameter("contactus_email");

 // Assuming you are sending email from localhost
 String host = "localhost";

 // Get system properties object
 Properties properties = System.getProperties();

 // Setup mail server
 properties.setProperty("mail.smtp.host", host);

 // Get the default Session object.
 Session mailSession = Session.getDefaultInstance(properties);

 try{
 // Create a default MimeMessage object.
 MimeMessage message = new MimeMessage(mailSession);
 // Set From: header field of the header.
 message.setFrom(new InternetAddress(from));
 // Set To: header field of the header.
 message.addRecipient(Message.RecipientType.TO,
 new InternetAddress(to));
 // Set Subject: header field
 message.setSubject("Informazioni da - " + request.getParameter("contactus_nome"));
 // Now set the actual message
 message.setText(request.getParameter("contactus_mess"));
 // Send message
 Transport.send(message);
 result = "Sent message successfully....";
 }catch (MessagingException mex) {
 mex.printStackTrace();
 result = "Error: unable to send message....";
 }
 response.setContentType("text/html");
 PrintWriter out = response.getWriter();
 out.println("<html>\n" +
"<head>\n" +
"<title>Send Email using JSP</title>\n" +
"</head>\n" +
"<body>\n" +
"<center>\n" +
"<h1>Send Email using JSP</h1>\n" +
"</center>\n" +
"<p align=\"center\">\n" +
"<% \n" +
" out.println(\" Result: \" "+ result +" \"\\n\");\n" +
"%>\n" + 
"</p>\n" +
"</body>\n" +
"</html>");

        
}}
