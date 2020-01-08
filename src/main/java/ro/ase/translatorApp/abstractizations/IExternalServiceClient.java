package ro.ase.translatorApp.abstractizations;

public interface IExternalServiceClient {
    String translate(String input, String inputLang, String outputLang);
}