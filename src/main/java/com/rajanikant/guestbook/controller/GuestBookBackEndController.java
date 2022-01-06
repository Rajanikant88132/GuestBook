package com.rajanikant.guestbook.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajanikant.guestbook.entity.GuestDetails;
import com.rajanikant.guestbook.service.GuestDetailsService;

/**
 * 
 * @author Rajanikant Yadav
 *
 */

@RestController
@RequestMapping("/GuestBook")
public class GuestBookBackEndController {

	@Autowired
	private GuestDetailsService guestDetailsService;



	@GetMapping("/guestDetails/guestDetailById/{playerId}")
	public GuestDetails findPlayerById(@PathVariable("playerId") Long guestId)
	{
		System.out.println("findPlayerById the Department in Controller....");
		return guestDetailsService.findGuestDetailsByguestId(guestId);
	}

	@PostMapping("/guestDetails/SaveGuestDetails/")
	public GuestDetails savePlayer(@RequestBody GuestDetails guestDetails)
	{

		System.out.println("Save guestDetails the guestDetails in Controller...."+guestDetails);
		if(guestDetails!=null && !guestDetailsService.checkIfGuestDetailsAlreadyExist(guestDetails))
		{
			return guestDetailsService.saveGuestDetails(guestDetails);
		}
		else
		{
		
			return guestDetailsService.findByEmailId(guestDetails);
		}
	}



}
