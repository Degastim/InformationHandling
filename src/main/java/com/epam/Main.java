package com.epam;

import com.epam.component.Component;
import com.epam.component.Separator;
import com.epam.component.TextComposite;
import com.epam.exception.ReaderException;

import com.epam.parser.TextParser;
import com.epam.reader.TextReader;
import com.epam.service.TextService;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ReaderException {
        TextReader reader = new TextReader();
        String text=reader.readText("src/main/resources/data/text");
        TextService textService=new TextService();
        List<Component> list=textService.findSentencesWithLongestWord(text);
        for(Component i:list) {
            System.out.println(i.buildText());
        }
    }
}
