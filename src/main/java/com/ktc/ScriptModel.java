package com.ktc;

public class ScriptModel {
    private int id;
    private int language;
    private String script;

    public ScriptModel(){};

    public ScriptModel(int id, int languageId, String scriptText){
        this.id = id;
        this.language = languageId;
        this.script = scriptText;
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }




}
