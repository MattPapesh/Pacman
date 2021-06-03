import basic_fundamentals.*;

public class control 
{ 
    private IO io = null; 
    private global glob = null;
    boolean once_up = false, once_down = false;

    control(IO io, global glob)
    {
        this.io = io;
        this.glob = glob; 
    }   

    void run()
    {
        translate(glob, io.getDirection(), glob.PACMAN);
    }

    void translate(global global, int direction, sprite sprite)
    {
        sprite.setDirection(direction); 
        translateX(global, direction, getTurningTo(global, sprite, false), sprite);
        translateY(global, direction, getTurningTo(global, sprite, true), sprite);
    }

    boolean getTurningTo(global global, sprite sprite, boolean turning_to_horizontal)
    {
        int[][] parallel_Y_perpendicular_X_direcionts = {global.CONSTANTS.HORIZONTAL_DIRECTIONS, global.CONSTANTS.VERTICAL_DIRECTIONS};
        int current_direction = sprite.getCurrentDirection();
        boolean turning_to = false;
        
            for (int direction = 0; direction < 2; direction++)
            {
                if (current_direction == parallel_Y_perpendicular_X_direcionts[0][direction])
                {
                    turning_to = true; 
                    if (!turning_to_horizontal)
                    {
                        turning_to = (!turning_to);
                    }
                }
            }
    
        return turning_to; 
    }

  

    void translateX(global global, int direction, boolean turn, sprite sprite)
    {
        int x = sprite.getStageLayoutCoordinates().x;
        int y = sprite.getStageLayoutCoordinates().y;
        int delta_x = sprite.getChangeInCoords(false, global.STAGE.getPanelCoordinates()).x - global.CONSTANTS.PANEL_X_DISPLACEMENT;
        if (turn) System.out.println("Turned to X");
 
        if (direction == global.CONSTANTS.RIGHT && x < global.CONSTANTS.STAGE_LAYOUT_MAX_X && global.CONSTANTS.STAGE_LAYOUT[y][x + 1] == 1)
        {
            sprite.getPanelCoordinates().x++;

            if (delta_x != 0  && delta_x/glob.CONSTANTS.STAGE_LAYOUT_SCALE_FACTOR != sprite.getStageLayoutCoordinates().x 
            && delta_x % global.CONSTANTS.STAGE_LAYOUT_SCALE_FACTOR == 0)
            {
                sprite.setStageLayoutCoordinates(x++, y);
            }
        }
        else if (direction == glob.CONSTANTS.LEFT && x > 0 && global.CONSTANTS.STAGE_LAYOUT[y][x - 1] == 1)
        {
            sprite.getPanelCoordinates().x--;

            if (delta_x/glob.CONSTANTS.STAGE_LAYOUT_SCALE_FACTOR != sprite.getStageLayoutCoordinates().x 
            && delta_x % global.CONSTANTS.STAGE_LAYOUT_SCALE_FACTOR == 0)
            {
                sprite.setStageLayoutCoordinates(x--, y);
            }
        }
    }

    void translateY(global global, int direction, boolean turn, sprite sprite)
    {    
        int x = sprite.getStageLayoutCoordinates().x;
        int y = sprite.getStageLayoutCoordinates().y;
        int delta_y = sprite.getChangeInCoords(false, global.STAGE.getPanelCoordinates()).y - global.CONSTANTS.PANEL_Y_DISPLACEMENT;
        if (turn) System.out.println("Turned to Y");
        if (direction == glob.CONSTANTS.UP && y > 0 && global.CONSTANTS.STAGE_LAYOUT[y-1][x] == 1)
        {
           sprite.getPanelCoordinates().y--;

           if (delta_y/glob.CONSTANTS.STAGE_LAYOUT_SCALE_FACTOR != sprite.getStageLayoutCoordinates().y 
           && delta_y % glob.CONSTANTS.STAGE_LAYOUT_SCALE_FACTOR == 0)
           {
               sprite.getStageLayoutCoordinates().y--; 
           }
        }
        else if (direction == glob.CONSTANTS.DOWN && y < global.CONSTANTS.STAGE_LAYOUT_MAX_Y && global.CONSTANTS.STAGE_LAYOUT[y+1][x] == 1)
        {
            sprite.getPanelCoordinates().y++;

            if (delta_y != 0 && delta_y/glob.CONSTANTS.STAGE_LAYOUT_SCALE_FACTOR != sprite.getStageLayoutCoordinates().y 
            && delta_y % glob.CONSTANTS.STAGE_LAYOUT_SCALE_FACTOR == 0)
            {
                sprite.getStageLayoutCoordinates().y++; 
            }
        }
        
    }
}
