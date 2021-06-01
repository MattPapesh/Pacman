public class control
{
    private IO io = null; 
    private global glob = null;

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
        sprite.PREV_DIRECTION = sprite.CURRENT_DIRECTION;
        sprite.CURRENT_DIRECTION = direction; 
        translateX(global, direction, sprite);
        translateY(global, direction, sprite);
    }

    void translateX(global global, int direction, sprite sprite)
    {
        int x = sprite.STAGE_LAYOUT_COORDS.x, y = sprite.STAGE_LAYOUT_COORDS.y;
        //int delta_x = sprite.getChangeInCoords(false, global.STAGE.PANEL_COORDS).x - global.CONSTANTS.PANEL_X_DISPLACEMENT;

        if (direction == global.CONSTANTS.RIGHT && x < global.CONSTANTS.STAGE_LAYOUT_MAX_X && global.CONSTANTS.STAGE_LAYOUT[y][x + 1] == 1)
        {
            sprite.PANEL_COORDS.x = sprite.PANEL_COORDS.x + global.CONSTANTS.STAGE_LAYOUT_SCALE_FACTOR;
           // sprite.PANEL_COORDS.x++;
            //if (delta_x % global.CONSTANTS.STAGE_LAYOUT_SCALE_FACTOR == 0)
            {
                sprite.STAGE_LAYOUT_COORDS.x++;
            }
        }
        else if (direction == glob.CONSTANTS.LEFT && x > 0 && global.CONSTANTS.STAGE_LAYOUT[y][x - 1] == 1)
        {
            sprite.PANEL_COORDS.x = sprite.PANEL_COORDS.x - global.CONSTANTS.STAGE_LAYOUT_SCALE_FACTOR;
           // sprite.PANEL_COORDS.x--;
           // if (delta_x % global.CONSTANTS.STAGE_LAYOUT_SCALE_FACTOR == 0)
            {
                sprite.STAGE_LAYOUT_COORDS.x--; 
            }
        }
    }

    void translateY(global global, int direction, sprite sprite)
    {   
        int x = sprite.STAGE_LAYOUT_COORDS.x;
        int y = sprite.STAGE_LAYOUT_COORDS.y;
        int delta_y = sprite.getChangeInCoords(false, global.STAGE.PANEL_COORDS).y - global.CONSTANTS.PANEL_Y_DISPLACEMENT;
//System.out.println("value: " + delta_y / global.CONSTANTS.STAGE_LAYOUT_SCALE_FACTOR + "     layout_y: " + sprite.STAGE_LAYOUT_COORDS.y);
        if (direction == glob.CONSTANTS.UP && y > 0 && global.CONSTANTS.STAGE_LAYOUT[y - 0][x] == 1)
        {
            //sprite.PANEL_COORDS.y = sprite.PANEL_COORDS.y - global.CONSTANTS.STAGE_LAYOUT_SCALE_FACTOR;
            sprite.PANEL_COORDS.y--;
            if (delta_y / global.CONSTANTS.STAGE_LAYOUT_SCALE_FACTOR != sprite.STAGE_LAYOUT_COORDS.y)
            {
                sprite.STAGE_LAYOUT_COORDS.y--; 
            }
        }
        else if (direction == glob.CONSTANTS.DOWN && y < global.CONSTANTS.STAGE_LAYOUT_MAX_Y && global.CONSTANTS.STAGE_LAYOUT[y + 0][x] == 1)
        {
            //sprite.PANEL_COORDS.y = sprite.PANEL_COORDS.y + global.CONSTANTS.STAGE_LAYOUT_SCALE_FACTOR;
            sprite.PANEL_COORDS.y++;
            if (delta_y / global.CONSTANTS.STAGE_LAYOUT_SCALE_FACTOR == sprite.STAGE_LAYOUT_COORDS.y)
            {
                sprite.STAGE_LAYOUT_COORDS.y++; 
            }
        }
    }
}
