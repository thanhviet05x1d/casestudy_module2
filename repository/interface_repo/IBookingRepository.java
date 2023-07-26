package repository.interface_repo;

import model.booking.Booking;

import java.util.Set;

public interface IBookingRepository {
    void addBooking(Booking booking);

    Set<Booking> displayAllBookings();
    void deleteBooking(String bookingId);

}
