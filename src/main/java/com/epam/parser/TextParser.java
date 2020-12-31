package com.epam.parser;

import com.epam.component.Component;
import com.epam.component.Separator;
import com.epam.component.TextComposite;

public class TextParser extends AbstractParser {
    private AbstractParser parser = new ParagraphParser();

    @Override
    public TextComposite parse(String text) {
        TextComposite textComposite = new TextComposite(Separator.TEXT);
        String[] paragrathText = text.split(Separator.TEXT.getString());
        for (String paragrath : paragrathText) {
            Component result = parser.parse(paragrath);
            textComposite.add(result);
        }
        return textComposite;
    }
}
