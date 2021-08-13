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
