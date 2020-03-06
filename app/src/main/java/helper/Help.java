package helper;

public class Help {
    public static String convertToTimeFormat(int time) {
        time = time/1000;
        String stringTime = "";
        int minutes = time / 60;
        int seconds = time % 60;
        if (minutes < 10) {
            stringTime += "0";
        }
        stringTime += minutes;
        stringTime += ":";

        if (seconds < 10) {
            stringTime += "0";
        }
        stringTime += seconds;
        return stringTime;
    }
}
