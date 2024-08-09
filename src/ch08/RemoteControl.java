package ch08;

public interface RemoteControl {
    int MAX_VOLUME = 10;
    int MIN_VOLUME = 0;

    default void setMute(boolean isMute) {
        if (isMute) {
            System.out.println("무음 처리");
        } else {
            System.out.println("무음 해제");
        }

        privateMethod();
        privateStaticMethod();
    }

    static void changeBattery() {
        privateStaticMethod();
        // 호출 불가능!
//        privateMethod();
        System.out.println("리모콘 건전지 교체!");
    }

    private void privateMethod() {
        System.out.println("RemoteControl.privateMethod");
    }

    private static void privateStaticMethod() {
        System.out.println("RemoteControl.privateStaticMethod");
    }
}
