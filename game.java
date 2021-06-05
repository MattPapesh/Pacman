import javax.swing.*;
import assets.pacman;
import fundamentals.*;

public class game
{
    private constants C = new constants(); 

    private sprite stage_sprite = new sprite("stage_scaled.png", C.FRAME_BORDER_X/2, C.FRAME_BORDER_Y/2);
    private sprite pacman_sprite = new sprite("pacman.png", stage_sprite.getPanelCoordinates().x + C.PANEL_X_DISPLACEMENT, stage_sprite.getPanelCoordinates().y + C.PANEL_Y_DISPLACEMENT);
    public sprite[] sprites = {stage_sprite, pacman_sprite};

    private pacman pacman_asset = new pacman(C.LAYOUT, C.LAYOUT_MAX_X, C.LAYOUT_MAX_Y, C.HORIZONTAL_DIRECTIONS, C.VERTICAL_DIRECTIONS, C.PANEL_X_DISPLACEMENT, C.PANEL_Y_DISPLACEMENT, pacman_sprite, stage_sprite);

    private JFrame game_frame = new JFrame();
    private IO io = new IO(C.W, C.A, C.S, C.D, C.UP_ARROW, C.DOWN_ARROW, C.LEFT_ARROW, C.RIGHT_ARROW, C.UP, C.DOWN, C.LEFT, C.RIGHT);
    private control control = new control(io, pacman_asset);
    private graphics_framework graphics = new graphics_framework(control, C.PERIODIC_UPDATE_DELAY, C.DEFAULT_BACKGROUND_COLOR, sprites, C.NUM_OF_SPRITES);

    public game()
    {
        game_frame.setSize(C.FRAME_BORDER_X, C.FRAME_BORDER_Y);
        game_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game_frame.add(graphics);
        game_frame.setVisible(true);
        game_frame.addKeyListener(io.getKeyListener());    
    }

}
