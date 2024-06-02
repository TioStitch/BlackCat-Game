package de.tiostitch.blackCat.LoveRun.managers;

import de.tiostitch.blackCat.LoveRun.managers.types.EnemyType;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public final class IMobStorage {

    public static final List<IEnemy> enemies = new ArrayList<>();
    static {
        enemies.add(new IEnemy(600, 200, 1, EnemyType.CACTUS));
        enemies.add(new IEnemy(600, 225, 1, EnemyType.CACTUS));
        enemies.add(new IEnemy(600, 200, 1, EnemyType.CACTUS));

        enemies.add(new IEnemy(600, 225, 1, EnemyType.CACTUS));
        enemies.add(new IEnemy(600, 200, 1, EnemyType.CACTUS));

        enemies.add(new IEnemy(600, 225, 1, EnemyType.FLOOR));
        enemies.add(new IEnemy(600, 200, 1, EnemyType.FLOOR));
        enemies.add(new IEnemy(600, 225, 1, EnemyType.FLOOR));

        enemies.add(new IEnemy(600, 200, 1, EnemyType.BACTERY));
        enemies.add(new IEnemy(600, 225, 1, EnemyType.BACTERY));
        enemies.add(new IEnemy(600, 200, 1, EnemyType.BACTERY));
        enemies.add(new IEnemy(600, 225, 1, EnemyType.BACTERY));
    }

    public static void renew() {
        enemies.clear();

        enemies.add(new IEnemy(600, 200, 1, EnemyType.CACTUS));
        enemies.add(new IEnemy(600, 225, 1, EnemyType.CACTUS));
        enemies.add(new IEnemy(600, 200, 1, EnemyType.CACTUS));

        enemies.add(new IEnemy(600, 225, 1, EnemyType.CACTUS));
        enemies.add(new IEnemy(600, 200, 1, EnemyType.CACTUS));

        enemies.add(new IEnemy(600, 225, 1, EnemyType.FLOOR));
        enemies.add(new IEnemy(600, 200, 1, EnemyType.FLOOR));
        enemies.add(new IEnemy(600, 225, 1, EnemyType.FLOOR));

        enemies.add(new IEnemy(600, 200, 1, EnemyType.BACTERY));
        enemies.add(new IEnemy(600, 225, 1, EnemyType.BACTERY));
        enemies.add(new IEnemy(600, 200, 1, EnemyType.BACTERY));
        enemies.add(new IEnemy(600, 225, 1, EnemyType.BACTERY));
    }
}
