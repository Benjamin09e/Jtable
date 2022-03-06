package org.dvp.wichtounet.jtable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JTableAvecRenderer extends JFrame {
    private ModeleDynamiqueRenderer modele = new ModeleDynamiqueRenderer();
    private JTable tableau;

    public JTableAvecRenderer() {
        super();

        setTitle("JTable avec renderer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableau = new JTable(modele);

        tableau.setDefaultRenderer(Boolean.class, new SexeCellRenderer());
        tableau.setDefaultRenderer(Color.class, new ColorCellRenderer());
        tableau.getColumnModel().getColumn(1).setCellRenderer(new BoldCellRenderer());

        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

        JPanel boutons = new JPanel();

        boutons.add(new JButton(new AddAction()));
        boutons.add(new JButton(new RemoveAction()));

        getContentPane().add(boutons, BorderLayout.SOUTH);

        pack();
    }

    public static void main(String[] args) {
        new JTableAvecRenderer().setVisible(true);
    }

    private class AddAction extends AbstractAction {
        private AddAction() {
            super("Ajouter");
        }

        public void actionPerformed(ActionEvent e) {
            modele.addAmi(new Ami("Megan", "Sami", Color.green, false, Sport.NATATION));
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