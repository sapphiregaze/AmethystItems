package sapphiregaze.amethystitems.util;

import java.util.Random;

public class Utility {
    public static boolean percentChance(int chance) {
        return new Random().nextInt(100) < chance;
    }
}
