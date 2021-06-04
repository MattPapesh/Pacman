package fundamentals;

public class path 
{
    coords centered_coords = null;
    boolean game_piece = false;
    boolean power_up = false; 

    public coords getCenteredCoordinates(){return centered_coords; }
    public boolean getGamePiece(){return game_piece; }
    public boolean getPowerUp(){return power_up; }

    path(int x, int y)
    {
        centered_coords = new coords(x, y);
    }

    path(int x, int y, boolean game_piece)
    {
        centered_coords = new coords(x, y);
        this.game_piece = game_piece; 
    }

    path(int x, int y, boolean game_piece, boolean power_up)
    {
        centered_coords = new coords(x, y);
        this.game_piece = game_piece;
        this.power_up = power_up; 
    }
}
