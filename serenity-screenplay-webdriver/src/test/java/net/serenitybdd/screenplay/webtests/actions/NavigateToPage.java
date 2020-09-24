package net.serenitybdd.screenplay.webtests.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.webtests.pages.JLNavigationBar;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateToPage extends PageObject implements Task {
    private final String menu;
    String item;

    public NavigateToPage(String menu){
        this.menu = menu;
    }

    public static NavigateToPage withMenu(String menu){
        return instrumented(NavigateToPage.class, menu);
    }

    public NavigateToPage selectItem(String item){
        this.item = item;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        waitABit(10000);

        actor.attemptsTo(
                WaitAndClick.forElement(By.cssSelector(JLNavigationBar.category(menu))));

        if (item != null) {
            actor.attemptsTo(
                    WaitAndClick.forElement(By.cssSelector(JLNavigationBar.subCategory(item))));
        }
    }
}
