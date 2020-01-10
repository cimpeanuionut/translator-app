package ro.ase.translatorApp.controllers;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ro.ase.translatorApp.TranslatorManager;
import ro.ase.translatorApp.abstractizations.ITranslatorManager;
import ro.ase.translatorApp.searchedHistory.Language;
import ro.ase.translatorApp.searchedHistory.SearchedTextFactory;
import ro.ase.translatorApp.userManagement.User;
import ro.ase.translatorApp.userManagement.UserDetails;
import ro.ase.translatorApp.userManagement.UserSingleton;

import java.security.Principal;

@RestController
@EnableAutoConfiguration
public class TranslateController {

    private static final ITranslatorManager _translatorManager = new TranslatorManager();

    @RequestMapping(value = "/translate", method = RequestMethod.GET)
    public ModelAndView getTranslation(@RequestParam(value = "inputText") String input, @RequestParam(value = "inputFirstLanguage") String inputLang, @RequestParam(value = "inputSecondLanguage") String outputLang, Principal principal)
    {
        UserSingleton userSingleton = UserSingleton.getInstance();
        if(userSingleton.getCurrentUser() == null){
            for(User user: userSingleton.getUsers()){
                if(user.getUsername().equals(principal.getName())){
                    userSingleton.setCurrentUser(user);
                }
            }
        }
        if(inputLang == null && input != null &&
                userSingleton.getCurrentUser().getUsername().equals(principal.getName()) &&
                userSingleton.getCurrentUser() instanceof UserDetails) {
        	UserDetails userDetails = (UserDetails)userSingleton.getCurrentUser();
	        if(Language.contains(inputLang.toUpperCase()).isNull()){
	                userDetails.addSearchText(SearchedTextFactory.createText(userDetails.getRol(), Language.valueOf(inputLang.toUpperCase()) , input));
	        } else {
	        	userDetails.addSearchText(SearchedTextFactory.createText(userDetails.getRol(), null , input));
	        }
        }
        
        ModelAndView mav = new ModelAndView("home");
        String result = _translatorManager.translate(input, inputLang, outputLang);
        mav.addObject("outputText", result);
        mav.addObject("inputText", input);
        mav.addObject("inputSecondLanguage", outputLang);
       return mav;
    }
}
