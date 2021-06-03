package basic_fundamentals;
import java.awt.*;

public class global
{
    public class constants
    {
        public final int PERIODIC_DELAY = 10; //Prgram updates this often in millis 

        public final int FRAME_BORDER_X = 800; // Border size for the window
        public final int FRAME_BORDER_Y = 800;    

        public final Color DEFAULT_BACKGROUND_COLOR = Color.BLACK; // Defualt 

        public final int W = 87, UP_ARROW = 38;
        public final int A = 65, LEFT_ARROW = 37;
        public final int S = 83, DOWN_ARROW = 40;
        public final int D = 68, RIGHT_ARROW = 39;
        public final int RESET = 82;

        public final int RIGHT = 1, DOWN = 2, LEFT = 3, UP = 4, IDLE = 0;
        public final int[] HORIZONTAL_DIRECTIONS = {RIGHT, LEFT}, VERTICAL_DIRECTIONS = {UP, DOWN};
    
        public final String SPRITE_BASE_DIR = "sprites/";
        public final int NUM_OF_SPRITES = 2; 

        public final int STAGE_LAYOUT_SCALE_FACTOR = 16;
        public final int STAGE_LAYOUT_MAX_X = 25, STAGE_LAYOUT_MAX_Y = 28; 
        public final int PANEL_X_DISPLACEMENT = 24, PANEL_Y_DISPLACEMENT = 24;

        public final int[][] STAGE_LAYOUT = 
        {
            {1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1},
            {1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1},
            {1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1},
            {1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1},
            {1,1,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,1},
            {0,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,1,1,1,1,1,1,1,1,1,1,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0},
            {1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1},
            {0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,1,1,1,1,1,1,1,1,1,1,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0},
            {1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1},
            {1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1},
            {1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1},
            {0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0},
            {0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0},
            {1,1,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,1},
            {1,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
        }; 
    }
    
    public final constants CONSTANTS = new constants();

    public final sprite STAGE = new sprite("stage_scaled.png", CONSTANTS.FRAME_BORDER_X/2, CONSTANTS.FRAME_BORDER_Y/2);
    public final sprite PACMAN = new sprite("pacman.png", STAGE.getPanelCoordinates().x + CONSTANTS.PANEL_X_DISPLACEMENT, STAGE.getPanelCoordinates().y + CONSTANTS.PANEL_Y_DISPLACEMENT);

    public sprite[] sprites = {STAGE, PACMAN};

    
}
