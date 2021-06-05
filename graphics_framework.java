import javax.swing.*;

import fundamentals.*;

import java.awt.*;

public class graphics_framework extends JPanel
{
    private control control = null;
    private final int PERIODIC_UPDATE_DELAY;
    private final Color DEFAULT_BACKGROUND_COLOR;
    private sprite[] sprites = null;
    private final int NUM_OF_SPRITES;  

    public graphics_framework(control control, int PERIODIC_UPDATE_DELAY, Color DEFUALT_BACKGROUND_COLOR, sprite[] sprites, int NUM_OF_SPRITES)
    {
        this.control = control;
        this.PERIODIC_UPDATE_DELAY = PERIODIC_UPDATE_DELAY;
        this.DEFAULT_BACKGROUND_COLOR = DEFUALT_BACKGROUND_COLOR;
        this.sprites = sprites; 
        this.NUM_OF_SPRITES = NUM_OF_SPRITES;
    
    }

    public void paintComponent(Graphics graphics) // what JPanel constantly calls to create JFrame graphics
    { 
        graphics = prepareComponent(graphics);
        displayGame(graphics);
    }

    void repaintPeriodicRate()
    {
        try {Thread.sleep(PERIODIC_UPDATE_DELAY);} 
        catch(InterruptedException e){}
    }

    Graphics prepareComponent(Graphics graphics)
    {
        control.execute(); 
        super.paintComponent(graphics);
        super.repaint();
        super.setBackground(DEFAULT_BACKGROUND_COLOR);
        repaintPeriodicRate();

        return graphics; 
    }

    void displayGame(Graphics graphics)
    {
        for (int i = 0; i < NUM_OF_SPRITES; i++)
        {
            graphics.drawImage
            (
                sprites[i].getBufferedImage(), sprites[i].getPanelCoordinates().x, sprites[i].getPanelCoordinates().y, null
            );
        } 
    }
}