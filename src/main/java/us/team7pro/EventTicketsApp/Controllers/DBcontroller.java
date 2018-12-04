package us.team7pro.EventTicketsApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import us.team7pro.EventTicketsApp.Domain.User;
import us.team7pro.EventTicketsApp.Models.*;
import us.team7pro.EventTicketsApp.Repositories.*;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/db") // This means URL's start with /demo (after Application path)
public class DBcontroller {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepo;
	
	@Autowired
    private EventRepository eventRepo;
    
    @Autowired
    private TransactionRepository transcRepo;

	@GetMapping(path = "/allUsers")
    public @ResponseBody Iterable<User> getAllUser() {
        return userRepo.findAll();
    }

    @GetMapping(path = "/allEvents")
    public @ResponseBody Iterable<Event> getAllEvent() {
        return eventRepo.findAll();
    }

    @GetMapping(path = "/allTransactions")
    public @ResponseBody Iterable<Transaction> getAllTrasac() {
        return transcRepo.findAll();
    }

}