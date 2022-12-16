package projectosd;

import java.io.*;
import java.net.*;
import javax.swing.*;


public class TCPClient {
    
    public static void main(String args[]) throws IOException
    {
      
      // Aqui ocorri a conexao ou seja o handShake;
      Socket socket = new Socket("localhost", 5000); // criar um obj socket que vai se conectar a um end. Ip "localhost ou 172.0.4.5 se for noutra maquina" e escuta esta porta 5000;
      PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // Apois, cria objecto para enviar informações ao servidor;
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // criacao de um obj para receber informacao do servidor;
       
      String entradaservidor = "";
      String entradausuario = JOptionPane.showInputDialog("Digite:");
      while(!entradausuario.equals("fim")){ // laco repeti ate que usuario digite fim.
          out.println(entradausuario);
          entradaservidor = in.readLine();
          entradausuario = JOptionPane.showInputDialog("Chegou:" + entradaservidor + "\nDigite para enviar :");
      }
        
        out.close(); in.close(); socket.close();
    } 
}
