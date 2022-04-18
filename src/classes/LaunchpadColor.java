package classes;

import java.awt.Color;
import java.util.*;

public class LaunchpadColor {

   public static final Color TRANSPARENT = new Color(255, 255, 255);
   public static final Color GREEN_LOW = new Color(0, 85, 0);
   public static final Color GREE_MEDIUM = new Color(0, 170, 0);
   public static final Color GREE_FULL = new Color(0, 255, 0);
   public static final Color RED_LOW = new Color(85, 0, 0);
   public static final Color ORANGE_1 = new Color(85, 84, 0);
   public static final Color ORANGE_2 = new Color(84, 170, 0);
   public static final Color GREEN_LIGHT = new Color(85, 255, 0);
   public static final Color RED_MEDIUM = new Color(170, 0, 0);
   public static final Color ORANGE_4 = new Color(170, 86, 0);
   public static final Color ORANGE_5 = new Color(171, 170, 0);
   public static final Color YELLOW = new Color(170, 255, 0);
   public static final Color RED_FULL = new Color(255, 0, 0);
   public static final Color ORANGE_7 = new Color(255, 85, 0);
   public static final Color ORANGE = new Color(255, 170, 0);
   public static final Color ORANGE_LIGHT = new Color(255, 255, 0);

   public static final int[] colorsInt = {12, 28, 44, 60,
                                          13, 29, 45, 61,
                                          14, 30, 45, 62,
                                          15, 31, 47, 63};

   public static final ArrayList <Color> colors = new ArrayList<Color>(Arrays.asList(TRANSPARENT,
                                                      GREEN_LOW,
                                                      GREE_MEDIUM,
                                                      GREE_FULL,
                                                      RED_LOW,
                                                      ORANGE_1,
                                                      ORANGE_2,
                                                      GREEN_LIGHT,
                                                      RED_MEDIUM,
                                                      ORANGE_4,
                                                      ORANGE_5,
                                                      YELLOW,
                                                      RED_FULL,
                                                      ORANGE_7,
                                                      ORANGE,
                                                      ORANGE_LIGHT));
}
