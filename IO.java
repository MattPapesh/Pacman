import java.awt.event.*;

public class IO implements KeyListener
{
    private KeyListener inputListener = this;
    private final int W, A, S, D, UP_ARROW, DOWN_ARROW, LEFT_ARROW, RIGHT_ARROW;
    private boolean up = false, down = false, left = false, right = false; 

    public boolean getDirectingUp(){return up; }
    public boolean getDirectingDown(){return down; }
    public boolean getDirectingLeft(){return left; }
    public boolean getDirectiongRight(){return right; }

    public IO(int W, int A, int S, int D, int UP_ARROW, int DOWN_ARROW, int LEFT_ARROW, int RIGHT_ARROW)
    {
        this.W = W; this.A = A; this.S = S; this.D = D;
        this.UP_ARROW = UP_ARROW; this.DOWN_ARROW = DOWN_ARROW; this.LEFT_ARROW = LEFT_ARROW; this.RIGHT_ARROW = RIGHT_ARROW;
    }

    public KeyListener getKeyListener()
    {
        return inputListener;
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

    private void determineDirection(int currentKeyID)
    {
        up = false; down = false; left = false; right = false;

        if (currentKeyID == W || currentKeyID == UP_ARROW) {up = true; }
        else if (currentKeyID == S || currentKeyID == DOWN_ARROW) {down = true; }
        else if (currentKeyID == A || currentKeyID == LEFT_ARROW) {left = true; }
        else if (currentKeyID == D || currentKeyID == RIGHT_ARROW) {right = true; }
    }
}