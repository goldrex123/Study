package ch12;

import java.util.Calendar;
import java.util.TimeZone;

public class LosAngelesExample {
    public static void main(String[] args) {

        TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
        Calendar cal = Calendar.getInstance(timeZone);

        StringBuilder sb = new StringBuilder();


        int amPm = cal.get(Calendar.AM_PM);
        if (amPm == Calendar.AM) {
            sb.append("오전");
        } else {
            sb.append("오후");
        }

        sb.append(cal.get(Calendar.HOUR));
        sb.append(cal.get(Calendar.MINUTE));
        sb.append(cal.get(Calendar.SECOND));

        System.out.println(sb);
    }
}
