package org.dvp.wichtounet.jtable;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class JTableTriable extends JFrame {
    private ModeleModifiable modele = new ModeleModifiable();
    private JTable tableau;

    public JTableTriable() {
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

        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableau.getModel());
        sorter.setComparator(2, new ColorComparator());
        tableau.setRowSorter(sorter);
        
        getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);

        JPanel boutons = new JPanel();

        boutons.add(new JButton(new AddAction()));
        boutons.add(new JButton(new RemoveAction()));

        getContentPane().add(boutons, BorderLayout.SOUTH);

        pack();
    }

    public static void main(String[] args) {
        new JTableTriable().setVisible(true);
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
            int[] modelIndexes = new int[selection.length];

            for(int i = 0; i < selection.length; i++){
                modelIndexes[i] = tableau.getRowSorter().convertRowIndexToModel(selection[i]);
            }

            Arrays.sort(modelIndexes);

            for(int i = modelIndexes.length - 1; i >= 0; i--){
                modele.removeAmi(modelIndexes[i]);
            }
        }
    }
}