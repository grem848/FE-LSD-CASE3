package dk.lsd.frontendlsd.booking;


import booking.dto.*;
import booking.eto.InvalidInputException;
import booking.eto.NotFoundException;
import booking.eto.PersistanceFailedException;
import booking.eto.UnavailableException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service

@RequiredArgsConstructor

public class BookingService implements booking.Contract {

    @SneakyThrows
    @Override
    public Collection<CarSummary> listAvailableCars(BookingCriteria bookingCriteria) throws NotFoundException, InvalidInputException {
        //Collection<CarSummary>list = new ArrayList();

        // list.add(new CarSummary(new Car( "vin",  "licensePlate", Type.A ,  10,  85,  true),
                        //new Place( "name", new Address("streetAddress",  2730,  "city"),  true)));

        return RMIService.getInstance().contract.listAvailableCars(bookingCriteria);
    }

    @SneakyThrows
    @Override
    public Double calculateFee(BookingCriteria bookingCriteria) throws InvalidInputException {
        return RMIService.getInstance().contract.calculateFee(bookingCriteria);
    }

    @SneakyThrows
    @Override
    public BookingDetails createBooking(BookingCriteria bookingCriteria, Double aDouble, DriverDetails driverDetails, EmployeeDetails employeeDetails, CarSummary carSummary) throws InvalidInputException {
        //return new BookingDetails((long) 1, carSummary, driverDetails, employeeDetails, bookingCriteria, 345.0, 567.0);
        return RMIService.getInstance().contract.createBooking(bookingCriteria, aDouble, driverDetails, employeeDetails, carSummary);
    }

    @SneakyThrows
    @Override
    public BookingDetails saveBooking(BookingDetails bookingDetails) throws PersistanceFailedException, UnavailableException {
        return RMIService.getInstance().contract.saveBooking(bookingDetails);
    }

    @SneakyThrows
    @Override
    public boolean cancelBooking(BookingIdentifier bookingIdentifier) throws PersistanceFailedException, NotFoundException, UnavailableException, InvalidInputException {
        return RMIService.getInstance().contract.cancelBooking(bookingIdentifier);
    }

    @SneakyThrows
    @Override
    public BookingDetails endBooking(BookingIdentifier bookingIdentifier) throws PersistanceFailedException, NotFoundException, UnavailableException, InvalidInputException {
        return RMIService.getInstance().contract.endBooking(bookingIdentifier);
    }

    @SneakyThrows
    @Override
    public BookingDetails findBooking(BookingIdentifier bookingIdentifier) throws NotFoundException, InvalidInputException {
        return RMIService.getInstance().contract.findBooking(bookingIdentifier);
    }
}
