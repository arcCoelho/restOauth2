package br.com.caixa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("index")
public class Teste extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter	out	=	res.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Primeira	Servletasdsadasdasd</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Oi	mundo	Servletasdas!</h1>");
		out.println("</body>");
		out.println("</html>");
	}
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//
//		PrintWriter	out	=	res.getWriter();
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>Primeira	Servlet</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h1>Oi	mundo	Servlet!</h1>");
//		out.println("</body>");
//		out.println("</html>");
//
//		
//		
//		super.service(req, res);
//	}
//	
	
}
