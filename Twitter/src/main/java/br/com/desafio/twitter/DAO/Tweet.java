package br.com.desafio.twitter.DAO;

public class Tweet implements Comparable<Tweet>{
	private int numeroRetweets;
	private AutorTwitter autor;
	private int likesTwitter;
	private String conteudoTwitter;
	private String dataTwitter;
	private String mentioned;
	private String replyTo;
	
	public String getReplyTo() {
		return replyTo;
	}
	public void setReplyTo(String replyTo) {
		this.replyTo = replyTo;
	}
	public String getMentioned() {
		return mentioned;
	}
	public void setMentioned(String mentioned) {
		this.mentioned = mentioned;
	}
	public int getNumeroRetweets() {
		return numeroRetweets;
	}
	public void setNumeroRetweets(int numeroRetweets) {
		this.numeroRetweets = numeroRetweets;
	}
	public AutorTwitter getAutor() {
		return autor;
	}
	public void setAutor(AutorTwitter autor) {
		this.autor = autor;
	}
	public int getLikesTwitter() {
		return likesTwitter;
	}
	public void setLikesTwitter(int likesTwitter) {
		this.likesTwitter = likesTwitter;
	}
	public String getConteudoTwitter() {
		return conteudoTwitter;
	}
	public void setConteudoTwitter(String conteudoTwitter) {
		this.conteudoTwitter = conteudoTwitter;
	}
	public String getDataTwitter() {
		return dataTwitter;
	}
	public void setDataTwitter(String dataTwitter) {
		this.dataTwitter = dataTwitter;
	}
	@Override
	public String toString() {
		return "Tweet [numeroRetweets=" + numeroRetweets + ", autor=" + autor
				+ ", likesTwitter=" + likesTwitter + ", conteudoTwitter="
				+ conteudoTwitter + ", dataTwitter=" + dataTwitter
				+ ", mentioned=" + mentioned + ", replyTo=" + replyTo + "]";
	}
	
	public int isTweetPriority(Tweet outroTweet){
		if(this.getNumeroRetweets()> outroTweet.getNumeroRetweets()){
			return -1;
		}
		if(this.getNumeroRetweets()< outroTweet.getNumeroRetweets()){
			return 1;
		}
		if(this.getLikesTwitter()> outroTweet.getLikesTwitter()){
			return -1;
		}
		if(this.getLikesTwitter()< outroTweet.getLikesTwitter()){
			return 1;
		}
		return 0;
	}
	
	public int compareTo(Tweet outroTweet) {
		if(this.getAutor().compareTo(outroTweet.getAutor())==1){
			return 1;
		}
		if(this.getAutor().compareTo(outroTweet.getAutor())== -1){
			return -1;
		}
		if(this.getAutor().compareTo(outroTweet.getAutor())== 0){
			if(isTweetPriority(outroTweet)== 1){
				return 1;
			}
			if(isTweetPriority(outroTweet)== -1){
				return -1;
			}
		}
		return 0;
	}
}
