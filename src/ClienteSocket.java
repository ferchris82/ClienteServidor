
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ClienteSocket {
    public static void main(String[] args) {
        
        try {
            //Conectamos al servidor en el puerto 12345
            Socket socket = new Socket("localhost", 12345);
            
            //Crear flujos de entrada y salida para comunicarse con el servidor
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            //Enviar los 10 números al servidor
            for(int i = 1; i <= 10; i++){
                out.println(i);
            }
            
            //Recibir la respuesta del servidor y mostrarla
            String respuesta = in.readLine();
            System.out.println(respuesta);
            
            //Cerramos las conexiones
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
