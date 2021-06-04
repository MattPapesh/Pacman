import javax.swing.*;

import fundamentals.*;

public class game
{
    private constants C = new constants(); 
    private JFrame game_frame = new JFrame();
    private IO io = new IO(C.W, C.A, C.S, C.D, C.UP_ARROW, C.DOWN_ARROW, C.LEFT_ARROW, C.RIGHT_ARROW);
    private control control = new control(io, C.LAYOUT, C.LAYOUT_SCALE_FACTOR, C.LAYOUT_MAX_X, C.LAYOUT_MAX_Y, C.PANEL_X_DISPLACEMENT, C.PANEL_Y_DISPLACEMENT);
    private graphics_framework graphics = new graphics_framework(control, C.PERIODIC_UPDATE_DELAY, C.DEFAULT_BACKGROUND_COLOR, C.sprites, C.NUM_OF_SPRITES);

    public game()
    {
        game_frame.setSize(C.FRAME_BORDER_X, C.FRAME_BORDER_Y);
        game_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game_frame.add(graphics);
        game_frame.setVisible(true);
        game_frame.addKeyListener(io.getKeyListener());    
    }

}
