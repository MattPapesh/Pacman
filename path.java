public class path 
{
    coords CENTERED_COORDS = null;
    boolean game_piece = false;
    boolean power_up = false; 

    path(int x, int y)
    {
        CENTERED_COORDS = new coords(x, y);
    }

    path(int x, int y, boolean game_piece)
    {
        CENTERED_COORDS = new coords(x, y);
        this.game_piece = game_piece; 
    }

    path(int x, int y, boolean game_piece, boolean power_up)
    {
        CENTERED_COORDS = new coords(x, y);
        this.game_piece = game_piece;
        this.power_up = power_up; 
    }
    

}
