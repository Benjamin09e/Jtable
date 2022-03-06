package org.dvp.wichtounet.jtable;

import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ModeleDynamiqueObjet extends AbstractTableModel {
    private final List<Ami> amis = new ArrayList<Ami>();

    private final String[] entetes = {"Prénom", "Nom", "Couleur favorite", "Homme", "Sport"};

    public ModeleDynamiqueObjet() {
        super();

        amis.add(new Ami("Johnathan", "Sykes", Color.red, true, Sport.TENNIS));
        amis.add(new Ami("Nicolas", "Van de Kampf", Color.black, true, Sport.FOOTBALL));
        amis.add(new Ami("Damien", "Cuthbert", Color.cyan, true, Sport.RIEN));
        amis.add(new Ami("Corinne", "Valance", Color.blue, false, Sport.NATATION));
        amis.add(new Ami("Emilie", "Schrödinger", Color.magenta, false, Sport.FOOTBALL));
        amis.add(new Ami("Delphine", "Duke", Color.yellow, false, Sport.TENNIS));
        amis.add(new Ami("Eric", "Trump", Color.pink, true, Sport.FOOTBALL));
    }

    public int getRowCount() {
        return amis.size();
    }

    public int getColumnCount() {
        return entetes.length;
    }

    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return amis.get(rowIndex).getPrenom();
            case 1:
                return amis.get(rowIndex).getNom();
            case 2:
                return amis.get(rowIndex).getCouleur();
            case 3:
                return amis.get(rowIndex).isHomme();
            case 4:
                return amis.get(rowIndex).getSport();
            default:
                return null; //Ne devrait jamais arriver
        }
    }

    public void addAmi(Ami ami) {
        amis.add(ami);

        fireTableRowsInserted(amis.size() -1, amis.size() -1);
    }

    public void removeAmi(int rowIndex) {
        amis.remove(rowIndex);

        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}