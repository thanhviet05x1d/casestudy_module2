package repository.implement_repo;

import model.booking.Booking;
import repository.interface_repo.IBookingRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BookingRepository implements IBookingRepository {
    private static final Set<Booking> bookingSet = new TreeSet<>();

    static {
        Date startDate1 = null;
        Date endDate1 = null;
        Date startDate2 = null;
        Date endDate2 = null;
        Date startDate3 = null;
        Date endDate3 = null;
        try {
            startDate1 = new SimpleDateFormat("yyyy-MM-dd").parse("2023-07-25");
            endDate1 = new SimpleDateFormat("yyyy-MM-dd").parse("2023-07-27");
            startDate2 = new SimpleDateFormat("yyyy-MM-dd").parse("2023-07-25");
            endDate2 = new SimpleDateFormat("yyyy-MM-dd").parse("2023-07-28");
            startDate3 = new SimpleDateFormat("yyyy-MM-dd").parse("2023-07-28");
            endDate3 = new SimpleDateFormat("yyyy-MM-dd").parse("2023-08-24");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        bookingSet.add(new Booking("BK001", "KH-0001", "SVVL-0001", startDate1, endDate1));
        bookingSet.add(new Booking("BK002", "KH-0002", "SVVL-0002", startDate2, endDate2));
        bookingSet.add(new Booking("BK003", "KH-0003", "SVHO-0001", startDate3, endDate3));
    }

    @Override
    public void addBooking(Booking booking) {
        bookingSet.add(booking);
    }

    @Override
    public Set<Booking> displayAllBookings() {
        return bookingSet;
    }
    @Override
    public void deleteBooking(String bookingId) {
        for (Booking b:bookingSet) {
            if (b.getBookingId().equals(bookingId)){
                bookingSet.remove(b);
                break;
            }
        }
    }
}
