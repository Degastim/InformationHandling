package com.epam;

import com.epam.component.Component;
import com.epam.component.Separator;
import com.epam.component.TextComposite;
import com.epam.exception.ReaderException;

import com.epam.parser.TextParser;
import com.epam.reader.TextReader;
import com.epam.service.TextService;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws ReaderException {
        TextReader reader = new TextReader();
        String text=reader.readText("src/main/resources/data/text");
        TextService textService=new TextService();
        TextComposite composite=textService.sortParagraphs(text, Comparator.comparingInt(Component::size).reversed());
        System.out.println(composite.buildText());
    }
}
