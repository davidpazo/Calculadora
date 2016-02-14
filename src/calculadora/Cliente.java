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
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class Cliente {

    Socket Socketcli;
    InetSocketAddress isaddr;
    InputStream ips;
    OutputStream ops;

    //Conectamos el socket del cliente al servidor
    public void conexion() {
        try {
            Socketcli = new Socket();
            isaddr = new InetSocketAddress("localhost", 5555);
            Socketcli.connect(isaddr);
            ips = Socketcli.getInputStream();
            ops = Socketcli.getOutputStream();

        } catch (IOException ex) {
            System.out.println("ERROR de IO: " + ex);
        }
    }

    //Mandamos los datos al servidor del cliente
    public void datos(int code) {
        try {
            String op1 = JOptionPane.showInputDialog("Número 1:\n");
            op1 = op1 + "-";
            String op2 = JOptionPane.showInputDialog("Número 2:\n");
            op2 = op2 + "-";
            String ope = JOptionPane.showInputDialog("Operación:\n1=Suma\n2=Resta\n3=Producto\n4=División");
            ope = ope + "-";
            String msj = op1 + op2 + ope + String.valueOf(code) + "-";
            ops.write(msj.getBytes());

        } catch (IOException ex) {
            System.out.println("ERROR de IO: " + ex);
        }
    }

    //Cerramos la conexion del socket del cliente
    public void cerrar() {
        try {
            Socketcli.close();
            System.out.println("Socket cliente cerrado");
        } catch (IOException ex) {
            System.out.println("ERROR de IO: " + ex);
        }
    }
}

