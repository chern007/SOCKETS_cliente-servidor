/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp03_ejer01_paraexamen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author chern007
 */
public class servidor {

    public static void main(String[] args) {

        try {

            //**************************************************
            //****************EJEMPLO DE TIMER******************
            //**************************************************
            new Timer(5000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Servidor corriendo.");
                }
            }).start();
            //**************************************************
            //**************************************************

            ServerSocket ss = new ServerSocket(2000);
            Calendar calendar;

            while (true) {

                Socket sc = ss.accept();//guardamos la conexion del cliente en un nuevo objeto socket  

                DataInputStream loQueEntra = new DataInputStream(sc.getInputStream());
                DataOutputStream loQueSale = new DataOutputStream(sc.getOutputStream());

                String peticionCliente = loQueEntra.readUTF();

                switch (peticionCliente) {
                    case "1":

                        calendar = Calendar.getInstance();

                        loQueSale.writeUTF("Son las " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));

                        break;

                    case "2":

                        loQueSale.writeUTF("Que pasa su compadre!");

                        break;

                    default:

                        loQueSale.writeUTF("No has seleccionado una opcion correcta");

                        ;
                }

            }

        } catch (IOException ex) {
            Logger.getLogger(servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
