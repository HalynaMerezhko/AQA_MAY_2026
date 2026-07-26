package org.prog.session17.steps;

import org.openqa.selenium.By;

public enum GooglePageElements {
    SEARCH_INPUT(By.name("q")),
    SEARCH_BUTTON(By.name("search"));

    private By locator;

    GooglePageElements(By locator) {
        this.locator = locator;
    }

    public By getLocator() {
        return locator;
    }
}
