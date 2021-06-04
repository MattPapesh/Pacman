package assets;
import fundamentals.*;

public class pacman
{
    private sprite pacman = null;
    private boolean enable = false;
    //private int current_direction = 0;
   // private int previous_direction = 0; 
    

    public pacman(constants global, sprite pacman)
    {
      
        this.pacman = pacman;
       
    }

    public sprite getPacman() {return pacman; }

    public void execute()
    {
        if (enable)
        {
           
        }
    }

    public void toggleAbility(boolean enable)
    {
        this.enable = enable; 
    }


   
}