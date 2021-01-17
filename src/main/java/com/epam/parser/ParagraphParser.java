package com.epam.parser;

import com.epam.component.Component;
import com.epam.component.Lexeme;
import com.epam.component.Separator;
import com.epam.component.TextComposite;

public class ParagraphParser extends AbstractParser {
    private AbstractParser parser = null;
    private final Separator level;
    private static final Separator SEPARATOR = Separator.PARAGRAPH;
    private final String REGEX = "(?<=[.!?])\\s+";

    public ParagraphParser(Separator level) {
        this.level = level;
    }

    @Override
    public TextComposite parse(String text) {
        parser = new SentenceParser(level);
        Component result;
        TextComposite textComposite = new TextComposite(SEPARATOR);
        String[] sentenceText = text.split(REGEX);
        for (String sentence : sentenceText) {
            if (level.ordinal() >= SEPARATOR.ordinal()) {
                result = parser.parse(sentence.trim());
            } else {
                result = new Lexeme(sentence);
            }
            textComposite.add(result);
        }
        return textComposite;
    }
}
