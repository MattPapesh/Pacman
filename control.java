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
        translateX();
        translateY();
    }

    void translateX()
    {
        if (io.getDirection() == glob.CONSTANTS.RIGHT)
        {
            glob.PACMAN.PANEL_COORDS.x = glob.PACMAN.PANEL_COORDS.x + 16;
        }
        else if (io.getDirection() == glob.CONSTANTS.LEFT)
        {
            glob.PACMAN.PANEL_COORDS.x = glob.PACMAN.PANEL_COORDS.x - 16;
        }
    }

    void translateY()
    {
        if (io.getDirection() == glob.CONSTANTS.UP)
        {
            glob.PACMAN.PANEL_COORDS.y = glob.PACMAN.PANEL_COORDS.y - 16;
        }
        else if (io.getDirection() == glob.CONSTANTS.DOWN)
        {
            glob.PACMAN.PANEL_COORDS.y = glob.PACMAN.PANEL_COORDS.y + 16;
        }
    }
    
    coords getSpriteCoordsRelativeToSprite(sprite for_conversion, sprite relative_to)
    { 
        int x = for_conversion.PANEL_COORDS.x - relative_to.PANEL_COORDS.x;
        int y = for_conversion.PANEL_COORDS.y - relative_to.PANEL_COORDS.y;

        return new coords(x, y);
    }
}
