import java.awt.event.*;
import basic_fundamentals.*;

public class IO implements KeyListener
{
    private global glob = null;
    private KeyListener inputListener = this;
    private int currentDirection = 0;

    public IO(global glob)
    {
        this.glob = glob; 
    }

    public KeyListener getKeyListener()
    {
        return inputListener;
    }

    private void determineDirection(int currentKeyID)
    {
        if (currentKeyID == glob.CONSTANTS.W || currentKeyID == glob.CONSTANTS.UP_ARROW) {currentDirection = glob.CONSTANTS.UP;}
        else if (currentKeyID == glob.CONSTANTS.S || currentKeyID == glob.CONSTANTS.DOWN_ARROW) {currentDirection = glob.CONSTANTS.DOWN;}
        else if (currentKeyID == glob.CONSTANTS.A || currentKeyID == glob.CONSTANTS.LEFT_ARROW) {currentDirection = glob.CONSTANTS.LEFT;}
        else if (currentKeyID == glob.CONSTANTS.D || currentKeyID == glob.CONSTANTS.RIGHT_ARROW) {currentDirection = glob.CONSTANTS.RIGHT;}
    }

    public int getDirection()
    {
        return currentDirection; 
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        determineDirection(e.getKeyCode());   
    }
    @Override
    public void keyReleased(KeyEvent e)
    {}
    @Override 
    public void keyTyped(KeyEvent e)
    {}
}