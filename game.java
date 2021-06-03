import javax.swing.*;
import basic_fundamentals.*;

public class game
{
    private global glob = new global(); 
    private JFrame game_frame = new JFrame();
    private IO io = new IO(glob);
    private control control = new control(io, glob);
    private graphics_framework graphics = new graphics_framework(control, glob);

    public game()
    {
        game_frame.setSize(glob.CONSTANTS.FRAME_BORDER_X, glob.CONSTANTS.FRAME_BORDER_Y);
        game_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game_frame.add(graphics);
        game_frame.setVisible(true);
        game_frame.addKeyListener(io.getKeyListener());    
    }

}
