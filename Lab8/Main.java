
import java.util.Scanner;

public class Main {


    /*method checks if a string exactly matches a pattern where there are three pairs of digits (\d{2}),
    each pair separated by a colon (:), representing a time format of hours, minutes, and seconds (HH:MM:SS)*/
    public static int convertTimeToSeconds(String time) throws InvalidTimeException {
        if (!time.matches("\\d{2}:\\d{2}:\\d{2}")) {
            throw new InvalidTimeException("Enter a valid time");
        }

        /*String[] parts -  substrings are stored in an array of strings named parts. If time is properly formatted,
        parts[0] will contain the hour, parts[1] the minute, and parts[2] the second*/

        //parseInt - converts a string representation of a number into an integer value

        String[] parts = time.split(":", 3);
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);

        if (hours < 0 || hours >= 24) {
            throw new InvalidTimeException("Hour must be below 24");
        }
        if (minutes < 0 || minutes >= 60) {
            throw new InvalidTimeException("Minutes must be less than 60");
        }
        if (seconds < 0 || seconds >= 60) {
            throw new InvalidTimeException("Seconds must be less than 60");
        }

        return (hours * 3600) + (minutes * 60) + seconds;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter time 1 in 24hr format as follows (HH:MM:SS)");
            String time1 = scanner.nextLine();
            int seconds1 = convertTimeToSeconds(time1);

            System.out.println("Enter time 2 in 24hr format as follows (HH:MM:SS)");
            String time2 = scanner.nextLine();
            int seconds2 = convertTimeToSeconds(time2);

            int difference = Math.abs(seconds2 - seconds1);
            System.out.println("Difference in seconds: " + difference);

        } catch (InvalidTimeException e) {
            System.out.println(e.getMessage());
        }
    }
}