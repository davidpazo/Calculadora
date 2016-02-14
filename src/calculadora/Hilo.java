/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculadora;

/**
 *
 * @author david
 */
public class Hilo extends Thread {
//Creamos el hilo para los clientes
    private final int numcli;

    public Hilo(int numH) {
        this.numcli = numH;
    }

    @Override
    public void run() {
        Cliente cli = new Cliente();
        cli.conexion();
        cli.datos(numcli);
        cli.cerrar();
    }
}