package org.dvp.wichtounet.jtable;

import javax.swing.*;

public class SportCellEditor extends DefaultCellEditor {
    public SportCellEditor() {
        super(new JComboBox<Object>(Sport.values()));
    }
}
