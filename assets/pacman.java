package assets;

import fundamentals.*;

public class pacman
{
     final coords PANEL_DISPLACEMENT;
    private sprite pacman_sprite = null;
     sprite stage_sprite = null;
    private boolean enable = false;
    private int inversion_factor = 1;
    private axisOfTranslation horizontal_axis = null;
    private axisOfTranslation vertical_axis = null;
    private int current_direction = 0;
    //private int previous_direction = 0; 
    private final int[][] LAYOUT;
    private final coords LAYOUT_MAX_COORDS; 

    private class axisOfTranslation
    {
        private final int[] DIRECTIONS;
        private final int NUM_OF_DIRECTIONS = 2; 
        private final coords DISPLACEMENT; 

      //  public int[] getDirections(){return DIRECTIONS; }
      //  public coords getDisplacement(){return DISPLACEMENT; }

        axisOfTranslation(int[] DIRECTIONS, int X_DISPLACEMENT, int Y_DISPLACEMENT)
        {
            this.DIRECTIONS = DIRECTIONS; 
            DISPLACEMENT = new coords(X_DISPLACEMENT, Y_DISPLACEMENT);
        }
    };
    
    public sprite getSprite() {return pacman_sprite; }

    public pacman(int[][] LAYOUT, int LAYOUT_MAX_X, int LAYOUT_MAX_Y, int[] HORIZONTAL_DIRECTIONS, int[] VERTICAL_DIRECTIONS, int PANEL_X_DISPLACEMENT, 
    int PANEL_Y_DISPLACEMENT, sprite pacman_sprite, sprite stage_sprite)
    {
        this.LAYOUT = LAYOUT;
        this.pacman_sprite = pacman_sprite;
        this.stage_sprite = stage_sprite; 
        LAYOUT_MAX_COORDS = new coords(LAYOUT_MAX_X, LAYOUT_MAX_Y);
        PANEL_DISPLACEMENT = new coords(PANEL_X_DISPLACEMENT, PANEL_Y_DISPLACEMENT);
        horizontal_axis = new axisOfTranslation(HORIZONTAL_DIRECTIONS, 1, 0);
        vertical_axis = new axisOfTranslation(VERTICAL_DIRECTIONS, 0, 1);
    }

    public void execute()
    {
        if (enable)
        {
           translate(horizontal_axis);
           translate(vertical_axis);
        }
    }

    public void toggleAbility(boolean enable)
    {
        this.enable = enable; 
    }

    public void toggleInversion(boolean invert_controls)
    {
        if (!invert_controls)
        {
            inversion_factor = 1;
        }
        else
        {
            inversion_factor = -1;
        }
    }

    public void setDirection(int direction)
    {
        //previous_direction = current_direction;
        current_direction = direction;
    }

    private void translate(axisOfTranslation axis)
    {
        //int delta_x = pacman_sprite.getChangeInCoords(true, stage.getPanelCoordinates()).x + PANEL_DISPLACEMENT.x; 
       // int delta_y = pacman_sprite.getChangeInCoords(true, stage.getPanelCoordinates()).y + PANEL_DISPLACEMENT.y; 
        coords initial_panel = pacman_sprite.getPanelCoordinates(), initial_layout = pacman_sprite.getLayoutCoordinates(); 

        for (int num_of_directions = 0, invert = inversion_factor * -1; num_of_directions < axis.NUM_OF_DIRECTIONS; 
        num_of_directions++, invert = inversion_factor * 1)
        {
            int displacement_x = invert * axis.DISPLACEMENT.x, displacement_y = invert * axis.DISPLACEMENT.y; 
            coords final_panel = new coords(initial_panel.x + 16*displacement_x, initial_panel.y + 16*displacement_y);
            coords final_layout = new coords(initial_layout.x + displacement_x, initial_layout.y + displacement_y);

            if (current_direction == axis.DIRECTIONS[num_of_directions] && final_layout.x >= 0 && final_layout.x <= LAYOUT_MAX_COORDS.x &&
            final_layout.y >= 0 && final_layout.y <= LAYOUT_MAX_COORDS.y && LAYOUT[final_layout.y][final_layout.x] == 1)
            {
                pacman_sprite.setPanelCoordinates(final_panel.x, final_panel.y);
                pacman_sprite.setLayoutCoordinates(final_layout.x, final_layout.y);
            }
        }
    }

}