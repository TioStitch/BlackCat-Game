package de.tiostitch.blackCat.LoveRun;

import de.tiostitch.blackCat.LoveRun.managers.IBackground;
import de.tiostitch.blackCat.LoveRun.managers.IBlackCat;
import de.tiostitch.blackCat.LoveRun.managers.IMobStorage;
import de.tiostitch.blackCat.LoveRun.managers.types.States;
import lombok.Getter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class GameKeys
implements KeyListener {

    @Getter private static IBlackCat iBlackCat = new IBlackCat();
    @Getter private static IBackground iBackground = new IBackground();

    @Getter public static GameKeys instance;

    public GameKeys() {
        instance = this;
        iBackground.setState(States.START_GAME);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {


    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (iBackground.getState()) {
            case START_GAME:
                if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
                    iBlackCat = new IBlackCat();
                    iBackground = new IBackground();
                    IMobStorage.renew();

                    iBackground.setState(States.RUN_GAME);
                }
                break;

            case RUN_GAME:

                switch (keyEvent.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        iBlackCat.setY(200);
                        break;
                    case KeyEvent.VK_DOWN:
                        iBlackCat.setY(225);
                        break;
                }

                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
