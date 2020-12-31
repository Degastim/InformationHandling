package com.epam.parser;

import com.epam.component.Lexeme;
import com.epam.component.Punctuation;
import com.epam.component.Separator;
import com.epam.component.TextComposite;

public class WordParser extends AbstractParser {
    @Override
    public TextComposite parse(String text) {
        TextComposite lexemeText = new TextComposite(Separator.WORD);
        String[] lexemes = text.split(Separator.PARAGRAPH.getString());
        for (String lexeme : lexemes) {
            if (lexeme.equals(",")) {
                lexemeText.add(new Punctuation(lexeme));
            } else {
                lexemeText.add(new Lexeme(lexeme));
            }
        }
        return lexemeText;
    }
}
