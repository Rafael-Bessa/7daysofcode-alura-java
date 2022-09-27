
public class Filme implements Conteudo{
	
	private String title;
	private String urlImage;
	private String rating;
	private String year;
	
	public Filme(String titulo, String imagem, String rating, String ano) {
		this.title = titulo;
		this.urlImage = imagem;
		this.rating = rating;
		this.year = ano;
	}
	
	@Override
	public String toString() {
		return "Filme: " + this.title + " , " + "Rating: " + this.rating + " , " + "Ano: " + this.year;
	}


	@Override
	public String title() {	
		return title;
	}


	@Override
	public String urlImage() {	
		return urlImage;
	}


	@Override
	public String rating() {
		return rating;
	}


	@Override
	public String year() {
		return year;
	}
	

}
