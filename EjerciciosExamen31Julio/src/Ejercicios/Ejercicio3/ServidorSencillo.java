package Ejercicios.Ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ServidorSencillo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Servidor escuchando en el puerto 12345");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Nuevo cliente conectado");

            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter salida = new PrintWriter(socket.getOutputStream(),
            true);

            String[] datos = entrada.readLine().split(",");
            String fechaTransaccion = datos[0];
            String numeroTarjeta = datos[1];
            String fechaVencimiento = datos[2];
            String cvv = datos[3];
            String saldo = datos[4];

            Random random = new Random();
            int codigoAutorizacion = random.nextInt(4);
            String descripcion = switch (codigoAutorizacion)
            {
                case 0 -> "TRANSACCION AUTORIZADA";
                case 1 -> "Error 9137 VALIDACION DE TARJETA ERRONEO";
                case 2 -> "Error 9221 NO ESTA INTRODUCIENDO EL CVV CORRECTO";
                default -> "Error 9677 SALDO INSUFICIENTE";
            };
            salida.println(fechaTransaccion + "," + codigoAutorizacion + "," + descripcion + "," + numeroTarjeta);
            socket.close();
        }
    }
}
