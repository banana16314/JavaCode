package Castle;

/**
 * Created by He on 2016/9/11.
 */
public class Handler {
    protected Game game;

    public Handler(Game game){
        super();
        this.game=game;
    }
    public void doCmd(String word){

    }
    public boolean isBye(){
        return false;
    }
}
