package ro.ase.translatorApp;

import ro.ase.translatorApp.abstractizations.IExternalServiceClient;
import ro.ase.translatorApp.abstractizations.ITranslatorManager;
import ro.ase.translatorApp.cache.Cache;

public class TranslatorManager implements ITranslatorManager {

    private static final IExternalServiceClient _externalServiceClient = new ExternalServiceClient();

    @Override
    public void translate(String input, String inputLang, String outputLang) {
        Cache cache = new Cache();
        cache.GetDataFromFile();

        if(!cache.CacheTranslate(input, inputLang, outputLang))
        _externalServiceClient.translate(input, inputLang, outputLang);
        else return;
    }
}