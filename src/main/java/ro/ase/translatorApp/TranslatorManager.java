package ro.ase.translatorApp;

import ro.ase.translatorApp.abstractizations.IExternalServiceClient;
import ro.ase.translatorApp.abstractizations.ITranslatorManager;

public class TranslatorManager implements ITranslatorManager {

    private static final IExternalServiceClient _externalServiceClient = new ExternalServiceClient();

    @Override
    public String translate(String input, String inputLang, String outputLang) {
        return  _externalServiceClient.translate(input, inputLang, outputLang);
    }
}