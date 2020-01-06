package ro.ase.translatorApp.entities;

import java.util.ArrayList;

public class Response {

    private String code;
    private String lang;
    private ArrayList<String> text;

    public Response() {
    }

    public Response(String code, String lang, ArrayList<String> text) {
        this.code = code;
        this.lang = lang;
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public ArrayList<String> getText() {
        return text;
    }

    public void setText(ArrayList<String> text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return code + " " + lang + " " + text;
    }
}