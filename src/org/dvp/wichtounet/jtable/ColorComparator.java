package org.dvp.wichtounet.jtable;

import java.awt.*;
import java.util.Comparator;

public class ColorComparator implements Comparator<Color> {
    @Override
    public int compare(Color c1, Color c2) {
        return new Integer(c1.getBlue()).compareTo(c2.getBlue());
    }
}