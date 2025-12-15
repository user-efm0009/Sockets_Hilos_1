package es.medac.s1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Thread;

public class Server {

    public static void main(String[] args) {

        ServerSocket servidor = null;
        Socket sc = null;

        DataInputStream in = null;
        DataOutputStream out = null;

        final int PUERTO = 5000;

        try {

            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor a la espera...");

            while (true) {
                // Esperar a que un cliente realice petición
                sc = servidor.accept();

                Thread.sleep(15000); // FASE 1 - MODIFICACIÓN DE EL SERVIDOR

                System.out.println("Cliente conectado con suceso");

                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                // Leo el mensaje del cliente
                String mensaje = in.readUTF();

                System.out.println(mensaje);

                // Envio un mensaje
                out.writeUTF("Le saludo desde el servidor");

                // Cerrar el socket
                sc.close();
                System.out.println("Conexión terminada con suceso");

            }

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

}
