package com.epam.component;

public class Lexeme implements Component {
    private String element;

    public Lexeme(String element) {
        this.element = element;
    }

    @Override
    public String buildText() {
        return element;
    }

    @Override
    public int size() {
        return element.length();
    }
}
