package ru.homework;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import java.time.Duration;

public class StepDefinitions {

    public static final WebDriver driver;
    public static final HomePage homePage;
    public static final FilmPage filmPage;
    public static final ProfilePage profilePage;

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Masha\\IdeaProjects\\module-35-homework\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        filmPage = new FilmPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @Given("url of service {string}")
    public void url_of_service(String url) {
        homePage.go(url);
    }

    @Then("click search button")
    public void click_search_button() {
        homePage.startSearching();
    }

    @And("type film title {string}")
    public void type_film_title(String filmTitle) {
        homePage.enterFilmTitle(filmTitle);
    }

    @And("choose first")
    public void choose_first() {
        homePage.chooseFirstFilm();
    }

    @Then("click on bookmark")
    public void click_on_bookmark() {
        filmPage.addToWatchLaterList();
    }

    @And("hover on profile button and click watch later list")
    public void hover_on_profile_button_and_click_watch_later_list() {
       filmPage.goToProfile();
    }

    @Then("film {string} is in my list")
    public void film_is_in_my_list(String enteredTitle) {
        String actualTitle = profilePage.filmIsInMyList();
        actualTitle.toLowerCase().contains(enteredTitle);
        System.out.println(actualTitle.toLowerCase().contains(enteredTitle));
    }

    //
    // for negative scenario
    @Then("hover on profile button and click registration button")
    public void hover_on_profile_button_and_click_registration_button() {
        homePage.startRegistration();
    }

    @Then("enter phone number {string}")
    public void enter_phone_number(String phoneNumber) {
        homePage.enterPhoneNumber(phoneNumber);
    }

    @And("push button to continue")
    public void push_button_to_continue() {
        homePage.confirmPhoneNumber();
    }

    @Then("assert that user got message {string}")
    public void assert_that_user_got_message(String errorMessage) {
        String actualMessage = homePage.errorMessage();
        System.out.println(actualMessage);
        assertEquals(errorMessage, actualMessage);
    }


}
