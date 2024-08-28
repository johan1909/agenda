package co.edu.uniquindio.poo.application;

import javax.swing.JOptionPane;


import co.edu.uniquindio.poo.model.Contacto;
import co.edu.uniquindio.poo.model.Grupo;
import co.edu.uniquindio.poo.model.Reunion;




public class App {
    public static void main(String[] args) {
        

        Contacto contacto1= new Contacto("jorge", "mono", "carrera 3 calle 11", "3213485649", "rodrigo123@gmail.com");

        JOptionPane.showMessageDialog(null, contacto1.toString());


        Grupo grupo1= new Grupo("viaje", 5, null);

        grupo1.registarContacto(contacto1);

        JOptionPane.showMessageDialog(null, grupo1.toString());

        Reunion reunion1 = new Reunion("junta", null, null, 0);
        reunion1.registarContacto(contacto1);

        JOptionPane.showMessageDialog(null, reunion1.toString());



    }
}
