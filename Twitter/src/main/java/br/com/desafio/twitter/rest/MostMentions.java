package br.com.desafio.twitter.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.desafio.twitter.OrdenaListaTwitter;
import br.com.desafio.twitter.RecuperaListaTwitter;
import br.com.desafio.twitter.DAO.Tweet;

public class MostMentions{
	@Path("/most_mentions")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static Response getMostMentions(){
		String urlWebService = "http://tweeps.locaweb.com.br/tweeps";
		String usuario = "thiago.cobalt@gmail.com";
		
		//recupera a lista de tweets
		List<Tweet> listaTwitter = RecuperaListaTwitter.getObjeto(urlWebService, usuario);
		GenericEntity <List<Tweet>> ge = new GenericEntity <List<Tweet>>(listaTwitter) {};
		//ordena a lista de tweets
		OrdenaListaTwitter.ordenaTweet(listaTwitter);
		
		
		return Response.status(Response.Status.OK).entity(ge).build();
	}
}
