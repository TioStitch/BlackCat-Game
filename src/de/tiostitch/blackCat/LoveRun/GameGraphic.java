package de.tiostitch.blackCat.LoveRun;

import de.tiostitch.blackCat.LoveRun.managers.IBackground;
import de.tiostitch.blackCat.LoveRun.managers.IBlackCat;
import de.tiostitch.blackCat.LoveRun.managers.IEnemy;
import de.tiostitch.blackCat.LoveRun.managers.IMobStorage;
import de.tiostitch.blackCat.LoveRun.managers.types.EnemyType;
import de.tiostitch.blackCat.LoveRun.managers.types.States;

import javax.swing.*;
import java.awt.*;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;

public final class GameGraphic
extends JPanel {
    private final int START_X = 25;
    private int appeared_enemies = 0;
    private static java.util.List<IEnemy> load_enemies = new ArrayList<>();;
    private static IEnemy iEnemy = new IEnemy(25, 225, 1, EnemyType.CACTUS);


    public GameGraphic() {
        Timer framesLoad = new Timer(1000/60, actionEvent -> repaint());
        framesLoad.start();

        Timer pontuationUp = new Timer(2000, actionEvent -> {
            GameKeys.getIBlackCat().setPontuation(GameKeys.getIBlackCat().getPontuation()+10);
        });
        pontuationUp.start();

        Timer obstacleSpawn = new Timer(4000, actionEvent -> enemy_select());
        obstacleSpawn.start();
    }

    public static void renew() {
        for (IEnemy enemy : load_enemies) {
            load_enemies.remove(enemy);
        }
        load_enemies.clear();
    }

    public void enemy_select() {
        if (GameKeys.getIBlackCat().getPontuation() >= 250) {
            GameKeys.getIBackground().setState(States.END_GAME);
            return;
        }

        if (appeared_enemies == IMobStorage.enemies.size()-1) {
            return;
        }

        iEnemy = IMobStorage.enemies.get(appeared_enemies);
        appeared_enemies++;

        load_enemies.add(iEnemy);
    }


    @Override
    public void paint(Graphics graphics) {
        Graphics2D g2D = (Graphics2D) graphics;

        final IBackground iBackground = GameKeys.getIBackground();
        final IBlackCat iBlackCat = GameKeys.getIBlackCat();

        g2D.drawImage(iBackground.getState().getIcon().getImage(), 0, 0, null);

        if (GameKeys.getIBlackCat().getPontuation() >= 230) {
            ImageIcon golden_heart = new ImageIcon("src/resources/blackCat/Golden_Reward.gif");
            g2D.drawImage(golden_heart.getImage(), 546, 215, 64, 64, null);
        }

        if (iBackground.getState() == States.RUN_GAME) {

            g2D.setColor(Color.YELLOW);
            g2D.setFont(new Font("BOLD", Font.BOLD, 15));
            g2D.drawString(iBlackCat.getPontuation() + " Pontos", 250, 25);

            if (!load_enemies.isEmpty()) {
                for (IEnemy enemy : load_enemies) {
                    if (enemy == null) continue;

                    enemy.setX(enemy.getX() - enemy.getXSpeed());
                    g2D.drawImage(enemy.getType().getIcon().getImage(), enemy.getX(), enemy.getY(), 64, 64, null);

                    if (collided(iBlackCat, enemy)) {
                        GameKeys.getIBackground().setState(States.START_GAME);
                    }
                }
            }

            g2D.drawImage(iBlackCat.getIcon().getImage(), iBlackCat.getX() + START_X, iBlackCat.getY(), 64, 64, null);
        }
    }

    private boolean collided(IBlackCat cat, IEnemy enemy) {
        boolean collide = false;

        int xEnemy = enemy.getX();
        int yEnemy = enemy.getY();

        int xCat = cat.getX();
        int yCat = cat.getY();

        if (xCat == xEnemy && yCat == yEnemy) {
            collide = true;
        }

        return collide;
    }
}
