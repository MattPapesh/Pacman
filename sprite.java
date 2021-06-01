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
    int SPRITE_WIDTH = 0;
    int SPRITE_HEIGHT = 0;    

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
}
