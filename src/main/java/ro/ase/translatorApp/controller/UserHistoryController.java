package ro.ase.translatorApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.ase.translatorApp.searchedHistory.Language;
import ro.ase.translatorApp.searchedHistory.SearchedText;
import ro.ase.translatorApp.userManagement.UserDetails;
import ro.ase.translatorApp.userManagement.UserSingleton;

@Controller
public class UserHistoryController {
    private UserSingleton userSingleton = UserSingleton.getInstance();

    @RequestMapping(value = "/searchedHistory", method = RequestMethod.GET)
    @ResponseBody
    public String searchedHistory(@RequestParam String language) {
       UserSingleton userSingleton = UserSingleton.getInstance();
       StringBuilder searchedText = new StringBuilder();
       if(userSingleton.getCurrentUser() != null && userSingleton.getCurrentUser() instanceof UserDetails){
           for(SearchedText text: ((UserDetails)userSingleton.getCurrentUser()).getIstoricCautari()){
               if(text.getLanguage().equals(Language.valueOf(language.toUpperCase()))){
                   searchedText.append(text.getPhrase()).append("\n");
               }
           }
       }
        return searchedText.toString();
    }
}
