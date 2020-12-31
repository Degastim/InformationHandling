package com.epam.component;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements Component{
    private List<Component> list=new ArrayList<>();
    private Separator separator;

    public TextComposite(Separator separator) {
        this.separator=separator;
    }
    public void add(Component component) {
        list.add(component);
    }

    @Override
    public StringBuilder buildText() {
        StringBuilder result=new StringBuilder();
        for(Component component:list) {
            StringBuilder part=component.buildText();
            part.append(separator.getString());
            result.append(part);
        }
        return result;
    }
}
