package edu.formularios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio {
    private JPanel panelinicio;


    public static void main(String[] args) {

        Inicio inicio = new Inicio();
        // Crear una instancia de la clase Inicio3
        // Crear un JFrame y agregar el panelinicio a él
        JFrame frame = new JFrame("Inicio");
        frame.getContentPane().add(inicio.panelinicio); // Agrega el panel al contenido del JFrame
        frame.setSize(800, 500);
        frame.setVisible(true);

        // Establece la operación de cierre para que la ventana se cierre correctamente
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JLabel lbl1;
    private JButton botoninicio;


}