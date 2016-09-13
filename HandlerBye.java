package Castle;

import java.util.logging.*;

/**
 * Created by He on 2016/9/11.
 */
public class HandlerBye extends Handler {
    public HandlerBye(Game game){
        super(game);
    }
    @Override
    public boolean isBye() {
        return true;
    }
}
