package utils;

import model.booking.Booking;

import java.util.Comparator;

public class BookingStartDateComparator implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        if (o1.getStartDate().equals(o2.getStartDate())) {
            return o1.getEndDate().compareTo(o2.getEndDate());
        } else {
            return o1.getStartDate().compareTo(o2.getStartDate());
        }
    }
}

