package dk.lsd.frontendlsd;

import booking.dto.*;
import booking.eto.InvalidInputException;
import booking.eto.NotFoundException;
import booking.eto.PersistanceFailedException;
import booking.eto.UnavailableException;

import java.util.Collection;

public class test implements booking.Contract{
    @Override
    public Collection<CarSummary> listAvailableCars(BookingCriteria bookingCriteria) throws NotFoundException, InvalidInputException {
        return null;
    }

    @Override
    public Double calculateFee(BookingCriteria bookingCriteria) throws InvalidInputException {
        return null;
    }

    @Override
    public BookingDetails createBooking(BookingCriteria bookingCriteria, Double aDouble, DriverDetails driverDetails) throws InvalidInputException {
        return null;
    }

    @Override
    public BookingDetails saveBooking(BookingDetails bookingDetails) throws PersistanceFailedException, UnavailableException {
        return null;
    }

    @Override
    public boolean cancelBooking(BookingIdentifier bookingIdentifier) throws PersistanceFailedException, NotFoundException, UnavailableException, InvalidInputException {
        return false;
    }

    @Override
    public BookingDetails endBooking(BookingIdentifier bookingIdentifier) throws PersistanceFailedException, NotFoundException, UnavailableException, InvalidInputException {
        return null;
    }

    @Override
    public BookingDetails findBooking(BookingIdentifier bookingIdentifier) throws NotFoundException, InvalidInputException {
        return null;
    }
}
