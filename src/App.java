import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar o json de qualquer API

        // ExtratorDeConteudo extrator = new ExtratorDeConteudoIMDB();
        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
        // String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-16";

        ExtratorDeConteudo extrator = new ExtratorDeConteudoIMDB();
        String url = "https://linguagens-imersao-java.fly.dev/linguagens";

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        
        //exibir e manipular os dados
        List<Conteudo> conteudos = extrator.extraiConteudos(json);


        var geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);
           
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println("\u001b[1mTítulo:\u001b[m " + conteudo.getTitulo());
            System.out.println();

        }




    //     int notaDoFilme = (int) classificacao;
    //    for (int n = 1; n <= notaDoFilme; n++){ 
    //     System.out.print("⭐");
    //    }
    //    System.out.println("\n");

    // double classificacao = Double.parseDouble(conteudo.get("imDbRating"));

    // String textoFigurinha;
    // InputStream imagemEdmilson;
    // if (classificacao >= 8){
    //     textoFigurinha = "TOPZERA";
    //     imagemEdmilson = new FileInputStream("sobreposicao/eu.jpg");
    // } else {
    //     textoFigurinha = "HMMMM....";
    //     imagemEdmilson = new FileInputStream("sobreposicao/eu.jpg");
    // }

    }
}
