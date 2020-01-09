package ro.ase.translatorApp;

import ro.ase.translatorApp.abstractizations.IExternalServiceClient;
import ro.ase.translatorApp.abstractizations.ITranslatorManager;
import ro.ase.translatorApp.cache.Cache;

public class TranslatorManager implements ITranslatorManager {

    private static final IExternalServiceClient _externalServiceClient = new ExternalServiceClient();

    @Override
    public String translate(String input, String inputLang, String outputLang) {
        Cache cache = new Cache();
        String outputWord = "";
        if(cache.CacheTranslate(input, inputLang, outputLang).isEmpty()) {
            outputWord = _externalServiceClient.translate(input, inputLang, outputLang);
            cache.AddNewWordsToCache(input, inputLang, outputWord, outputLang);
        }
        else outputWord = cache.CacheTranslate(input, inputLang, outputLang);
        //De mutat la inchidere in aplicatie
        cache.SaveDataToCache();
        return outputWord;
    }
}