package com.epam.service;

import com.epam.component.Component;
import com.epam.component.Separator;
import com.epam.component.TextComposite;
import com.epam.parser.TextParser;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TextService {
    public TextComposite sortParagraphs(String text, Comparator<? super Component> comparator) {
        TextParser parser = new TextParser(Separator.TEXT);
        TextComposite composite = parser.parse(text);
        List<Component> list = composite.getList();
        list.sort(comparator);
        composite.set(list);
        return composite;
    }

    public List<Component> findSentencesWithLongestWord(String text) {
        List<Component> resultList;
        Optional<Component> longestWord;
        int size;
        TextParser parser = new TextParser(Separator.SENTENCE);
        TextComposite textComposite = parser.parse(text);
        List<Component> paragraphList = textComposite.getList();
        longestWord = paragraphList.stream().map(o -> (TextComposite) o).flatMap(o -> o.getList().stream())
                .map(o -> (TextComposite) o).flatMap(o -> o.getList().stream())
                .max(Comparator.comparingInt(Component::size));
        size = longestWord.get().size();
        resultList = paragraphList.stream().map(o -> (TextComposite) o).flatMap(o -> o.getList().stream())
                .map(o -> (TextComposite) o).flatMap(o -> o.getList().stream()).filter(o -> o.size() == size)
                .collect(Collectors.toList());
        return resultList;
    }

    public boolean removeFromTextSentencesWithLessNumberWord(String text, int number) {
        TextParser parser = new TextParser(Separator.PARAGRAPH);
        TextComposite textComposite = parser.parse(text);
        List<Component> paragraphList = textComposite.getList();
       for(Component paragraphComponent: paragraphList) {
            List<Component> sentenceComposite=((TextComposite)paragraphComponent).getList();
            for(Component sentenceComponent:sentenceComposite) {
                List<Component> SentenceList    =((TextComposite)sentenceComponent).getList();
            }
        }
       return false;
    }
}
