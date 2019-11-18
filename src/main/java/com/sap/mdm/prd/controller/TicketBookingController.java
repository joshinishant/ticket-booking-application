package com.sap.mdm.prd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sap.mdm.prd.entities.TicketBookingEntity;
import com.sap.mdm.prd.service.TicketBookingService;

@RestController
@RequestMapping("/v1/Tickets")
public class TicketBookingController {
	
	@Autowired
	private TicketBookingService ticketBookingService;
	
	
	@GetMapping(value="/getTicket",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<TicketBookingEntity> getTicket(@RequestParam(value="ticketNumber") String ticketNumber) {
		TicketBookingEntity ticket=ticketBookingService.findTicketByNumber(ticketNumber);
		return new ResponseEntity<TicketBookingEntity>(ticket,HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="/getAllTickets",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<TicketBookingEntity>> getAllTickets() {
		List<TicketBookingEntity> ticketList=ticketBookingService.findAllTickets();
		return new ResponseEntity<List<TicketBookingEntity>> (ticketList,HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value="/createTicket",consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<TicketBookingEntity> createTicket(@RequestBody TicketBookingEntity ticket) {
		TicketBookingEntity persistedTicket =null;		
		if(!StringUtils.isEmpty(ticket.getNumber())) {
			persistedTicket=ticketBookingService.findTicketByNumber(ticket.getNumber());
			if(persistedTicket!=null) {
				ticket.setId(persistedTicket.getId());
				return new ResponseEntity<TicketBookingEntity>(ticketBookingService.updateTicket(ticket),HttpStatus.ACCEPTED);
			}
			
			return new ResponseEntity<TicketBookingEntity>(ticketBookingService.insertTicket(ticket),HttpStatus.ACCEPTED);			
		}
		else {
			return null;
		}				
	}
	
	
	@PutMapping(value="/createTicket",consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<TicketBookingEntity> updateTicket(@RequestBody TicketBookingEntity ticket) {
		System.out.println("entered");
		TicketBookingEntity persistedTicket =null;
		if(!StringUtils.isEmpty(ticket.getId())) {
			persistedTicket=ticketBookingService.findTicketById(ticket.getId());
			if(persistedTicket!=null) {
				return new ResponseEntity<TicketBookingEntity>(ticketBookingService.updateTicket(ticket),HttpStatus.ACCEPTED);
			}
			return new ResponseEntity<TicketBookingEntity>(ticketBookingService.insertTicket(ticket),HttpStatus.ACCEPTED);
		}
		else if(!StringUtils.isEmpty(ticket.getNumber())) {
			persistedTicket=ticketBookingService.findTicketByNumber(ticket.getNumber());
			if(persistedTicket!=null) {
				ticket.setId(persistedTicket.getId());
				return new ResponseEntity<TicketBookingEntity>(ticketBookingService.updateTicket(ticket),HttpStatus.ACCEPTED);
			}
			
			return new ResponseEntity<TicketBookingEntity>(ticketBookingService.insertTicket(ticket),HttpStatus.ACCEPTED);		
		}
		else {
			return new ResponseEntity<TicketBookingEntity>(HttpStatus.ACCEPTED);
		}				
	}
	
	
	@DeleteMapping(value="/deleteTicket",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> deleteTicket(@RequestParam(value="ticketNumber") String ticketNumber) {
		if(!StringUtils.isEmpty(ticketNumber)) {
			boolean deleteStatus=ticketBookingService.deleteTicket(ticketNumber);
			if(deleteStatus==true) {
				return new ResponseEntity<String>("Successfully Deleted Ticket number "+ticketNumber,HttpStatus.ACCEPTED);
			}
			return new ResponseEntity<String>("Ticket number "+ticketNumber+" not found in database",HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<String>("Ticket number passed is null",HttpStatus.BAD_REQUEST);
		}				
	}
	
	
	@DeleteMapping(value="/deleteAllTickets",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> deleteAllTickets() {	
		ticketBookingService.deleteAllTickets();
		return new ResponseEntity<String>("All tickets successfully deleted", HttpStatus.ACCEPTED);
					
	}
	
	

}
