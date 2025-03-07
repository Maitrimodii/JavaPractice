package Collections;

import java.util.EnumSet;

public class EnumSetExample
{
    enum Day{
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }
    public static void main(String[] args) {
        EnumSet<Day> weekends = EnumSet.of(Day.SATURDAY,Day.SUNDAY);
        System.out.println(weekends);

        //EnumSet<Day> nulls = EnumSet.of(null);//cannot add null values

        EnumSet<Day> weekDays = EnumSet.complementOf(weekends);
        System.out.println(weekDays);

        EnumSet<Day> allDays = EnumSet.allOf(Day.class);
        System.out.println(allDays);

    }
}
