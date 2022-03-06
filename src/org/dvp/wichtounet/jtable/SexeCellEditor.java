package org.dvp.wichtounet.jtable;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SexeCellEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
    private boolean sexe;
    private JButton bouton;

    public SexeCellEditor() {
        super();

        bouton = new JButton();
        bouton.addActionListener(this);
        bouton.setBorderPainted(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sexe ^= true;

        fireEditingStopped();
    }

    @Override
    public Object getCellEditorValue() {
        return sexe;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        sexe = (Boolean)value;

        return bouton;
    }
}