
import java.io.*;
import java.net.*;
import java.util.*;



public class ServidorSocket {
    public static void main(String[] args){
        
        try{
            //Creamos un servidor socket en el puerto 12345
            ServerSocket serverSocket = new ServerSocket(12345);
            
            System.out.println("Servidor esperando conexiones...");
            
            //Esperamos que un cliente se conecte
            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado");
            
            //Creamos los flujos de entrada y salida para comunicarse con el cliente
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            //Leer los 10 números del cliente
            List<Integer> numeros = new ArrayList<>();
            for(int i = 0; i < 10; i++){
                int numero = Integer.parseInt(in.readLine());
                numeros.add(numero);
            }
            
            //Calculamos el número mayor, el número menor y la suma
            int numeroMayor = Collections.max(numeros);
            int numeroMenor = Collections.min(numeros);
            int suma = numeros.stream().mapToInt(Integer::intValue).sum();
            
            //Enviamos la respuesta al cliente
            out.println("El número mayor es " + numeroMayor + ", el número menor es " + numeroMenor + ", y la suma de todos los números digitados es " + suma);
            
            //Cerramos todas las conexiones
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
