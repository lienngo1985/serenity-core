package net.serenitybdd.screenplay.webtests.integration;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.webtests.actions.NavigateToPage;
import net.serenitybdd.screenplay.webtests.model.Category;
import net.serenitybdd.screenplay.webtests.model.SubCategory;
import net.serenitybdd.screenplay.webtests.tasks.JLLoginWebApp;
import net.serenitybdd.screenplay.webtests.tasks.JLOpenWebApp;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import static net.serenitybdd.screenplay.GivenWhenThen.*;


@RunWith(SerenityRunner.class)
public class JLWhenDanaAddNewSite {
    @Managed(driver = "chrome", options = "--whitelisted-ips")
    WebDriver browser;

    Actor dana = new Actor("Dana");

    @Before
    public void prepareBrowser() {
        dana.can(BrowseTheWeb.with(browser));
        givenThat(dana).wasAbleTo(jlOpenWebApp);
        givenThat(dana).wasAbleTo(jlLoginJLWebApp);
    }

    @Test
    public void addNewSite(){
        givenThat(dana).wasAbleTo(NavigateToPage.withMenu(Category.SITES.getName()).selectItem(SubCategory.ADDSITE.getName()));

      /*  dana.should(
                seeThat(the(JLSitesAddSitePage.DDCUSTOMER),isCurrentlyVisible()),
                seeThat(the(JLSitesAddSitePage.TXTSITE),isCurrentlyVisible())
        );*/
        //dana.wasAbleTo(jlAddNewSite);
       /* when(dana).attemptsTo(JLAddNewSite
                .withCustomer("Candy Crush")
                .withSite("TESTSITE091420"));*/
    }

    @Steps
    JLOpenWebApp jlOpenWebApp;

    @Steps
    JLLoginWebApp jlLoginJLWebApp;
}
