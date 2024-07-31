package Ejercicios.Ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteSencillo {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la fecha de la transacción (aaaa-mm-dd): ");
        String fechaTransaccion = scanner.nextLine();
        System.out.print("Ingrese el numero de la tarjeta (16 digitos): ");
        String numeroTarjeta = scanner.nextLine();
        System.out.print("Ingrese la fecha de vencimiento (aaaa-mm-dd): ");
        String fechaVencimiento = scanner.nextLine();
        System.out.print("Ingrese el Codigo de la tarjeta CVV : ");
        String cvv = scanner.nextLine();
        System.out.print("Indique la cantidad a retirar : ");
        String saldo = scanner.nextLine();
        Socket socket = new Socket("localhost", 12345);
        PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        salida.println(fechaTransaccion + "," + numeroTarjeta + "," + fechaVencimiento + "," + cvv + "," + saldo);
        String respuesta = entrada.readLine();
        String[] datosRespuesta = respuesta.split(",");
        System.out.println("Fecha de la transacción: " + datosRespuesta[0]);
        System.out.println("Código de autorización: " + datosRespuesta[1]);
        System.out.println("Descripción: " + datosRespuesta[2]);
        System.out.println("Número de tarjeta: " + datosRespuesta[3]);

        socket.close();
    }
}
