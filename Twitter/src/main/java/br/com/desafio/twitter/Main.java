package br.com.desafio.twitter;

import java.util.List;

import br.com.desafio.twitter.DAO.Tweet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String urlWebService = "http://tweeps.locaweb.com.br/tweeps";
		String usuario = "thiago.cobalt@gmail.com";
		
		List<Tweet> listaTwitter = RecuperaListaTwitter.getObjeto(urlWebService, usuario);
		
		OrdenaListaTwitter.ordenaTweet(listaTwitter);
	}

}
