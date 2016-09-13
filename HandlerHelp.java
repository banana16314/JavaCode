package Castle;

/**
 * Created by He on 2016/9/11.
 */
public class HandlerHelp extends Handler {

    public HandlerHelp(Game game){
        super(game);
    }
    @Override
    public void doCmd(String word) {
        System.out.println("Lost? type Cmd: go bye help");
        System.out.println(" Ex:\tgo east");
    }
}
