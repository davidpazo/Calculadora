package calculadora;

import javax.swing.JOptionPane;

/**
 *
 * @author oracle
 */
public class Calculadora {

     // Desde el main llamamos a todos los métodos del servidor y definimos
    // número de clientes, creando un hilo por cada cliente, tratando cada 
    // operación de cada cliente por separado. TCPIP
    public static void main(String[] args) {
        Servidor server = new Servidor();
        server.conectar();
        int b = Integer.parseInt(JOptionPane.showInputDialog("Nº de clientes: "));
        for (int i = 1; i <= b; i++) {
            Hilo h = new Hilo(i);
            h.start();
            server.leer();
        }
        server.cerrar();
    }
    
}
