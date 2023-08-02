package repository.implement_repo;

import model.booking.Booking;
import repository.interface_repo.IBookingRepository;

import java.time.LocalDate;
import java.util.*;

public class BookingRepository implements IBookingRepository {
    private static final Set<Booking> bookingSet = new TreeSet<>();

    static {

            LocalDate startDate1 = LocalDate.parse("2023-08-25");
            LocalDate endDate1 = LocalDate.parse("2023-08-27");
            LocalDate startDate2 = LocalDate.parse("2023-07-25");
            LocalDate endDate2 = LocalDate.parse("2023-07-28");
            LocalDate startDate3 = LocalDate.parse("2023-08-28");
            LocalDate endDate3 = LocalDate.parse("2023-09-24");
            LocalDate startDate4 = LocalDate.parse("2023-08-05");
            LocalDate endDate4 = LocalDate.parse("2023-08-07");



        bookingSet.add(new Booking("BK001", "KH-0001", "SVVL-0001", startDate1, endDate1));
        bookingSet.add(new Booking("BK002", "KH-0002", "SVVL-0002", startDate2, endDate2));
        bookingSet.add(new Booking("BK003", "KH-0003", "SVRO-0001", startDate3, endDate3));
        bookingSet.add(new Booking("BK004", "KH-0004", "SVRO-0002", startDate4, endDate4));
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
