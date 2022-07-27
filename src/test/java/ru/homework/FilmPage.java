package ru.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FilmPage {

    private final WebDriver driver;
    private final static String ADD_TO_FAVORITES_BUTTON_CSS_SELECTOR = "button[data-test='favorite_button']";
    private final static String PROFILE_BUTTON_CSS_SELECTOR = ".headerAvatar__link";
    private final static String MY_WATCH_LATER_LIST_CSS_SELECTOR = "a[href='https://www.ivi.ru/profile/favorites']";

    public FilmPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToWatchLaterList() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ADD_TO_FAVORITES_BUTTON_CSS_SELECTOR)));
        driver.findElements(By.cssSelector(ADD_TO_FAVORITES_BUTTON_CSS_SELECTOR)).get(0).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void goToProfile() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector(PROFILE_BUTTON_CSS_SELECTOR))).perform();
        driver.findElement(By.cssSelector(MY_WATCH_LATER_LIST_CSS_SELECTOR)).click();
    }
}
