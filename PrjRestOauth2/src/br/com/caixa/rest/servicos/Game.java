package br.com.caixa.rest.servicos;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import br.com.caixa.pojo.Jogo;
import br.com.caixa.pojo.Login;

@Path("/game")
public class Game {

	private List<Jogo> geraLista(){
		List<Jogo> lista = new ArrayList<Jogo>();
		lista.add(new Jogo("Chrono Trigger", "RPG"));
		lista.add(new Jogo("the witcher 3", "Action RPG"));
		lista.add(new Jogo("Star Craft 2", "RTS"));
		lista.add(new Jogo("Fire Emblem Tree Houses", "Strategy"));
		
		return lista;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Jogo retUmJogo(){
		Jogo j = new Jogo("Chrono Trigger", "RPG");		
		return j;
	}
	
	@GET
	@Path("/jogos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Jogo> listaJogos(){
		List<Jogo> lista = geraLista();
		
		return lista;
	}
	
	@POST
	@Path("/usuToken")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public String listaTeste(Login login){
		return login.getSenha()+"_"+login.getUsuario()+"_"+login.getSenha();
	}

	public static void main(String[] args) {
		Client	cliente	=	ClientBuilder.newClient();
		Jogo resposta = cliente.target("http://localhost:8181/PrjRestOauth2/ws/game").request().buildGet().invoke(Jogo.class);
		System.out.println("Pagamento	criado,	id:	"	+	resposta.getNome());
	}
	
}
