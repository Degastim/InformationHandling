package com.epam.parser;

import com.epam.component.Lexeme;
import com.epam.component.Separator;
import com.epam.component.TextComposite;

public class WordParser extends AbstractParser {
    private final Separator level;
    private static final Separator SEPARATOR = Separator.WORD;

    public WordParser(Separator level) {
        this.level = level;
    }

    @Override
    public TextComposite parse(String text) {
        TextComposite lexemeText = new TextComposite(SEPARATOR);
        String[] lexemes = text.split(SEPARATOR.getString());
        for (String lexeme : lexemes) {
            lexemeText.add(new Lexeme(lexeme));
        }
        return lexemeText;
    }
}
