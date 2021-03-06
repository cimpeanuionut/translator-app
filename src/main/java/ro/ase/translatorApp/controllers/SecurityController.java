package ro.ase.translatorApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.ase.translatorApp.userManagement.User;
import ro.ase.translatorApp.userManagement.UserSingleton;

import java.security.Principal;

@Controller
public class SecurityController {

   private UserSingleton userSingleton = UserSingleton.getInstance();

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        for(User user: userSingleton.getUsers()){
            System.out.println(user.getUsername() + " " + principal.getName());
            if(user.getUsername().equals(principal.getName())){
                userSingleton.setCurrentUser(user);
            }
        }
        return userSingleton.getCurrentUser().getUsername();
    }
}
