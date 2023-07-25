package repository;

import model.Booking;

import java.util.Set;

public interface IBookingRepository {
    void addBooking(Booking booking);

    Set<Booking> displayAllBookings();
    void deleteBooking(String bookingId);

}
