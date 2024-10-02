package com.fsd.bookingService.controller;

import com.fsd.bookingService.bean.ResponseBean;
import com.fsd.bookingService.bean.SlotBookingRequestBean;
import com.fsd.bookingService.bean.UpdateBookingRequestBean;
import com.fsd.bookingService.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping("/{vendorId}")
    public ResponseEntity<ResponseBean> getAvailableSlots(@PathVariable("vendorId") String vendorId,
    @RequestParam LocalDate date){
        return new ResponseEntity<>(new ResponseBean(bookingService.getAvailableSlots(vendorId,date)), HttpStatus.OK);
    }

    @PostMapping("/{vendorId}")
    public ResponseEntity<ResponseBean> createBooking(@RequestBody List<SlotBookingRequestBean> services, @PathVariable("vendorId") String vendorId,
                                                      @RequestParam String customerId, @RequestParam LocalDate date){
        return new ResponseEntity<>(new ResponseBean(bookingService.createBooking(vendorId,date,services,customerId)), HttpStatus.OK);
    }

    @GetMapping("/bookingDetails/{bookingId}")
    public ResponseEntity<ResponseBean> getBookingDetails(@PathVariable("bookingId") String bookingId){
        return new ResponseEntity<>(new ResponseBean(bookingService.getBookingDetails(bookingId)), HttpStatus.OK);
    }

    @GetMapping("/customer/history/{customerId}")
    public ResponseEntity<ResponseBean> getCustomerBookingHistory(@PathVariable("customerId") String customerId){
        return new ResponseEntity<>(new ResponseBean(bookingService.getCustomerBookingHistory(customerId)), HttpStatus.OK);
    }

    @GetMapping("/vendor/history/{vendorId}")
    public ResponseEntity<ResponseBean> getVendorBookingHistory(@PathVariable("vendorId") String vendorId){
        return new ResponseEntity<>(new ResponseBean(bookingService.getVendorBookingHistory(vendorId)), HttpStatus.OK);
    }

//    @PutMapping("/update/booking/{bookingId}")
//    public ResponseEntity<ResponseBean> updateBooking(@PathVariable("bookingId") String bookingId, @RequestBody UpdateBookingRequestBean updateBookingRequestBean){
//        return new ResponseEntity<>(new ResponseBean(bookingService.updateBooking(bookingId,updateBookingRequestBean)), HttpStatus.OK);
//    }



//    updateBookingDetails
//    cancelbooking
//    updateBookingStatus

}