import java.awt.image.*;
import java.awt.*;

public class control 
{
    private IO io = null; 
    private constants CONST = null;
    ///private BufferedImage pacman_b_img = null; 
    private BufferedImage stage_b_img = null;
    private Color color = null;

    control(IO io, constants CONST)
    {
        this.io = io;
        this.CONST = CONST; 
    }

    void setBufferedImage(BufferedImage pacman_b_img, BufferedImage stage_b_img)
    {
       // this.pacman_b_img = pacman_b_img;  
        this.stage_b_img = stage_b_img;
    }

    void run()
    {
        translateX();
        translateY();

        if (stage_b_img != null)
        {
            coords temp = getSpriteCoordsRelativeToSprite(CONST.sprites[CONST.PACMAN_SPRITES_INDEX], CONST.sprites[CONST.STAGE_SPRITE_INDEX]);
            color = new Color(stage_b_img.getRGB(temp.x, temp.y));
            System.out.println(color.getBlue());
        }
    }
    
    void translateX()
    {
        if (io.getDirection() == CONST.RIGHT)
        {
            CONST.PACMAN.PANEL_COORDS.x++; 
        }
        else if (io.getDirection() == CONST.LEFT)
        {
            CONST.PACMAN.PANEL_COORDS.x--;
        }
    }

    void translateY()
    {
        if (io.getDirection() == CONST.UP)
        {
            CONST.PACMAN.PANEL_COORDS.y--;
        }
        else if (io.getDirection() == CONST.DOWN)
        {
            CONST.PACMAN.PANEL_COORDS.y++;
        }
    }

    coords getSpriteCoordsRelativeToSprite(sprite for_conversion, sprite relative_to)
    { 
        int x = for_conversion.PANEL_COORDS.x - relative_to.PANEL_COORDS.x;
        int y = for_conversion.PANEL_COORDS.y - relative_to.PANEL_COORDS.y;

        if (x >= 0 && y >= 0 && x < relative_to.SPRITE_WIDTH && y < relative_to.SPRITE_HEIGHT)
        {
            return new coords(x, y);
        }
        
        return new coords(0, 0);
    }

  /*  bool enableRightwardTranslation()
    {

    }

    bool enableLeftwardTranslation()
    {

    }

    bool enableUpwardTranslation()
    {

    }

    bool enableDownwardTranslation()
    {

    }*/
}
