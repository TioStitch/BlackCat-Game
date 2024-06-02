package de.tiostitch.blackCat.LoveRun.managers;

import de.tiostitch.blackCat.LoveRun.managers.types.EnemyType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.geom.Rectangle2D;

@Getter @Setter
@AllArgsConstructor
public final class IEnemy {
    private int x, y;
    private int xSpeed;
    private final EnemyType type;
    private final Rectangle2D rectangle = new Rectangle(x, y, 64, 64);
}
