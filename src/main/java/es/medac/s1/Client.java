package es.medac.s1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/* CLASE USADA PARA LA FASE 1--------------------------------------------------------------------------

public class Client {

    public static void main(String[] args) {

        // Host del servidor
        final String HOST = "localhost"; // TAMBIÉN SE PUEDE PONER SU IP (127.0.0.1)

        // Puerto del servidor
        final int PORT = 5000;

        DataInputStream in = null;
        DataOutputStream out = null;

        try {

            Socket socket = new Socket(HOST, PORT);

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());z

            // Enviamos una petición al servidor
            out.writeUTF("Hola soy el cliente");

            // Recibimos la respuesta del servidor
            String mensaje = in.readUTF();

            System.out.println(mensaje);

            // Cerramos socket
            socket.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
    }

}
 */


//  CLASE USADA PARA LAS DEMÁS FASES (2,3 y 4)
public class Client {

    public static void main(String[] args) {

        // Datos de la conexion
        final String HOST = "localhost";
        final int PORT = 6000;

        try {
            Scanner s = new Scanner(System.in);

            // Conectar al servidor
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
                if (texto.equalsIgnoreCase("FIN")) {
                    salir = true;
                    System.out.println("Cerrando conexión...");
                } else {
                    // Si no es fin, esperar respuesta
                    String respuesta = input.readUTF();
                    System.out.println("Servidor: " + respuesta);
                }
            }

            // Cerrar recursos al salir del bucle
            socket.close();
            System.out.println("Conexión terminada con éxito");


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
