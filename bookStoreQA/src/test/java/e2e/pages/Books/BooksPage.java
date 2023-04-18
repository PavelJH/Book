package e2e.pages.Books;

import e2e.pages.PageBase;
import e2e.wait.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksPage extends PageBase {
    public BooksPage(WebDriver driver) {
        super(driver);
    }
    Wait wait;

    @FindBy(xpath = "(//label[@id='userName-value'])[1]")
    WebElement nameUserText;
    @FindBy(xpath = "//button[@id='submit']")
    WebElement logOutButton;
    @FindBy(xpath = "(//label[@id='userName-value'])[9]")
    WebElement webLink;
    @FindBy(xpath = "(//button[@id='addNewRecordButton'])[1]")
    WebElement backToBookStoreButton;
    @FindBy(xpath = "(//button[@id='addNewRecordButton'])[2]")
    WebElement addBookToYourCollectionButton;
    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(nameUserText);
    }
    public void clickLogOutButton(){
        click(logOutButton);
    }
    public void clickWebLink(){
        click(webLink);
    }
    public void clickBackToBookStoreButton(){
        click(backToBookStoreButton);
    }
    public void clickAddBookToYourCollectionButton(){
        click(addBookToYourCollectionButton);
    }
}
