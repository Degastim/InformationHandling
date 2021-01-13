package com.epam.service;


import com.epam.component.Component;
import com.epam.component.Separator;
import com.epam.component.TextComposite;
import com.epam.parser.TextParser;

import java.util.Comparator;
import java.util.List;

public class TextService {
    public TextComposite sortParagraphs(String text,Comparator<? super Component> comparator) {
        TextParser parser = new TextParser(Separator.TEXT);
        TextComposite composite = parser.parse(text);
        List<Component> list = composite.getList();
        list.sort(comparator);
        composite.set(list);
        return composite;
    }
}
