package de.tiostitch.blackCat.LoveRun.managers;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

@Getter @Setter
public final class IBlackCat {
    private int x, pontuation, y = 225;
    private final ImageIcon icon = new ImageIcon("src/resources/blackCat/Walk.gif");
    private final Rectangle2D rectangle = new Rectangle(x, y, icon.getIconWidth(), icon.getIconHeight());
}
