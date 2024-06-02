package de.tiostitch.blackCat.LoveRun;

import lombok.Getter;
import javax.swing.*;

public final class GameMain
extends JFrame {

    @Getter public static GameMain instance;
    @Getter private final GameKeys gameKeys;

    private GameMain() {
        instance = this;
        gameKeys = new GameKeys();

        setTitle("Black Cat - Love Run");
        setSize(600, 300);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        addKeyListener(new GameKeys());
        add(new GameGraphic());
    }



    public static void main(String[] args) {
        new GameMain();
    }
}
