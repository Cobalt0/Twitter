package br.com.desafio.twitter;

import java.util.Collections;
import java.util.List;

import br.com.desafio.twitter.DAO.Tweet;

public class OrdenaListaTwitter {

	public static void ordenaTweet(List<Tweet> listaTweets){
		Collections.sort(listaTweets);
		
		System.out.println("================================");
		System.out.println("Lista ordenada: ");
		System.out.println("================================");
		
		for(int i=0; i<listaTweets.size(); i++){
			Tweet t = listaTweets.get(i);
			System.out.println(t.toString());
		}
		System.out.println("================================");
	}
	
}
