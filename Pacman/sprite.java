public class sprite 
{
    public String SPRITE_DIR = "";
    public coords PANEL_COORDS = null; 
    public coords CENTERED_COORDS = null;
    public int SPRITE_WIDTH = 0;
    public int SPRITE_HEIGHT = 0;

    public sprite(String dir, int width, int height, int x, int y)
    {
        SPRITE_DIR = dir;
        SPRITE_WIDTH = width;
        SPRITE_HEIGHT = height;
        PANEL_COORDS = new coords(x - (width/2), y - (height/2));
        CENTERED_COORDS = new coords(x, y);//top left image coords
    }
}
