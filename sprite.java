import java.awt.image.*;

import javax.imageio.ImageIO;
import java.io.*;

public class sprite 
{
    String SPRITE_DIR = "";
    final String SPRITE_BASE_DIR = "sprites/";
    coords PANEL_COORDS = null; 
    coords STAGE_LAYOUT_COORDS = null;
    BufferedImage SPRITE_B_IMG = null;
    int SPRITE_WIDTH = 0, SPRITE_HEIGHT = 0;
    int PREV_DIRECTION = 0, CURRENT_DIRECTION = 0;     

    public sprite(String file_name, int x, int y)
    {
        SPRITE_DIR = SPRITE_BASE_DIR + file_name;
        STAGE_LAYOUT_COORDS = new coords(0, 0);

        try 
        {
            SPRITE_B_IMG = ImageIO.read(new File(SPRITE_BASE_DIR + file_name));
            SPRITE_WIDTH = SPRITE_B_IMG.getWidth();
            SPRITE_HEIGHT = SPRITE_B_IMG.getHeight();
            PANEL_COORDS = new coords(x - (SPRITE_B_IMG.getWidth()/2), y - (SPRITE_B_IMG.getHeight()/2));
        }
        catch(IOException e)
        {
            PANEL_COORDS = new coords(0, 0);
            System.out.println("The sprite, \"" + file_name + "\"'s BufferedImage member is null and the file cannot be read!!! ");
        }       
    }

    public coords getCenteredCoords()
    {
        return new coords(PANEL_COORDS.x + (SPRITE_WIDTH/2), PANEL_COORDS.y + (SPRITE_HEIGHT/2));
    }

    public coords getChangeInCoords(boolean PANEL, coords relative_to)
    {
        coords for_conversion = null;
        if (PANEL) 
        {
            for_conversion = PANEL_COORDS; 
        }
        else 
        {
            for_conversion = getCenteredCoords(); 
        }

        return new coords(for_conversion.x - relative_to.x, for_conversion.y - relative_to.y); 
    }
}
