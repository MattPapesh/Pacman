import assets.*;
import fundamentals.*;

public class control 
{ 
    private IO io = null; 
    private pacman pacman = null;
    private final int LAYOUT_SCALE_FACTOR;
    private final int[][] LAYOUT;
    private final int LAYOUT_MAX_X, LAYOUT_MAX_Y;
    private final int PANEL_X_DISPLACEMENT, PANEL_Y_DISPLACEMENT; 
    
    control(IO io, int[][] LAYOUT, int LAYOUT_SCALE_FACTOR, int LAYOUT_MAX_X, int LAYOUT_MAX_Y, int PANEL_X_DISPLACEMENT, int PANEL_Y_DISPLACEMENT)
    {
        this.io = io;
        this.LAYOUT = LAYOUT; this.LAYOUT_SCALE_FACTOR = LAYOUT_SCALE_FACTOR; this.LAYOUT_MAX_X = LAYOUT_MAX_X; this.LAYOUT_MAX_Y = LAYOUT_MAX_Y;
        this.PANEL_X_DISPLACEMENT = PANEL_X_DISPLACEMENT; this.PANEL_Y_DISPLACEMENT = PANEL_Y_DISPLACEMENT;
        
    }   

    void execute()
    {
       // pacman = new pacman(glob, glob.PACMAN); 
        pacman.toggleAbility(true);
        pacman.execute(); 
    }


    void translateX(constants global, boolean turn, sprite sprite)
    {
        int x = sprite.getLayoutCoordinates().x;
        int y = sprite.getLayoutCoordinates().y;
        int delta_x = sprite.getChangeInCoords(false, global.STAGE.getPanelCoordinates()).x - PANEL_X_DISPLACEMENT;
        if (turn) System.out.println("Turned to X");
 
        if (io.getDirectiongRight() && x < LAYOUT_MAX_X && LAYOUT[y][x + 1] == 1)
        {
            sprite.getPanelCoordinates().x++;

            if (delta_x != 0  && delta_x/LAYOUT_SCALE_FACTOR != sprite.getLayoutCoordinates().x 
            && delta_x % LAYOUT_SCALE_FACTOR == 0)
            {
                sprite.setLayoutCoordinates(x++, y);
            }
        }
        else if (io.getDirectingLeft() && x > 0 && LAYOUT[y][x - 1] == 1)
        {
            sprite.getPanelCoordinates().x--;

            if (delta_x/LAYOUT_SCALE_FACTOR != sprite.getLayoutCoordinates().x 
            && delta_x % LAYOUT_SCALE_FACTOR == 0)
            {
                sprite.setLayoutCoordinates(x--, y);
            }
        }
    }

    void translateY(constants global, boolean turn, sprite sprite)
    {    
        int x = sprite.getLayoutCoordinates().x;
        int y = sprite.getLayoutCoordinates().y;
        int delta_y = sprite.getChangeInCoords(false, global.STAGE.getPanelCoordinates()).y - PANEL_Y_DISPLACEMENT;
        if (turn) System.out.println("Turned to Y");
        if (io.getDirectingUp() && y > 0 && LAYOUT[y-1][x] == 1)
        {
           sprite.getPanelCoordinates().y--;

           if (delta_y/LAYOUT_SCALE_FACTOR != sprite.getLayoutCoordinates().y 
           && delta_y % LAYOUT_SCALE_FACTOR == 0)
           {
               sprite.getLayoutCoordinates().y--; 
           }
        }
        else if (io.getDirectingDown() && y < LAYOUT_MAX_Y && LAYOUT[y+1][x] == 1)
        {
            sprite.getPanelCoordinates().y++;

            if (delta_y != 0 && delta_y/LAYOUT_SCALE_FACTOR != sprite.getLayoutCoordinates().y 
            && delta_y % LAYOUT_SCALE_FACTOR == 0)
            {
                sprite.getLayoutCoordinates().y++; 
            }
        }
        
    }
}
