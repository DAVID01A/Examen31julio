package Ejercicios.Ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        Scanner objeto = new Scanner(System.in);
        System.out.println("Introduzca la ruta completa del fichero");
        String rutaArchivo = objeto.nextLine();
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            System.out.println("Informacion del Archivo: ");
            System.out.println("Nombre: " + archivo.getName());
            System.out.println("Ruta Absoluta: " + archivo.getAbsolutePath());
            System.out.println("Tamaño: " + archivo.length());
            System.out.println("Es Archivo: " + archivo.isFile());
        } else {
            System.out.println("Error al encontrar el archivo");
        }
        try (FileReader fr = new FileReader(archivo);
             BufferedReader br = new BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);

            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
