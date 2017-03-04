package br.com.desafio.twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import br.com.desafio.twitter.DAO.AutorTwitter;
import br.com.desafio.twitter.DAO.Tweet;

import com.github.tsohr.JSONArray;
import com.github.tsohr.JSONObject;

public class RecuperaListaTwitter {
	
	public static List<Tweet> listaTwitter = new ArrayList<Tweet>();
	
	public static List<Tweet> getObjeto(String urlWebService, String usuario) {
		
	      try {
	         URL url = new URL(urlWebService);
	         HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	         connection.setRequestMethod("GET");
	         connection.setConnectTimeout(15000);
	         connection.setRequestProperty("Username",usuario);
	         connection.connect();

	         String responseJson = inputStreamToString(connection.getInputStream());
	         connection.disconnect();
	         fromJson(responseJson);

	      } catch (Exception e) {
	         e.printStackTrace();
	      }	
	      return listaTwitter;
	}
	
	public static String inputStreamToString(InputStream is) throws IOException {
	      if (is != null) {
	         Writer writer = new StringWriter();

	         char[] buffer = new char[1024];
	         try {
	            Reader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
	            int n;
	            while ((n = reader.read(buffer)) != -1) {
	               writer.write(buffer, 0, n);
	            }
	         } finally {
	            is.close();
	         }
	         return writer.toString();
	      } else {
	         return "";
	      }
	}
	
	public static void fromJson(String json) throws Exception {
		
		JSONObject jsonTweet = new JSONObject(json);
	    JSONArray arr = jsonTweet.getJSONArray("statuses");
	    
	    for(int i=0; i<arr.length();i++){
	    	Tweet tweet = new Tweet();
	    	AutorTwitter autor = new AutorTwitter();
	    	jsonTweet = arr.getJSONObject(i);
	    	
	    	//Mapeando cada tweet
	    	tweet.setNumeroRetweets(jsonTweet.optInt("retweet_count"));
	    	tweet.setLikesTwitter(jsonTweet.optInt("favorite_count"));
	    	tweet.setConteudoTwitter(jsonTweet.optString("text"));
	    	tweet.setDataTwitter(jsonTweet.optString("created_at"));
	    	tweet.setReplyTo(jsonTweet.optString("in_reply_to_user_id_str"));
	    	
	    	String entities = jsonTweet.optString("entities");
	    	JSONObject user_mentions = new JSONObject(entities);
	    	JSONArray array_mentions = user_mentions.getJSONArray("user_mentions");
	    	
	    	for(int j=0; j<array_mentions.length();j++){
	    		user_mentions = array_mentions.getJSONObject(j);
	    		tweet.setMentioned(user_mentions.optString("id_str"));
	    	}
	    	
	    	String user = jsonTweet.optString("user");
	    	jsonTweet = new JSONObject(user);
	    	
    		autor.setScreenNameAutor(jsonTweet.getString("name"));
    		autor.setIdTwitter(jsonTweet.getString("id_str"));
    		autor.setNumeroSeguidoresAutor(jsonTweet.getInt("followers_count"));
    		tweet.setAutor(autor);
    		
    		//System.out.println(tweet);
    		if(tweet.getMentioned() != null && tweet.getMentioned().equals("42")){
    			if(tweet.getReplyTo() != null && !tweet.getReplyTo().equals("42")){
    				listaTwitter.add(tweet);
    			}
    		}
	    	
	    }
	}
}
