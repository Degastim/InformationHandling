package com.epam.component;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements Component {
    private List<Component> list = new ArrayList<>();
    private final Separator separator;

    public TextComposite(Separator separator) {
        this.separator = separator;
    }

    public void add(Component component) {
        list.add(component);
    }

    public void set(List<Component> list) {
        this.list = new ArrayList<>(list);
    }

    public List<Component> getList() {
        return new ArrayList<>(list);
    }

    @Override
    public String buildText() {
        String result = "";
        for (Component component : list) {
            String part = component.buildText();
            part += separator.getString();
            result += part;
        }
        return result;
    }

    @Override
    public int size() {
        return list.size();
    }
}
