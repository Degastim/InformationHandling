package com.epam.component;

public class Punctuation implements Component{
    private String element;
    public Punctuation(String element) {
        this.element=element;
    }

    @Override
    public StringBuilder buildText() {
        return new StringBuilder(element);
    }
}
