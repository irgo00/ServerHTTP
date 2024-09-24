import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SimpleHTTPServer {
    public static void main(String[] args) throws IOException {
        final ServerSocket servidor = new ServerSocket(8080);

        System.out.println("Escutando conexão na porta 8080...");

        while (true) {
            try (Socket socket = servidor.accept()) {
                Date hoje = new Date();
                String html = "<html><body><h1>Bem-vindo ao Meu Servidor!</h1><p>Data e hora atual: " + hoje + "</p></body></html>";
                String httpResposta = "HTTP/1.1 200 OK\r\n\r\n" + html;
                socket.getOutputStream().write(httpResposta.getBytes("UTF-8"));
            }
        }
    }
}
