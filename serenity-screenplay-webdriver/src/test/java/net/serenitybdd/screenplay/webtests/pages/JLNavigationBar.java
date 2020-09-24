package net.serenitybdd.screenplay.webtests.pages;

import net.serenitybdd.core.pages.PageObject;

public class JLNavigationBar extends PageObject {
    public static String category(String category)
    {
        category = "a[id=" + category + "Menu]";
        return category;
    }

    public static String subCategory(String subCategory)
    {
        subCategory = "a[id=" + subCategory + "Menu]";
        return subCategory;
    }
}
