package org.dvp.wichtounet.jtable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JTableModifiable extends JFrame {
    private ModeleModifiable modele = new ModeleModifiable();
    private JTable tableau;

    public JTableModifiable() {
        super();

        setTitle("JTable modifiable");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableau = new JTable(modele);

        tableau.setDefaultRenderer(Boolean.class, new SexeCellRenderer());
        tableau.setDefaultRenderer(Color.class, new ColorCellRenderer());
        tableau.getColumnModel().getColumn(1).setCellRenderer(new BoldCellRenderer());

        tableau.setDefaultEditor(Sport.class, new SportCellEditor());
        tableau.setDefaultEditor(Color.class, new ColorCellEditor());
        tableau.setDefaultEditor(Boolean.class, new SexeCellEditor());

        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

        JPanel boutons = new JPanel();

        boutons.add(new JButton(new AddAction()));
        boutons.add(new JButton(new RemoveAction()));

        getContentPane().add(boutons, BorderLayout.SOUTH);

        pack();
    }

    public static void main(String[] args) {
        new JTableModifiable().setVisible(true);
    }

    private class AddAction extends AbstractAction {
        private AddAction() {
            super("Ajouter");
        }

        public void actionPerformed(ActionEvent e) {
            modele.addAmi(new Ami("Ekia", "Benjamin", Color.green, false, Sport.NATATION));
        }
    }

    private class RemoveAction extends AbstractAction {
        private RemoveAction() {
            super("Supprimmer");
        }

        public void actionPerformed(ActionEvent e) {
            int[] selection = tableau.getSelectedRows();

            for(int i = selection.length - 1; i >= 0; i--){
                modele.removeAmi(selection[i]);
            }
        }
    }
}