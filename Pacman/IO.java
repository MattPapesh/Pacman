import java.awt.event.*;

public class IO implements KeyListener
{
    private constants CONST = null;
    private KeyListener inputListener = this;
    private int currentDirection = 0;

    public IO(constants CONST)
    {
        this.CONST = CONST; 
    }

    public KeyListener getKeyListener()
    {
        return inputListener;
    }

    private void determineDirection(int currentKeyID)
    {
        if (currentKeyID == CONST.W || currentKeyID == CONST.UP_ARROW) {currentDirection = CONST.UP;}
        else if (currentKeyID == CONST.S || currentKeyID == CONST.DOWN_ARROW) {currentDirection = CONST.DOWN;}
        else if (currentKeyID == CONST.A || currentKeyID == CONST.LEFT_ARROW) {currentDirection = CONST.LEFT;}
        else if (currentKeyID == CONST.D || currentKeyID == CONST.RIGHT_ARROW) {currentDirection = CONST.RIGHT;}
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