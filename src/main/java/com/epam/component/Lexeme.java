package com.epam.component;

public class Lexeme implements Component {
    private String element;

    public Lexeme(String element) {
        this.element = element;
    }

    @Override
    public StringBuilder buildText() {
        return new StringBuilder(element);
    }
}
