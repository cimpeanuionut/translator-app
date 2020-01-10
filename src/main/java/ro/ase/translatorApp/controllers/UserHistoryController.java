package ro.ase.translatorApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.ase.translatorApp.entities.LanguageForm;
import ro.ase.translatorApp.searchedHistory.SearchedText;
import ro.ase.translatorApp.userManagement.UserDetails;
import ro.ase.translatorApp.userManagement.UserSingleton;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserHistoryController {

    @RequestMapping(value = "/showFormLanguage", method=RequestMethod.GET)
    public String showForm(Model model) {
        LanguageForm languageForm = new LanguageForm();
        model.addAttribute("languageForm", languageForm);
        return "historyForm";
    }

    @RequestMapping(value = "/processFormHistory", method=RequestMethod.POST)
    public String processForm(@ModelAttribute(value="languageForm") LanguageForm languageForm, Model model) {
        String language = languageForm.getLanguage();
        UserSingleton userSingleton = UserSingleton.getInstance();
        List<String> searchedText = new ArrayList<>();
        if(userSingleton.getCurrentUser() != null && userSingleton.getCurrentUser() instanceof UserDetails){
            for(SearchedText text: ((UserDetails)userSingleton.getCurrentUser()).getIstoricCautari()){
                    searchedText.add(text.getPhrase());
            }
        }
        if(searchedText.isEmpty()){
            searchedText.add("No results found");
        }
        model.addAttribute("lang", languageForm.getLanguage());
        model.addAttribute("searchedText", searchedText);
        return "historyDetails";
    }

}
