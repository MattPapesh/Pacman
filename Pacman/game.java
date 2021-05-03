import javax.swing.*;

public class game
{
    private constants CONST = new constants(); 
    private JFrame game_frame = new JFrame();
    private IO io = new IO(CONST);
    private control control = new control(io, CONST);
    private graphics_framework graphics = new graphics_framework(control, CONST);

    public game()
    {
        game_frame.setSize(CONST.FRAME_BORDER_X,CONST.FRAME_BORDER_Y);
        game_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game_frame.add(graphics);
        game_frame.setVisible(true);
        game_frame.addKeyListener(io.getKeyListener());    
    }

}
