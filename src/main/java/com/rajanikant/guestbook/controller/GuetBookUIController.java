package com.rajanikant.guestbook.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rajanikant.guestbook.entity.GuestDetails;
import com.rajanikant.guestbook.service.GuestDetailsService;
/**
 * 
 * @author Rajanikant Yadav
 *
 */

@Controller
public class GuetBookUIController {

	
	@Autowired
	private GuestDetailsService guestDetailsService;

	

	@RequestMapping("/")
	public String loadUI(@RequestParam(value = "action", required = false) String action,Model model) throws IOException {

		System.out.println("Action djdsdjsjddnfjfskfsjfjksfjksfs: "+action);
		if(action!=null && action.equals("Register"))
		{
			System.out.println("In  SaveGuest: "+action);
			return "Registration";
		}
		 else if(action!=null && action.equals("GetGuestDetails"))
			{
				System.out.println("In  GetGuestDetails: "+action);
			
				return "GetTextForMeResult";
			} else if(action!=null && action.equals("GetTop10"))
			{
				System.out.println("In  GetGuestDetails: "+action);
				return "redirect:/UI/getAllGuestDetails";
			}
		else 
			return "uploadForm";



		/*
		 * model.addAttribute("files", storageService.loadAll().map( path ->
		 * MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
		 * "serveFile", path.getFileName().toString()).build().toUri().toString())
		 * .collect(Collectors.toList()));
		 * 
		 * return "uploadForm";
		 */
	}

	@PostMapping("/UI/SaveGuestDetails")
	public String registerPlayer(@RequestParam(value = "SaveGuest", required = false) String action,
			@RequestParam(value = "guestName", required = false) String guestName,
			@RequestParam(value = "guestAge", required = false) String guestAge,
			@RequestParam(value = "emailId", required = false) String emailId,
			@RequestParam(value = "feednback", required = false) String feedback
			,Model model,RedirectAttributes redirectAttributes) throws IOException 
	{
		GuestDetails guestDetails=new GuestDetails();
		guestDetails.setGuestName(guestName);
		guestDetails.setGuestAge(guestAge);
		guestDetails.setEmailId(emailId);
		guestDetails.setFeedback(feedback);
		System.out.println("Save Player the Player in Controller...."+guestDetails);
		if(guestDetails!=null && !guestDetailsService.checkIfGuestDetailsAlreadyExist(guestDetails))
		{
			guestDetails= guestDetailsService.saveGuestDetails(guestDetails);
		
			 redirectAttributes.addFlashAttribute("message",
						"Registration Is Successfull for Guest '" + guestName + "' and emaild Id '"+emailId+ "' Please Note Guest Id ='"+guestDetails.getGuestId()+"'  for next communication !");
		}
		else
		{
		
			redirectAttributes.addFlashAttribute("message",
					"Guest already exsit with same email id  " + emailId + "!");
		}
		
		

		return "redirect:/";
	}





	@PostMapping("/UI/getGuestDetailsById")
	public String getSubmitTextForAPlayer(@RequestParam(value = "action", required = false) String action,
			@RequestParam(value = "guestId", required = false) String guestId		
					,Model model,RedirectAttributes redirectAttributes) throws IOException 
	{
		System.out.println(" guestId "+guestId);
		

		
		if(guestId==null )
		{
			redirectAttributes.addFlashAttribute("message",
					"Failure for  guestId Id '" + guestId + "' . guestId ID  Provided  Does Not Exist for the Player!");
		
			return  "redirect:/";
		}
		
		if(guestId!=null && guestDetailsService.findGuestDetailsByguestId(Long.parseLong(guestId))==null)
		{
			
			
			redirectAttributes.addFlashAttribute("message",
					"Failure for  Guest Id '" + guestId + "' . Guest ID  Does Not Exist for the Guest!");
		
			return  "redirect:/";
		}
		
		
		
		//List<GuestDetails>  listofGuestDetails=new ArrayList<GuestDetails>();
		GuestDetails guestDetails=guestDetailsService.findGuestDetailsByguestId(Long.parseLong(guestId));
	
		model.addAttribute("submissionDetails", guestDetails);
		
		return  "GetTextForMeResult";

	}
	
	@GetMapping("/UI/getAllGuestDetails")
	public String  getSubmitTextForTopPlayer(@RequestParam(value = "action", required = false) String action,
			Model model,RedirectAttributes redirectAttributes) throws IOException 
	{

		
		
		
		List<GuestDetails>  listofSubmission=new ArrayList<GuestDetails>();

	
		
	
		List<GuestDetails> guestDetails=guestDetailsService.findAllGuestDetails();
	
		
	   model.addAttribute("submissionDetails", guestDetails);
		
		return  "GetTextForTopResult";
	}


}
