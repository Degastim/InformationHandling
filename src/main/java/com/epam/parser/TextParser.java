package com.epam.parser;

import com.epam.component.Component;
import com.epam.component.Lexeme;
import com.epam.component.Separator;
import com.epam.component.TextComposite;

public class TextParser extends AbstractParser {
    private AbstractParser parser = null;
    private final Separator level;
    private static final String REGEX = "\\n\\s";
    private static final Separator SEPARATOR = Separator.TEXT;

    public TextParser(Separator level) {
        this.level = level;
    }

    @Override
    public TextComposite parse(String text) {
        parser = new ParagraphParser(level);
        TextComposite textComposite = new TextComposite(SEPARATOR);
        String[] paragraphText = text.split(REGEX);
        for (String paragraph : paragraphText) {
            Component result;
            if (level.ordinal() >= SEPARATOR.ordinal()) {
                result = parser.parse(paragraph);
            } else {
                result = new Lexeme(paragraph);
            }
            textComposite.add(result);
        }
        return textComposite;
    }
}
