package framework.tests.pages;

import framework.constants.SelectorType;
import framework.utils.WebUI;

public class ToDoPage {
    public void addNew(String task) {
        WebUI.type(SelectorType.CSS, ".new-todo", task);
    }
}
