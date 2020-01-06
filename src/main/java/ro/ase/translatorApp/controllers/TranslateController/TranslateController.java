package ro.ase.translatorApp.controllers.TranslateController;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.ase.translatorApp.TranslatorManager;
import ro.ase.translatorApp.abstractizations.ITranslatorManager;

@RestController
@EnableAutoConfiguration
public class TranslateController {

    private static final ITranslatorManager _translatorManager = new TranslatorManager();

    @RequestMapping(value = "/api/translate", method = RequestMethod.GET)
    public String getTranslation(String input, String inputLang, String outputLang)
    {
        return _translatorManager.translate(input, inputLang, outputLang);
    }
}