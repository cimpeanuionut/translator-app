package ro.ase.translatorApp.controllers.TranslateController;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping(value = "/api/translate", method = RequestMethod.GET)
    public String getTranslation(String input, String inputLang, String outputLang, Principal principal)
    {
        UserSingleton userSingleton = UserSingleton.getInstance();
        if(userSingleton.getCurrentUser() == null){
            for(User user: userSingleton.getUsers()){
                if(user.getUsername().equals(principal.getName())){
                    userSingleton.setCurrentUser(user);
                }
            }
        }
        if(inputLang != null && input != null &&
                userSingleton.getCurrentUser().getUsername().equals(principal.getName()) &&
                userSingleton.getCurrentUser() instanceof UserDetails
        && Language.contains(inputLang.toUpperCase())){
                UserDetails userDetails = (UserDetails)userSingleton.getCurrentUser();
                userDetails.addSearchText(SearchedTextFactory.createText(userDetails.getRol(), Language.valueOf(inputLang.toUpperCase()), input));

        }
        return _translatorManager.translate(input, inputLang, outputLang);
    }
}
