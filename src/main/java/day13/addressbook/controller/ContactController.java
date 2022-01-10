package day13.addressbook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import day13.addressbook.data.ContactDetails;
import day13.addressbook.handling.inputCmd;

@Controller
public class ContactController {
    @Autowired 
    private ApplicationArguments appargs;
    
    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @GetMapping("/")
        public String showContactForm(Model model){                     //TAKE THE MODEL, ADD CONTACT DATA TO BE POPULATED. AT THIS STAGE CONTACT DATA IS EMPTY
            ContactDetails contact = new ContactDetails();
            model.addAttribute("contact", contact); //give target objet for th:object ${contact} and add contact object for form to use getters and setters
            return "ContactForm";
        }

    @PostMapping("/getcontact")
        public String getContactdetail(@ModelAttribute ContactDetails contact, Model model){        //Reads the input into contact object immediately using getters and setters
            logger.info(contact.toString());
            inputCmd save = new inputCmd();
            save.saveDetails(contact,appargs);                                                         //save the details
            model.addAttribute("contact", contact);                                                     //adds ccontact object back into the model for form submisison
            return "ShowContact";
        }
    @GetMapping("/getcontact/{id}")             //PathVariable takes the {hex id} string in path variable and puts it into the string variable id
    public String getContactDetailId(Model model, @PathVariable(value = "id") String id){ 
        inputCmd retrieveId = new inputCmd();
        ContactDetails contact = new ContactDetails();                                                  //new contact object is required to store the retrieved data
         contact =  retrieveId.retrieveId(id, appargs);            
        model.addAttribute("contact", contact);                                                         //add to the model
        return "ShowContact2";
    }
}
