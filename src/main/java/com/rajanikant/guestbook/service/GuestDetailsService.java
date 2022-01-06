package com.rajanikant.guestbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajanikant.guestbook.entity.GuestDetails;
import com.rajanikant.guestbook.repository.GuestDetailsRepository;

/**
 * 
 * @author Rajanikant Yadav
 *
 */

@Service
public class GuestDetailsService {
	
	@Autowired
	private GuestDetailsRepository guestDetailsRepository;
	
	
	public GuestDetails saveGuestDetails(GuestDetails guest)
	{
		System.out.println("Save the guest in Service...."+guest);
		
		return guestDetailsRepository.save(guest);
	}
	
	public GuestDetails findGuestDetailsByguestId(Long guestId)
	{
		System.out.println("getguestId the GuestDetails in Service...."+guestDetailsRepository.findGuestDetailsByguestId(guestId));
		
		
		return guestDetailsRepository.findGuestDetailsByguestId(guestId);
	}
	
	public List<GuestDetails> findAllGuestDetails()
	{
		
		
		return (List<GuestDetails>) guestDetailsRepository.findAll();
	}
	
	public boolean checkIfGuestDetailsAlreadyExist(GuestDetails guestDetails)
	{
		
		if (guestDetailsRepository.existsByEmailId(guestDetails.getEmailId())) {
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public GuestDetails findByEmailId(GuestDetails guestDetails)
	{
		
		
		GuestDetails guestDetail =guestDetailsRepository.findByEmailId(guestDetails.getEmailId());
	
		return guestDetail;
	}

}
