package es.medac.s1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

/*
public class GestorCliente implements Runnable { // Ponemos el runnable

    // creamos el socket
    private Socket socket;

    // constructor
    public GestorCliente(Socket socket) {
        this.socket = socket;
    }

    // metodo run
    @Override
    public void run() {
        try {
            // creacion de los streams out e input
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // bucle para los mensajes
            boolean salir = false;
            while (!salir) {
                try {
                    String mensaje = in.readUTF();

                    if (mensaje.equalsIgnoreCase("FIN")) {
                        salir = true;
                        System.out.println("Cliente (" + socket.getInetAddress() + ") ha finalizado.");
                    } else {
                        System.out.println("Cliente dice: " + mensaje);
                        out.writeUTF("Servidor: Recibido -> " + mensaje);
                    }
                } catch (IOException e) {
                    // Por si acaso el cliente se desconecta
                    System.out.println("Cliente desconectado abruptamente.");
                    salir = true;
                }
            }

            // cierro el socket
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 */



/* Clase usada en la fase 4 */

public class GestorCliente implements Runnable {

    private Socket socket;

    public GestorCliente(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {

            System.out.println("Cliente conectado desde: " + socket.getInetAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            boolean salir = false;

            while (!salir) {
                try {
                    // Esperamos mensaje del cliente
                    String mensaje = in.readUTF();

                    if (mensaje.equalsIgnoreCase("FIN")) {
                        salir = true;
                        System.out.println("Cliente (" + socket.getInetAddress() + ") ha finalizado voluntariamente.");
                    } else {
                        System.out.println("Cliente dice: " + mensaje);
                        out.writeUTF("Servidor: Recibido -> " + mensaje);
                    }

                } catch (SocketException | EOFException e) {
                    System.out.println("El cliente (" + socket.getInetAddress() + ") se ha desconectado inesperadamente.");
                    salir = true; // Salimos del bucle cuando el cliente se sale bruscamete
                }
            }

            // Cerrar recursos
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}