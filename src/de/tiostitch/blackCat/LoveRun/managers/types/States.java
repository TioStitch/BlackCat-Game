package de.tiostitch.blackCat.LoveRun.managers.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.swing.*;

@Getter
@AllArgsConstructor
public enum States {
    RUN_GAME(new ImageIcon("src/resources/screen/Run_Background.png")),
    END_GAME(new ImageIcon("src/resources/screen/End_Background.png")),
    START_GAME(new ImageIcon("src/resources/screen/Play_Background.png"));

    private final ImageIcon icon;
}
