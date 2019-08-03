package pl.piotrludynia.eventMenager.user;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.piotrludynia.eventMenager.user.User;

import javax.validation.Valid;


@Controller

public class UserController {

    @RequestMapping(value ="/createUser", method = RequestMethod.GET)
    public String viewForm(@ModelAttribute("user") User user){
        return "createUserForm";
    }
    @RequestMapping(value ="/createUser/confirm", method = RequestMethod.POST)
    public String serveFormular(@Valid @ModelAttribute("user")User user,BindingResult result){
        if (result.hasErrors()){
            return "createUserForm";
        }else {

            return "confirmation";
        }
        }




}
