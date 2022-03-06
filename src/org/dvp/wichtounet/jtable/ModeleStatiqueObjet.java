package org.dvp.wichtounet.jtable;

import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class ModeleStatiqueObjet extends AbstractTableModel {
    private final Ami[] amis;

    private final String[] entetes = {"Prénom", "Nom", "Couleur favorite", "Homme", "Sport"};

    public ModeleStatiqueObjet() {
        super();

        amis = new Ami[]{
                new Ami("Johnathan", "Sykes", Color.red, true, Sport.TENNIS),
                new Ami("Nicolas", "Van de Kampf", Color.black, true, Sport.FOOTBALL),
                new Ami("Damien", "Cuthbert", Color.cyan, true, Sport.RIEN),
                new Ami("Corinne", "Valance", Color.blue, false, Sport.NATATION),
                new Ami("Emilie", "Schrödinger", Color.magenta, false, Sport.FOOTBALL),
                new Ami("Delphine", "Duke", Color.yellow, false, Sport.TENNIS),
                new Ami("Eric", "Trump", Color.pink, true, Sport.FOOTBALL)
        };
    }

    public int getRowCount() {
        return amis.length;
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
                return amis[rowIndex].getPrenom();
            case 1:
                return amis[rowIndex].getNom();
            case 2:
                return amis[rowIndex].getCouleur();
            case 3:
                return amis[rowIndex].isHomme();
            case 4:
                return amis[rowIndex].getSport();
            default:
                return null; //Ne devrait jamais arriver
        }
    }
}