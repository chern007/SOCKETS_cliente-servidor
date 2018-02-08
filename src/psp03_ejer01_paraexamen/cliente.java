/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp03_ejer01_paraexamen;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chern007
 */
public class cliente {

    public static void main(String[] args) {

        try {
            Socket sc = new Socket("localhost", 2000);

            DataOutputStream loQueSale = new DataOutputStream(sc.getOutputStream());
            DataInputStream loQueEntra = new DataInputStream(sc.getInputStream());

            //enviamos
            loQueSale.writeUTF("1");

            //recibimos
            String respuestaServidor = loQueEntra.readUTF();

            System.out.println(respuestaServidor);

        } catch (IOException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
