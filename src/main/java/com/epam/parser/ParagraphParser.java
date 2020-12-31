package com.epam.parser;

import com.epam.component.Component;
import com.epam.component.Separator;
import com.epam.component.TextComposite;

public class ParagraphParser extends AbstractParser {
    private static final String SENTENCE_REGEX="[.?!]";
    AbstractParser parser = new SentenceParser();

    @Override
    public TextComposite parse(String text) {
        TextComposite textComposite = new TextComposite(Separator.PARAGRAPH);
        String[] sentenceText=text.split(SENTENCE_REGEX);
        for (String  sentence:sentenceText) {
            Component result = parser.parse(sentence);
            textComposite.add(result);
        }
        return parser.parse(text);
    }
}
