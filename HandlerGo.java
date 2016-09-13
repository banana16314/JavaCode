package Castle;

/**
 * Created by He on 2016/9/11.
 */
public class HandlerGo extends Handler {

    public HandlerGo(Game game ){
        super(game);
    }
    @Override
    public void doCmd(String word) {
        game.goRoom(word);
    }
}
