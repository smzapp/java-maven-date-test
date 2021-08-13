package exer;

import org.apache.commons.validator.GenericValidator;
import org.joda.time.DateTime;

public class DateEntry  implements  AcceptDateImpl{

    private DateTime dateTime;

    private String userInput;

    public DateEntry(String input){
        this.userInput = input;
    }

    public void validateDate() throws Exception {
        boolean  isDate =  GenericValidator.isDate(userInput, "yyyy-MM-dd", true);
        if (!isDate) {
            throw new Exception("The input date is invalid!");
        } else {
            this.dateTime = new DateTime(userInput);
        }
    }

    @Override
    public boolean isDateStartMonth() {
        return this.dateTime.getMonthOfYear() == 1;
    }

    @Override
    public boolean isDateEndMonth() {
        return this.dateTime.getMonthOfYear() == 12;
    }

    @Override
    // January to December
    public boolean isMonthFirstHalf() {
        int monthValue = this.dateTime.getMonthOfYear();
        return (monthValue <= 6);
    }

    @Override
    // July to December
    public boolean isMonthLastHalf() {
        int monthValue = this.dateTime.getMonthOfYear();
        return (monthValue > 6);
    }
}
