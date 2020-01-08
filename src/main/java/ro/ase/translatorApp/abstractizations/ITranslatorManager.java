package ro.ase.translatorApp.abstractizations;

public interface ITranslatorManager {
    String translate(String input, String inputLang, String outputLang);
}