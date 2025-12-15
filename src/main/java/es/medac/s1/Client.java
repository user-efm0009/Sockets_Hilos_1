package es.medac.s1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        // Asegúrate de que este puerto COINCIDE con el de tu Servidor (6000)
        final String HOST = "localhost";
        final int PORT = 6000;

        try {
            Scanner s = new Scanner(System.in);

            // Conectar al servidor (Corregido: el puerto es un int, sin comillas)
            Socket socket = new Socket(HOST, PORT);
            System.out.println("Conectado al servidor en el puerto " + PORT);

            // inciar los streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            boolean salir = false;

            // conversacion bucle
            while(!salir) {
                System.out.print("Mensaje a enviar: ");
                String texto = s.nextLine();

                // Enviar mensaje
                output.writeUTF(texto);

                // Comprobar si es FIN
                if (texto.equalsIgnoreCase("FIN")) { // Ignorecase porsi acaso
                    salir = true;
                    System.out.println("Cerrando conexión...");
                } else {
                    // Si no es fin, esperar respuesta
                    String respuesta = input.readUTF();
                    System.out.println("Servidor: " + respuesta);
                }
            }

            // 4. Cerrar recursos al salir del bucle
            socket.close();
            System.out.println("Conexión terminada con éxito");


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}