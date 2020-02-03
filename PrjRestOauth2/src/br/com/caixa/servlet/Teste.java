package br.com.caixa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import br.com.caixa.pojo.Jogo;
import br.com.caixa.pojo.Login;

@WebServlet("index")
public class Teste extends HttpServlet {

	private final String URL_SERVICE = "http://localhost:8181/PrjRestOauth2/ws/game";
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter	out	=	res.getWriter();
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Primeira	Servletasdsadasdasd</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Oi	mundo	Servletasdas!</h1>");
		
		
		
		out.println("<h2>consumo de rest com java</h2>");
		
		//comsumo de GET simples
		Client	cliente	=	ClientBuilder.newClient();
		Jogo resposta = cliente.target("http://localhost:8181/PrjRestOauth2/ws/game").request().buildGet().invoke(Jogo.class);
		out.println("<p>Get Simples");
			out.println("<br /><spam style='margin-left: 10px;'>nome do jogo: "+resposta.getNome()+"</spam>");
		out.println("</p>");
		
		
		//comsumo de POST simples
		Client	clientePost	=	ClientBuilder.newClient();
		String respostaPost = cliente.target("http://localhost:8181/PrjRestOauth2/ws/game/usuToken")
				.request()
				.buildPost( Entity.json( new Login("AllanCoelho", "...teste...") ) )
				.invoke(String.class);
		out.println("<p>POST Simples");
			out.println("<br /><spam style='margin-left: 10px;'>Token: "+ respostaPost +"</spam>");
			out.println("<br /><spam style='margin-left: 10px;'>pode ser assim tb: "+ CadastrarPessoa( new Login("AllanCoelho", "...teste...") ) +"</spam>");
		out.println("</p>");
		
		
		out.println("</body>");
		out.println("</html>");
	}
	
	public String CadastrarPessoa(Login login){
		WebTarget webTarget;
		Client client = ClientBuilder.newClient();
		
		webTarget = client.target(URL_SERVICE).path("usuToken"); 
		Invocation.Builder invocationBuilder =  webTarget.request("application/json;charset=UTF-8"); 
		Response response = invocationBuilder.post(Entity.entity(login, "application/json;charset=UTF-8")); 
		return response.readEntity(String.class); 
	}
	
	// http://www.ciceroednilson.com.br/java-criando-um-client-rest-usando-jersey/
	
}
