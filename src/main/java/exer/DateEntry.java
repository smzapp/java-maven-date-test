package exer;

import org.apache.commons.validator.GenericValidator;
import org.joda.time.DateTime;

public class DateEntry  implements  AcceptDateImpl{

    private DateTime dateTime;

    private final String userInput;

    public DateEntry(String input){
        this.userInput = input;
    }

    public void validateDate() throws Exception {
        boolean  isDate =  GenericValidator.isDate(userInput, "yyyy-MM-dd", true);
        if (isDate) {
            this.dateTime = new DateTime(userInput);
        } else {
            throw new Exception("The input date is invalid!");
        }
    }

    @Override
    public boolean isDateStartMonth() {
        int val = this.dateTime.dayOfMonth().getMinimumValue();
        return this.dateTime.getDayOfMonth() == val ;
    }

    @Override
    public boolean isDateEndMonth() {
         int val = this.dateTime.dayOfMonth().getMaximumValue();
         return this.dateTime.getDayOfMonth() == val ;
    }

    @Override
    // January to December
    public boolean isMonthFirstHalf() {
        int val = this.dateTime.dayOfMonth().getMaximumValue();
        return ((val / 2) >= this.dateTime.getDayOfMonth()) ;
    }

    @Override
    // July to December
    public boolean isMonthLastHalf() {
        int val = this.dateTime.dayOfMonth().getMaximumValue();
        return ((val / 2) < this.dateTime.getDayOfMonth()) ;
    }
}
