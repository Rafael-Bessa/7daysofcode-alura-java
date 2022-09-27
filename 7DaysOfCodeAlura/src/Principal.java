
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;


public class Principal {

	public static void main(String[] args) {

		ImdbApiClient client = new ImdbApiClient("https://imdb-api.com/en/API/Top250Movies/k_g6yat091");
		
		String json;

		try {
			json = client.getBody();

		} catch (IOException | InterruptedException e) {

			throw new IllegalStateException(e);

		}


		ImdbJsonParser jsonParser = new ImdbJsonParser();

		List<Map<String, String>> lista = jsonParser.parse(json);
		
		//Colocando o mapa parseado em objetos do tipo Filme

		List<Filme> listaFilmes = new ArrayList<>();
		lista.forEach(mapa -> listaFilmes
			.add(new Filme(mapa.get("title"), mapa.get("image"), mapa.get("imDbRating"), mapa.get("year"))));

//		listaFilmes.forEach(f -> System.out.println(f));
		

		PrintWriter writer;
		
		try {
			writer = new PrintWriter("conteudo.html");
			
		} catch (FileNotFoundException e) {
			throw new IllegalStateException(e);
		}

		new GeradorHTML(writer).gerador(listaFilmes);

		writer.close();
		
		
		
		//Ordenando a lista de filmes por outros critérios
		
		
		listaFilmes.sort(Comparator.comparing(Filme::year));
		System.out.println(listaFilmes);
		

		
		listaFilmes.sort(Comparator.comparing(Filme::title));
		System.out.println(listaFilmes);
		
	}

}
