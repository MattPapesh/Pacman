public class constants 
{
    final int PERIODIC_DELAY = 5; //Prgram updates this often in millis 

    final int FRAME_BORDER_X = 800; // Border size for the window
    final int FRAME_BORDER_Y = 800;    

    final java.awt.Color DEFAULT_BACKGROUND_COLOR = java.awt.Color.BLACK; // Defualt 

    final int W = 87, UP_ARROW = 38;
    final int A = 65, LEFT_ARROW = 37;
    final int S = 83, DOWN_ARROW = 40;
    final int D = 68, RIGHT_ARROW = 39;

    final int RIGHT = 1, DOWN = 2, LEFT = 3, UP = 4, IDLE = 0;
    
    final String SPRITE_BASE_DIR = "sprites/";
    final int NUM_OF_SPRITES = 2; 
    final int PACMAN_SPRITES_INDEX = 1;
    final int STAGE_SPRITE_INDEX = 0; 

    final sprite STAGE = new sprite("stage.png", 517, 577, FRAME_BORDER_X/2, FRAME_BORDER_Y/2);
    final sprite PACMAN = new sprite("pacman.png", 28, 28, FRAME_BORDER_X/2, FRAME_BORDER_Y/2);

    sprite[] sprites = {STAGE, PACMAN};

    
}
