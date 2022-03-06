package org.dvp.wichtounet.jtable;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorCellEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
    private Color couleur;
    private JButton bouton;
    private JColorChooser colorChooser;
    private JDialog dialog;

    public ColorCellEditor() {
        super();

        bouton = new JButton();
        bouton.setActionCommand("change");
        bouton.addActionListener(this);
        bouton.setBorderPainted(false);

        colorChooser = new JColorChooser();
        dialog = JColorChooser.createDialog(bouton, "Pick a Color", true, colorChooser, this, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("change".equals(e.getActionCommand())) {
            bouton.setBackground(couleur);
            colorChooser.setColor(couleur);
            dialog.setVisible(true);

            fireEditingStopped();
        } else {
            couleur = colorChooser.getColor();
        }
    }

    @Override
    public Object getCellEditorValue() {
        return couleur;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        couleur = (Color)value;

        return bouton;
    }
}