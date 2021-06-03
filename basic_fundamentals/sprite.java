package basic_fundamentals;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;

public class sprite 
{
    String SPRITE_DIR = "";
    int sprite_width = 0, sprite_height = 0;
    BufferedImage sprite_b_img= null;
    final String SPRITE_BASE_DIR = "assets/sprites/";
    coords panel_coords = null; 
    coords stage_layout_coords = null;
    int previous_direction = 0;
    int current_direction = 0;     

    public coords getPanelCoordinates(){return panel_coords; }
    public coords getStageLayoutCoordinates(){return stage_layout_coords; }
    public int getCurrentDirection(){return current_direction; }
    public int getPreviousDirection(){return previous_direction; }
    public BufferedImage getBufferedImage(){return sprite_b_img; }
    public void setDirection(int current_direction) {previous_direction = this.current_direction; this.current_direction = current_direction; }
    public void setStageLayoutCoordinates(int x, int y){ stage_layout_coords.x = x; stage_layout_coords.y = y; } 

    public sprite(String file_name, int x, int y)
    {
        updateBufferedImage(file_name);

        stage_layout_coords = new coords(0, 0);  
        panel_coords = new coords(x - (sprite_width/2), y - (sprite_height/2));
    }

    public void updateBufferedImage(String file_name)
    {
        SPRITE_DIR = SPRITE_BASE_DIR + file_name;

        try 
        {
            sprite_b_img = ImageIO.read(new File(SPRITE_BASE_DIR + file_name));
            sprite_width = sprite_b_img.getWidth();
            sprite_height = sprite_b_img.getHeight();
        }
        catch(IOException e)
        {
            System.out.println("The sprite, \"" + file_name + "\"'s BufferedImage member may be null and the file cannot be read!!! ");
        }
    }

    public coords getCenteredCoords()
    {
        return new coords(panel_coords.x + (sprite_width/2), panel_coords.y + (sprite_height/2));
    }

    public coords getChangeInCoords(boolean PANEL, coords relative_to)
    {
        coords for_conversion = null;
        if (PANEL) 
        {
            for_conversion = panel_coords; 
        }
        else 
        {
            for_conversion = getCenteredCoords(); 
        }

        return new coords(for_conversion.x - relative_to.x, for_conversion.y - relative_to.y); 
    }
}
