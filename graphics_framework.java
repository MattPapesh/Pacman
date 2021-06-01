import javax.swing.*;
import java.awt.*;

public class graphics_framework extends JPanel
{
    private global glob = null;
    private control control = null;

    public graphics_framework(control control, global glob)
    {
        this.control = control;
        this.glob = glob; 
    }

    public void paintComponent(Graphics graphics) // what JPanel constantly calls to create JFrame graphics
    { 
        graphics = prepareComponent(graphics);
        displayGame(graphics);
    }

    void repaintPeriodicRate()
    {
        try {Thread.sleep(glob.CONSTANTS.PERIODIC_DELAY);} 
        catch(InterruptedException e){}
    }

    Graphics prepareComponent(Graphics graphics)
    {
        control.run(); 
        super.paintComponent(graphics);
        super.repaint();
        super.setBackground(glob.CONSTANTS.DEFAULT_BACKGROUND_COLOR);
        repaintPeriodicRate();

        return graphics; 
    }

    void displayGame(Graphics graphics)
    {
        for (int i = 0; i < glob.CONSTANTS.NUM_OF_SPRITES; i++)
        {
            graphics.drawImage
            (
                glob.sprites[i].SPRITE_B_IMG, glob.sprites[i].PANEL_COORDS.x, glob.sprites[i].PANEL_COORDS.y, null
            );
        } 
    }
}