package Entertainment.EMT.EMTShop;

import java.io.File;

public class Picture {

    public  String event;
    public File pic;


    public Picture(String event, File pic){
        this.event = event;
        this.pic = pic;
    }
    public Picture(){

    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public File getPic() {
        return pic;
    }

    public void setPic(File pic) {
        this.pic = pic;
    }
}
