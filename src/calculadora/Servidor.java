/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculadora;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author oracle
 */
public class Servidor {

    ServerSocket Socketser;
    Socket newSocket;
    InetSocketAddress isaddr;
    OutputStream ops;
    InputStream ips;

    //Método de conexión del servidor
    public void conectar() {
        try {
            Socketser = new ServerSocket();
            isaddr = new InetSocketAddress("localhost", 5555);
            Socketser.bind(isaddr);
        } catch (IOException ex) {
            System.out.println("ERROR de IO: " + ex);
        }
    }
    
    //Método leer del servidor para recibir las operaciones.
    public void leer() {
        try {
            String[] numeros;
            newSocket = Socketser.accept();
            System.out.println("Conectado");
            ips = newSocket.getInputStream();
            ops = newSocket.getOutputStream();
            byte[] mensaje = new byte[25];
            ips.read(mensaje);
            numeros = new String(mensaje).split("-");
            System.out.println("Número 1: " + numeros[0]);
            System.out.println("Número 2: " + numeros[1]);
            System.out.println("Operación: " + numeros[2]);
            System.out.println("Número de cliente: " + numeros[3]);
            int operacion = Integer.parseInt(numeros[2]);
            if (operacion == 1) {
                System.out.println(numeros[0] + "+" + numeros[1]);
                System.out.println("Resultado: " + (Integer.valueOf(numeros[0]) + Integer.valueOf(numeros[1])));
            }
            if (operacion == 2) {
                System.out.println(numeros[0] + "-" + numeros[1]);
                System.out.println("Resultado: " + (Integer.valueOf(numeros[0]) - Integer.valueOf(numeros[1])));
            }
            if (operacion == 3) {
                System.out.println(numeros[0] + "*" + numeros[1]);
                System.out.println("Resultado: " + (Integer.valueOf(numeros[0]) * Integer.valueOf(numeros[1])));
            }
            if (operacion == 4) {
                System.out.println(numeros[0] + "/" + numeros[1]);
                System.out.println("Resultado: " + (Integer.valueOf(numeros[0]) / Integer.valueOf(numeros[1])));
            }
        } catch (IOException ex) {
            System.out.println("ERROR de IO: " + ex);
        }
    }
    //Método que cierra el servidor.
    public void cerrar() {
        try {
            System.out.println("Cerrando el nuevo socket");
            newSocket.close();
            System.out.println("Cerrando el socket servidor");
            Socketser.close();
            System.out.println("Terminado");
        } catch (IOException ex) {
            System.out.println("ERROR de IO: " + ex);
        }
    }
}

