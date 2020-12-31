package com.epam.component;

public enum Separator {
    TEXT("\n"),
    PARAGRAPH("."),
    SENTENCE(" "),
    WORD("");
    private String string;
    Separator(String string) {
        this.string=string;
    }

    public String getString() {
        return string;
    }
}
