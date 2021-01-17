package com.epam.service;

import com.epam.component.Component;
import com.epam.component.Separator;
import com.epam.component.TextComposite;
import com.epam.parser.TextParser;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
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

    public TextComposite removeFromTextSentencesWithLessNumberWord(String text, int number) {
        TextComposite result = new TextComposite(Separator.TEXT);
        TextParser parser = new TextParser(Separator.PARAGRAPH);
        TextComposite textComposite = parser.parse(text);
        List<Component> paragraphList = textComposite.getList();
        for (Component sentence : paragraphList) {
            List<Component> sentenceList = ((TextComposite) sentence).getList();
            List<Component> list = sentenceList.stream().filter(o -> o.size() >= number).collect(Collectors.toList());
            TextComposite listComponent = new TextComposite(Separator.PARAGRAPH);
            if (!list.isEmpty()) {
                listComponent.addList(list);
                result.add(listComponent);
            }
        }
        return textComposite;
    }

    public Map<String, Long> countNumberIdenticalWords(String text) {
        TextParser parser = new TextParser(Separator.SENTENCE);
        TextComposite textComposite = parser.parse(text);
        List<Component> paragraphList = textComposite.getList();
        List<String> wordList = paragraphList.stream()
                .map(o -> (TextComposite) o).flatMap(o -> o.getList().stream())
                .map(o -> (TextComposite) o).flatMap(o -> o.getList().stream())
                .map(Component::buildText).collect(Collectors.toList());
        Map<String, Long> result = wordList.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
        return result;
    }
}
