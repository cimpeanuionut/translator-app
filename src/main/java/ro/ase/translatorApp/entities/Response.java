package ro.ase.translatorApp.entities;

import java.util.ArrayList;

public class Response {

    private Integer code;
    private String lang;
    private ArrayList<String> text;

    public Response() {
    }

    public Response(Integer code, String lang, ArrayList<String> text) {
        this.code = code;
        this.lang = lang;
        this.text = text;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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