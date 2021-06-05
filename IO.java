import java.awt.event.*;

public class IO implements KeyListener
{
    private KeyListener inputListener = this;
    private final int W, A, S, D, UP_ARROW, DOWN_ARROW, LEFT_ARROW, RIGHT_ARROW, UP, DOWN, LEFT, RIGHT; 
    private int direction = 0;

    public int getDirection(){return direction; } 

    public IO(int W, int A, int S, int D, int UP_ARROW, int DOWN_ARROW, int LEFT_ARROW, int RIGHT_ARROW, int UP, int DOWN, int LEFT, int RIGHT)
    {
        this.W = W; this.A = A; this.S = S; this.D = D;
        this.UP_ARROW = UP_ARROW; this.DOWN_ARROW = DOWN_ARROW; this.LEFT_ARROW = LEFT_ARROW; this.RIGHT_ARROW = RIGHT_ARROW;
        this.UP = UP; this.DOWN = DOWN; this.LEFT = LEFT; this.RIGHT = RIGHT; 
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
        if (currentKeyID == W || currentKeyID == UP_ARROW) {direction = UP; }
        else if (currentKeyID == S || currentKeyID == DOWN_ARROW) {direction = DOWN; }
        else if (currentKeyID == A || currentKeyID == LEFT_ARROW) {direction = LEFT; }
        else if (currentKeyID == D || currentKeyID == RIGHT_ARROW) {direction = RIGHT; }
    }
}