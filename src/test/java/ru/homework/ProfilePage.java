package ru.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    private final WebDriver driver;
    private final static String FILM_TITLE_CSS_SELECTOR = ".broadPosterBlock__title";

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

   public String filmIsInMyList() {
       return driver.findElement(By.cssSelector(FILM_TITLE_CSS_SELECTOR)).getText();
   }
}
