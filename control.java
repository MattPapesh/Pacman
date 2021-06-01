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
        translateX(glob, io.getDirection(), glob.PACMAN);
        translateY(glob, io.getDirection(), glob.PACMAN);
    }

    void translateX(global global, int direction, sprite sprite)
    {
        int x = sprite.STAGE_LAYOUT_COORDS.x; 
        int y = sprite.STAGE_LAYOUT_COORDS.y;
        //int delta_x = getChangeInCoords(sprite.getCenteredCoords(), global.STAGE.PANEL_COORDS).x - global.CONSTANTS.PANEL_X_DISPLACEMENT;

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
        //int delta_y = getChangeInCoords(sprite.getCenteredCoords(), global.STAGE.PANEL_COORDS).y - global.CONSTANTS.PANEL_Y_DISPLACEMENT;

        if (direction == glob.CONSTANTS.UP && y > 0 && global.CONSTANTS.STAGE_LAYOUT[y - 1][x] == 1)
        {
            sprite.PANEL_COORDS.y = sprite.PANEL_COORDS.y - global.CONSTANTS.STAGE_LAYOUT_SCALE_FACTOR;
            //sprite.PANEL_COORDS.y--;
            //if (delta_y % global.CONSTANTS.STAGE_LAYOUT_SCALE_FACTOR == 0)
            {
                sprite.STAGE_LAYOUT_COORDS.y--; 
            }
        }
        else if (direction == glob.CONSTANTS.DOWN && y < global.CONSTANTS.STAGE_LAYOUT_MAX_Y && global.CONSTANTS.STAGE_LAYOUT[y + 1][x] == 1)
        {
            sprite.PANEL_COORDS.y = sprite.PANEL_COORDS.y + global.CONSTANTS.STAGE_LAYOUT_SCALE_FACTOR;
            //sprite.PANEL_COORDS.y++;
            //if (delta_y % global.CONSTANTS.STAGE_LAYOUT_SCALE_FACTOR == 0)
            {
                sprite.STAGE_LAYOUT_COORDS.y++; 
            }
        }
    }
    
    coords getChangeInCoords(coords for_conversion, coords relative_to)
    { 
        int x = for_conversion.x - relative_to.x;
        int y = for_conversion.y - relative_to.y;

        return new coords(x, y);
    }
}
