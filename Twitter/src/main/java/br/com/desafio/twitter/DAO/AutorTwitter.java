package br.com.desafio.twitter.DAO;

public class AutorTwitter implements Comparable<AutorTwitter> {
	private String screenNameAutor;
	private int numeroSeguidoresAutor;
	private String linkPerfil;
	private String idTwitter;
	
	public String getIdTwitter() {
		return idTwitter;
	}
	public void setIdTwitter(String idTwitter) {
		this.idTwitter = idTwitter;
	}
	public String getLinkPerfil() {
		return linkPerfil;
	}
	public void setLinkPerfil(String linkPerfil) {
		this.linkPerfil = linkPerfil;
	}
	public String getScreenNameAutor() {
		return screenNameAutor;
	}
	public void setScreenNameAutor(String screenNameAutor) {
		this.screenNameAutor = screenNameAutor;
	}
	public int getNumeroSeguidoresAutor() {
		return numeroSeguidoresAutor;
	}
	public void setNumeroSeguidoresAutor(int numeroSeguidoresAutor) {
		this.numeroSeguidoresAutor = numeroSeguidoresAutor;
	}
	
	@Override
	public String toString() {
		return "AutorTwitter [screenNameAutor=" + screenNameAutor
				+ ", numeroSeguidoresAutor=" + numeroSeguidoresAutor
				+ ", linkPerfil=" + linkPerfil + ", idTwitter=" + idTwitter
				+ "]";
	}
	
	public int compareTo(AutorTwitter o) {
		// TODO Auto-generated method stub
		if(this.getNumeroSeguidoresAutor()> o.getNumeroSeguidoresAutor()){
			return -1;
		}
		if(this.getNumeroSeguidoresAutor()< o.getNumeroSeguidoresAutor()){
			return 1;
		}
		return 0;
	}
}
