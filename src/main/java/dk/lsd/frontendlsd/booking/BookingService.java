package dk.lsd.frontendlsd.booking;


import booking.dto.*;
import booking.entity.Address;
import booking.entity.Car;
import booking.entity.Place;
import booking.entity.Type;
import booking.eto.InvalidInputException;
import booking.eto.NotFoundException;
import booking.eto.PersistanceFailedException;
import booking.eto.UnavailableException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor

public class BookingService implements booking.Contract {

    @Override
    public Collection<CarSummary> listAvailableCars(BookingCriteria bookingCriteria) throws NotFoundException, InvalidInputException {
        Collection<CarSummary>list = new ArrayList();

        list.add(new CarSummary(new Car( "vin",  "licensePlate", Type.A ,  10,  85,  true),
                        new Place( "name", new Address("streetAddress",  2730,  "city"),  true)));
        return list;
    }

    @Override
    public Double calculateFee(BookingCriteria bookingCriteria) throws InvalidInputException {
        return null;
    }

    @Override
    public BookingDetails createBooking(BookingCriteria bookingCriteria, Double aDouble, DriverDetails driverDetails, EmployeeDetails employeeDetails, CarSummary carSummary) throws InvalidInputException {
        return new BookingDetails((long) 1, carSummary, driverDetails, employeeDetails, bookingCriteria, 345.0, 567.0);
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
