package de.tiostitch.blackCat.LoveRun.managers.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.swing.*;

@Getter
@AllArgsConstructor
public enum EnemyType {
    CACTUS(new ImageIcon("src/resources/obstacles/Cactus.png")),
    BACTERY(new ImageIcon("src/resources/obstacles/Bactery-Enemie.gif")),
    FLOOR(new ImageIcon("src/resources/obstacles/Floor.png"));

    private final ImageIcon icon;
}
