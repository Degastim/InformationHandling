package com.epam.component;

public enum Separator {
    TEXT("\\n\\s"),
    PARAGRAPH("\\s"),
    SENTENCE("\\s"),
    WORD("");
    private String regex;

    Separator(String regex) {
        this.regex = regex;
    }

    public String getString() {
        return regex;
    }
}
