import java.util.Scanner;

class badTime extends Exception{
    public badTime() {}
    public badTime(String message){
        super(message);
    }
}
public class Lab8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try{
            System.out.println("Enter time 1 in 24hr format as follows (HH:MM:SS)");
            String timeOne = scan.nextLine();
            int timeUno = methodly(timeOne);
            System.out.println("Enter time 2 in 24hr format as follows (HH:MM:SS)");
            String timeTwo = scan.nextLine();
            int timeDos = methodly(timeTwo);
            int diff = Math.abs(timeUno - timeDos);
            System.out.println("Difference in seconds: " + diff);

        }catch (badTime b){
            System.out.println(b.getMessage());
        } finally {
            scan.close();
        }

    }
    public static int methodly(String s) throws badTime{
        String[] a = s.split(":",3);
        int hour = 0;
        int min = 0;
        int sec = 0;
        try {
            hour = Integer.parseInt(a[0]);
            min = Integer.parseInt(a[1]);
            sec = Integer.parseInt(a[2]);

        } catch (NumberFormatException n){
            if (hour > 23 || hour < 0) {
                throw new badTime("Must be within 0-24 hours");
            }
            if (min > 59 || min < 0) {
                throw new badTime("Must be within 0-60 minutes");
            }
            if (sec > 59 || sec < 0) {
                throw new badTime("Must be within 0-60 seconds");
            }
        }
        return (hour*3600) + (min*60) + (sec);
    }
}
