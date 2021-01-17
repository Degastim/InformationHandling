package com.epam.service;

import com.epam.component.Component;
import com.epam.component.Separator;
import com.epam.component.TextComposite;
import com.epam.exception.ReaderException;
import com.epam.reader.TextReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;


public class TextServiceTest {
    TextService service = new TextService();
    String text;
    TextReader reader=new TextReader();
    @BeforeMethod
    public void setUp() throws ReaderException {
        text= reader.readText("src/main/resources/data/text");
    }

    @Test
    public void testSortParagraphs() throws ReaderException {
        String actual=service.sortParagraphs(text, Comparator.comparingInt(Component::size)).buildText();
        String expected=reader.readText("src/main/resources/testFile/sortTest");
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testFindSentencesWithLongestWord() {
        List<Component> actualList=service.findSentencesWithLongestWord(text);
        TextComposite composite=new TextComposite(Separator.SENTENCE);
        composite.addList(actualList);
        String actual=composite.buildText();
        String expected="ob.toString(a?b:c), ";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testRemoveFromTextSentencesWithLessNumberWord() throws ReaderException {
        String actual=service.removeFromTextSentencesWithLessNumberWord(text,3).buildText();
        String expected=reader.readText("src/main/resources/testFile/removeTest");
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testCountNumberIdenticalWords() {
        Map<String, Long> actual=service.countNumberIdenticalWords(text);
        Map<String,Long> expected=new HashMap<>();
        expected.put("",1L);
        expected.put("but",1L);
        expected.put("software",1L);
        expected.put("reader",2L);
        expected.put("release",1L);
        expected.put("a!=b",1L);
        expected.put("when",2L);
        expected.put("that",3L);
        expected.put("lorem",2L);
        expected.put("passages",1L);
        expected.put("layout...",1L);
        expected.put("only",1L);
        expected.put("has",2L);
        expected.put("publishing",1L);
        expected.put("(five)",1L);
        expected.put("readable",2L);
        expected.put("making",1L);
        expected.put("using",2L);
        expected.put("letraset",1L);
        expected.put("including",1L);
        expected.put("like",2L);
        expected.put("in",1L);
        expected.put("containing",1L);
        expected.put("ob.tostring(a?b:c),",1L);

        expected.put("its",2L);
        expected.put("is",3L);
        expected.put("survived",1L);
        expected.put("it",6L);
        expected.put("look",1L);
        expected.put("typesetting",2L);
        expected.put("-",1L);
        expected.put("remaining",1L);
        expected.put("here),",2L);
        expected.put("faclon9",1L);
        expected.put("as",1L);
        expected.put("at",2L);

        expected.put("versions",1L);
        expected.put("(content",1L);
        expected.put("ipsum",2L);
        expected.put("looking",2L);
        expected.put("page",2L);
        expected.put("layout.",1L);
        expected.put("be",2L);
        expected.put("fact",2L);
        expected.put("бандерлоги.",1L);
        expected.put("here's,",1L);
        expected.put("unchanged.",1L);
        expected.put("distribution",1L);

        expected.put("point",1L);
        expected.put("content",2L);
        expected.put("long",1L);
        expected.put("ipsum!",2L);
        expected.put("sheets.tostring()",1L);
        expected.put("into",1L);
        expected.put("not",1L);
        expected.put("desktop",1L);
        expected.put("more-or-less.",1L);
        expected.put("and",1L);
        expected.put("by.",1L);
        expected.put("of",5L);

        expected.put("electronic",1L);
        expected.put("“динамо”",1L);
        expected.put("leap",1L);
        expected.put("established!",2L);
        expected.put("normal",1L);
        expected.put("a",7L);
        expected.put("opposed",1L);
        expected.put("centuries,",1L);
        expected.put("english?",1L);
        expected.put("will",2L);
        expected.put("recently",1L);
        expected.put("more",5L);

        expected.put("was",1L);
        expected.put("also",1L);
        expected.put("distracted",1L);
        expected.put("(рига)!",1L);
        expected.put("bye",1L);
        expected.put("the",5L);
        expected.put("with",2L);
        expected.put("essentially",1L);
        expected.put("to",1L);
        expected.put("popularised",1L);
        expected.put("pagemaker",1L);
        expected.put("aldus",1L);
        expected.put("welcome.",1L);
        Assert.assertEquals(actual,expected);
    }
}