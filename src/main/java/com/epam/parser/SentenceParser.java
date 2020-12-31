package com.epam.parser;

import com.epam.component.Component;
import com.epam.component.Separator;
import com.epam.component.TextComposite;

public class SentenceParser extends AbstractParser {
    private AbstractParser parser = new WordParser();

    @Override
    public TextComposite parse(String text) {
        TextComposite textComposite = new TextComposite(Separator.SENTENCE);
        String[] wordText = text.split(Separator.SENTENCE.getString());
        for (String word : wordText) {
            Component result = parser.parse(word);
            textComposite.add(result);
        }
        return parser.parse(text);
    }
}
