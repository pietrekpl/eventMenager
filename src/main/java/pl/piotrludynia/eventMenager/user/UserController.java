package pl.piotrludynia.eventMenager.user;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.piotrludynia.eventMenager.user.User;

import javax.validation.Valid;
import java.util.List;


@Controller

public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.GET)
    public String viewForm(@ModelAttribute("user") User user) {
        return "createUserForm";
    }

    @RequestMapping(value = "/createUser/confirm", method = RequestMethod.POST)
    public String serveFormular(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        try {
            boolean score = userService.created(user.getName(), user.getLastName(), user.getLogin(),
                    user.getPassword(), user.getEmail(), user.getDate());
            model.addAttribute("userCreated", score);
        } catch (Exception e) {
            e.getMessage();
        }

        if (result.hasErrors()) {
            return "createUserForm";
        } else {
            return "confirmation";
        }
    }

    @RequestMapping(value = "/showUserList", method = RequestMethod.GET)
    public String showUserList(Model model){
        List<User> listOfUsers = userService.listOfUsers();
        model.addAttribute("userList",listOfUsers);
        return "userList";
    }
    @RequestMapping(value ="/deleteUser/{id}",method = RequestMethod.GET)
    public String deleteUser(@PathVariable long id, Model model){
        userService.deleteUser(id);
        List<User> listOfUsers = userService.listOfUsers();
        model.addAttribute("userList",listOfUsers);
        return "userList";
    }

    @GetMapping("/user/join")
    public String userJoin(@RequestParam Long id, Authentication auth){
       userService.addUserToEvent(id, auth.getName());
       return "joinUserToEvent";
    }
}
