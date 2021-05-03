//import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class graphics_framework extends JPanel
{
    private constants CONST = null;
    private control control = null;


    public graphics_framework(control control, constants CONST)
    {
        this.control = control;
        this.CONST = CONST; 
    }

    public void paintComponent(Graphics graphics) // what JPanel constantly calls to create JFrame graphics
    { 
        graphics = prepareComponent(graphics);
        displayGame(graphics);
    }

    void repaintPeriodicRate()
    {
        try {Thread.sleep(CONST.PERIODIC_DELAY);} 
        catch(InterruptedException e){}
    }

    Graphics prepareComponent(Graphics graphics)
    {
        control.run(); 
        super.paintComponent(graphics);
        super.repaint();
        super.setBackground(CONST.DEFAULT_BACKGROUND_COLOR);
        repaintPeriodicRate();

        this.control.setBufferedImage(getSpriteBufferedImage(this.CONST, this.CONST.PACMAN_SPRITES_INDEX), 
        getSpriteBufferedImage(this.CONST, this.CONST.STAGE_SPRITE_INDEX));

        return graphics; 
    }

    void displayGame(Graphics graphics)
    {
        Image current_image = null;
        String current_sprite_dir = "";
        File current_file = null;
        int current_x = 0, current_y = 0;

        for (int i = 0; i < CONST.NUM_OF_SPRITES; i++)
        {
            current_sprite_dir = CONST.SPRITE_BASE_DIR + (CONST.sprites[i]).SPRITE_DIR;
            current_file = new File(current_sprite_dir);
            current_x = (CONST.sprites[i]).PANEL_COORDS.x;
            current_y = (CONST.sprites[i]).PANEL_COORDS.y;

            try {current_image = ImageIO.read(current_file);}
            catch(IOException e) {}

            graphics.drawImage(current_image, current_x, current_y, null);
        }     
    }

    BufferedImage getSpriteBufferedImage(constants CONST, int sprite_index)
    {
        BufferedImage temp_img = null;
        String temp_sprite_dir = CONST.SPRITE_BASE_DIR + (CONST.sprites[sprite_index]).SPRITE_DIR;
        File temp_file = new File(temp_sprite_dir);
        
        try{temp_img = ImageIO.read(temp_file);}
        catch(IOException e) {}

        return temp_img;
    }
}