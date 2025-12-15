package es.medac.s1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/* CLASE USADA PARA LA FASE 1-------------------------------------------------------------------------

public class Server {

    public static void main(String[] args) {

        final int PUERTO = 6000;

        try (ServerSocket server = new ServerSocket(PUERTO)) {
            System.out.println("--- SERVIDOR FASE 1 (BLOQUEANTE) INICIADO ---");
            System.out.println("Esperando clientes en el puerto " + PUERTO + "...");

            while (true) {

                Socket sc = server.accept();
                System.out.println("Cliente conectado.");

                try {

                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                DataInputStream in = new DataInputStream(sc.getInputStream());
                DataOutputStream out = new DataOutputStream(sc.getOutputStream());

                String mensaje = in.readUTF();
                System.out.println("Mensaje recibido: " + mensaje);

                out.writeUTF("Servidor (después de la siesta): Recibido -> " + mensaje);

                sc.close();
                System.out.println("Cliente desconectado. Listo para el siguiente.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

 */


/*  CLASE USADA PARA LA FASE 2-------------------------------------------------------------------

public class Server {


    public static void main(String[] args) {


        final int PUERTO = 6000; //Asignamos el puerto

        try (ServerSocket servidor = new ServerSocket(PUERTO)) {
            System.out.println("Servidor iniciado en puerto " + PUERTO + ". Esperando...");

            while (true) {

                Socket sc = servidor.accept();
                System.out.println("Cliente conectado.");


                DataInputStream in = new DataInputStream(sc.getInputStream());
                DataOutputStream out = new DataOutputStream(sc.getOutputStream());


                //Corrección de Thread.sleep
            try {
                Thread.sleep(15000);
            }catch(InterruptedException e) {
                e.printStackTrace();
            }

                boolean salir = false;


                while (!salir) {
                    try {
                        // Leeo el mensaje del cliente
                        String mensaje = in.readUTF();

                        if (mensaje.equalsIgnoreCase("FIN")) {
                            salir = true;
                            System.out.println("El cliente ha escrito FIN.");
                        } else {
                            System.out.println("Cliente dice: " + mensaje);
                            // Respondemos al cliente
                            out.writeUTF("Servidor: He recibido -> " + mensaje);
                        }
                    } catch (IOException e) {
                        // Si el cliente se desconecta de golpe, salimos del bucle
                        System.out.println("El cliente se desconectó abruptamente.");
                        salir = true;
                    }
                }


                sc.close();
                System.out.println("Cliente desconectado. Esperando al siguiente...");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     */



    // CLASE USADA PARA LA FASE 3 Y 4 ----------------------------------------------------------------------------

    public class Server {

        public static void main(String[] args) {
            final int PUERTO = 6000;

            try (ServerSocket servidor = new ServerSocket(PUERTO)) {
                System.out.println("Servidor MULTIHILO iniciado en puerto " + PUERTO);

                while (true) {
                    // Esperar la conexion
                    System.out.println("Esperando nuevo cliente...");
                    Socket socket = servidor.accept();

                    // Este es el que gestionará al cliente
                    GestorCliente gestor = new GestorCliente(socket); // [cite: 60]

                    // Esto es para crear el hilo
                    Thread hilo = new Thread(gestor);
                    hilo.start(); // uso de start(), porque run() daria error

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}