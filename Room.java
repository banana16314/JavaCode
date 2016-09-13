package Castle;

import java.util.HashMap;

public class Room {
    private String description;
    private HashMap<String, Room> exists=new HashMap<String, Room>();

    public Room(String description) 
    {
        this.description = description;
    }
    public void setExit(String dir, Room room){
        exists.put(dir,room);
    }
    public String getExitDesc(){
        StringBuffer sb=new StringBuffer();
        for(String desc:exists.keySet()){
            sb.append(desc);
            sb.append(" ");
        }
        return sb.toString();
    }
    public Room getExit(String direction){
        return exists.get(direction);

    }
    @Override
    public String toString()
    {
        return description;
    }
}
