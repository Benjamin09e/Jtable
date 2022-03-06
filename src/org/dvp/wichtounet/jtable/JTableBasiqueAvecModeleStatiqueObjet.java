package org.dvp.wichtounet.jtable;

import javax.swing.*;
import java.awt.*;

public class JTableBasiqueAvecModeleStatiqueObjet extends JFrame {
    public JTableBasiqueAvecModeleStatiqueObjet() {
        super();

        setTitle("JTable avec modèle statique et des objets");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTable tableau = new JTable(new ModeleStatiqueObjet());

        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

        pack();
    }

    public static void main(String[] args) {
        new JTableBasiqueAvecModeleStatiqueObjet().setVisible(true);
    }
}