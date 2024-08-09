package ch08;

public class RemoteControlExample {
    public static void main(String[] args) {
        RemoteControl rc ;

        rc = new Television();
        rc.setMute(false);

        RemoteControl.changeBattery();
    }
}
