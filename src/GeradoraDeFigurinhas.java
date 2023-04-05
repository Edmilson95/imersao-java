import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
        // leitura da imagem
        // InputStream InputStream = new FileInputStream(new File("entrada/filme.jpg"));
        // InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // criar nova imagem em memoria com transparencia e tamanho nova
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original pra nova imagem(em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);


        // BufferedImage imagemSobreposicao = ImageIO.read(inputStreamSobreposicao);
        // int posicaoImagemSobreposicaoY = novaAltura - imagemSobreposicao.getHeight();
        // graphics.drawImage(imagemSobreposicao, 0, posicaoImagemSobreposicaoY, null);


        // configurar a fonte
        var fonte = new Font("Impact", Font.BOLD, 100);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem
        String texto = "BOM D+++";
        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle2D retangulo = fontMetrics.getStringBounds(texto, graphics);
        int larguraTexto = (int) retangulo.getWidth();
        int posicaoTextoX = (largura - larguraTexto) / 2;

        graphics.drawString(texto, posicaoTextoX, novaAltura - 100);

        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }

}
