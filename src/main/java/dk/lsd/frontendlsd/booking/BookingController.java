package dk.lsd.frontendlsd.booking;

import booking.dto.*;
import booking.eto.InvalidInputException;
import booking.eto.NotFoundException;
import booking.eto.PersistanceFailedException;
import booking.eto.UnavailableException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/booking")
@Slf4j
@RequiredArgsConstructor

public class BookingController {

    private final BookingService bookingService;

    @GetMapping("/listAvailableCars")
    public ResponseEntity<Collection<CarSummary>>listAvailableCars(@RequestBody BookingCriteria bookingCriteria) throws NotFoundException, InvalidInputException {
        return ResponseEntity.ok(bookingService.listAvailableCars(bookingCriteria));
    }

    @PostMapping("/calculateFee")
    public ResponseEntity<Double>calculateFee(@RequestBody BookingCriteria bookingCriteria) throws InvalidInputException {
        return ResponseEntity.ok(bookingService.calculateFee(bookingCriteria));
    }

    @PostMapping("/createBooking")
    public ResponseEntity<Object>createBooking(
            @RequestBody CreateBookingWrapper body) throws InvalidInputException {
        return ResponseEntity.ok(bookingService.createBooking( body.getBookingCriteria(), body.getPrice(), body.getDriverDetails(),  body.getEmployeeDetails(),  body.getCarSummary()));
    }

    @PostMapping("/saveBooking")
    public ResponseEntity<BookingDetails>saveBooking(@RequestBody BookingDetails bookingDetails) throws PersistanceFailedException, UnavailableException {
        return ResponseEntity.ok(bookingService.saveBooking(bookingDetails));
    }

    @PostMapping("/cancelBooking")
    public ResponseEntity<Boolean>cancelBooking(@RequestBody BookingIdentifier bookingIdentifier) throws PersistanceFailedException, UnavailableException, NotFoundException, InvalidInputException {
        return ResponseEntity.ok(bookingService.cancelBooking(bookingIdentifier));
    }

    @PostMapping("/endBooking")
    public ResponseEntity<BookingDetails>endBooking(@RequestBody BookingIdentifier bookingIdentifier) throws PersistanceFailedException, UnavailableException, NotFoundException, InvalidInputException {
        return ResponseEntity.ok(bookingService.endBooking(bookingIdentifier));
    }

    @PostMapping("/findBooking")
    public ResponseEntity<BookingDetails>findBooking(@RequestBody BookingIdentifier bookingIdentifier) throws NotFoundException, InvalidInputException {
        return ResponseEntity.ok(bookingService.findBooking(bookingIdentifier));
    }
}
