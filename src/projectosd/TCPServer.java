package projectosd;

import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;

public class TCPServer {

   // lançou esta exception devido a classe ServerSocket.
    public static void main(String[] args) throws IOException {
        
        System.out.println("Servidor iniciado...");
        ServerSocket socketServidor = new ServerSocket(5000); // este obj do tipo server socket vai escutar a porta 5000;
        /* apois acima, aqui eu peco para o meu obj socketServidor esperar e escutar 
        todas a conexões que ocorrem na placa de rede do meu computador */
        // metodo accept() -> programa fica parado aqui escutando até chegar uam conexao na porta 5000 para continuar;
        Socket socketCliente = socketServidor.accept(); 
        /* Apois chegar a conexao da porta 5000, o obj socketServidor cria um obj do tipo
        socketCliente */
        // este é o obj que vai se comuicar com o cliente. Dele criou-se dois objs.
        PrintWriter out = new PrintWriter(socketCliente.getOutputStream(), true); // para enviar uma informacao;
        BufferedReader in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream())); // para ler o que estou recebendo;
        
        
        String entrada;
        
        while((entrada = in.readLine()) != null){ // o laço executa enquanto conseguir ler informacoes que vem da minha conexão;
                System.out.println("Recebido:" + entrada); // imprimi a mensagem que recebeu do cliente (socket conectado a mim);
                JOptionPane.showMessageDialog(null,"Servidor recebe: " + entrada);
                out.println(entrada); // manda de volta a mesma mensagem para o cliente (socket conectado a mim);
                if(entrada.equals("fim")) // se a mensagem for igual a fim da um quebra o ciclo;
                   break;
        }
        
        out.close(); in.close();
        socketServidor.close(); socketCliente.close();
        
    }
    
}
