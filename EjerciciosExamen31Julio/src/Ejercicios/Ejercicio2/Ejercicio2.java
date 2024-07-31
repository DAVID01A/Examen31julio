package Ejercicios.Ejercicio2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Ingrese la ruta del archivo a cifrar (origen.txt) ");
        String archivoOrigen = scanner.nextLine();
        System.out.print("Ingrese la ruta del archivo cifrado (cifrado.txt): ");
        String archivoDestino = scanner.nextLine();
        System.out.print("Ingrese un número entre 1 y 255 para la clave: ");
        int clave = scanner.nextInt();
        try (FileInputStream objeto1 = new FileInputStream(archivoOrigen);
             FileOutputStream objeto2 = new FileOutputStream(archivoDestino)) {

            int byteLeido;
            while ((byteLeido = objeto1.read()) != -1) {
                byte byteCifrado = (byte) (byteLeido ^ clave);
                objeto2.write(byteCifrado);
            }

            System.out.println("Se ha cifrado el archivo.");

        } catch (IOException e) {
            System.err.println("Error al cifrar el archivo: " + e.getMessage());
        }
    }
}
