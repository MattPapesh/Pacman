import assets.*;

public class control 
{ 
   private IO io = null; 
   private pacman pacman_asset = null;
   private boolean invert_controls = false;
    
    control(IO io, pacman pacman_asset)
    {
        this.io = io; 
        this.pacman_asset = pacman_asset;
    }

    public void execute()
    {
        pacman_asset.toggleAbility(true);
        pacman_asset.toggleInversion(invert_controls);
        pacman_asset.setDirection(io.getDirection());
        pacman_asset.execute(); 
    }

    public void invert_controls(boolean invert_controls)
    {
        this.invert_controls = invert_controls; 
    }
}
