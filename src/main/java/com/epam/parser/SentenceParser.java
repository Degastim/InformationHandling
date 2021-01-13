package com.epam.parser;

import com.epam.component.Component;
import com.epam.component.Lexeme;
import com.epam.component.Separator;
import com.epam.component.TextComposite;

public class SentenceParser extends AbstractParser {
    private AbstractParser parser;
    private final Separator level;
    private static final Separator SEPARATOR = Separator.SENTENCE;

    public SentenceParser(Separator level) {
        this.level = level;
    }

    @Override
    public TextComposite parse(String text) {
        parser = new WordParser(level);
        Component result;
        TextComposite textComposite = new TextComposite(SEPARATOR);
        String[] wordText = text.split(SEPARATOR.getString());
        for (String word : wordText) {
            if (level.ordinal() >= SEPARATOR.ordinal()) {
                result = parser.parse(word);
            } else {
                result = new Lexeme(word);
            }
            textComposite.add(result);
        }
        return textComposite;
    }
}
