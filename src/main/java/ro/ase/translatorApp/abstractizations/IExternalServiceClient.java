package ro.ase.translatorApp.abstractizations;

public interface IExternalServiceClient {
    void translate(String input, String inputLang, String outputLang);
}