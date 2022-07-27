package ru.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final WebDriver driver;
    private final static String SEARCH_BUTTON_CSS_SELECTOR = "button[data-test='header_search']";
    private final static String SEARCH_INPUT_CSS_SELECTOR = "input[data-test='search_input']";
    private final static String FIRST_FILM_CSS_SELECTOR = "a[href='https://www.ivi.ru/watch/481418']";
    private final static String PROFILE_BUTTON_CSS_SELECTOR = ".headerAvatar__link";
    private final static String REGISTRATION_BUTTON_CSS_SELECTOR = ".dropdownProfile__authSection>button";
    private final static String INPUT_PHONE_NUMBER_CSS_SELECTOR = "input[data-test='input_login']";
    private final static String CONTINUE_BUTTON_CSS_SELECTOR = "button[data-test='button_continue']";
    private final static String ERROR_MESSAGE_CSS_SELECTOR = ".chatError__title";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void go(String url) {
        driver.get(url);
    }

    public void startSearching() {
        driver.findElement(By.cssSelector(SEARCH_BUTTON_CSS_SELECTOR)).click();
    }

    public void enterFilmTitle(String filmTitle) {
        driver.findElement(By.cssSelector(SEARCH_INPUT_CSS_SELECTOR)).sendKeys(filmTitle);
    }

    public void chooseFirstFilm() {
        driver.findElement(By.cssSelector(FIRST_FILM_CSS_SELECTOR)).click();
    }

    //
    // for negative scenario
    public void startRegistration() {
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PROFILE_BUTTON_CSS_SELECTOR)));
        action.moveToElement(driver.findElement(By.cssSelector(PROFILE_BUTTON_CSS_SELECTOR))).perform();
        driver.findElement(By.cssSelector(REGISTRATION_BUTTON_CSS_SELECTOR)).click();
    }

    public void enterPhoneNumber(String phoneNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(INPUT_PHONE_NUMBER_CSS_SELECTOR)));
        driver.findElement(By.cssSelector(INPUT_PHONE_NUMBER_CSS_SELECTOR)).sendKeys(phoneNumber);
    }

    public void confirmPhoneNumber() {
        driver.findElement(By.cssSelector(CONTINUE_BUTTON_CSS_SELECTOR)).click();
    }

    public String errorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(ERROR_MESSAGE_CSS_SELECTOR)));
        return driver.findElement(By.cssSelector(ERROR_MESSAGE_CSS_SELECTOR)).getText();
    }
}
