package exer;

/**
 * Created by samuel
 */
public class MainApp{

    // Enter date String format yyyy/MM/dd;
    private static final String userInput = "1989-07-27";

    private static DateEntry dateEntry;

    public static void main(String[] args) {
        try {
            dateEntry = new DateEntry(userInput);
            dateEntry.validateDate();
            displayResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void displayResult() {
        System.out.println("User Date INPUT : " + userInput);
        System.out.println("Date is START of the month: " + dateEntry.isDateStartMonth());
        System.out.println("Date is END of the month: " + dateEntry.isDateEndMonth());
        System.out.println("Month is in the First half of the year: " + dateEntry.isMonthFirstHalf());
        System.out.println("Month is in the Last half of the year: " + dateEntry.isMonthLastHalf());
    }
}
