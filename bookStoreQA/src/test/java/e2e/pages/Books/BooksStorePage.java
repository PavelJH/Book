package e2e.pages.Books;

import e2e.pages.PageBase;
import e2e.wait.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.lang.reflect.Method;

public class BooksStorePage extends PageBase {
    public BooksStorePage(WebDriver driver) {
        super(driver);
    }
    Wait wait;
    BooksPage booksPage;
    BooksStorePage booksStorePage;

    String bookAddedToYourCollection = "Book added to your collection.";

    @FindBy(xpath = "//label[@id='userName-value']")
    WebElement nameAccountText;
    @FindBy(xpath = "//a[normalize-space()='Git Pocket Guide']")
    WebElement firstBook;
    @FindBy(xpath = "//a[normalize-space()='Learning JavaScript Design Patterns']")
    WebElement secondBook;
    @FindBy(xpath = "//a[normalize-space()='Designing Evolvable Web APIs with ASP.NET']")
    WebElement thirdBook;
    @FindBy(xpath = "//a[normalize-space()='Speaking JavaScript']")
    WebElement fourthBook;
    @FindBy(css = "a[href='/books?book=9781491904244']")
    WebElement fifthBook;
    @FindBy(xpath = "//a[normalize-space()='Programming JavaScript Applications']")
    WebElement sixthBook;
    @FindBy(xpath = "(//a[normalize-space()='Eloquent JavaScript, Second Edition'])[1]")
    WebElement seventhBook;
    @FindBy(xpath = "//a[normalize-space()='Understanding ECMAScript 6']")
    WebElement eighthBook;
    @FindBy(xpath = "//input[@value='1']")
    WebElement jumpToPageField;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement clickLogOut;

    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(nameAccountText);
    }
    public void firstBookSelect(){
        click(firstBook);
    }
    public void secondBookSelect(){
        click(secondBook);
    }
    public void thirdBookSelect(){
        click(thirdBook);
    }
    public void fourthBookSelect(){
        click(fourthBook);
    }
    public void fifthBookSelect(){
        click(fifthBook);
    }
    public void sixthBookSelect(){
        click(sixthBook);
    }
    public void seventhBookSelect(){
        click(seventhBook);
    }

    public void eighthBookSelect(){
        click(eighthBook);
    }
    public void selectValuePageRowsList(String value) {
        Select select = new Select(driver.findElement(By.xpath("//select[@aria-label='rows per page']")));
        select.selectByVisibleText(value);
    }
    public void selectJumpPageField(String numberOfPage) {
        jumpToPageField.clear();
        jumpToPageField.sendKeys(numberOfPage);
    }

//    public void addAllBook(){
//        booksStorePage.firstBookSelect();
//        booksPage.waitForLoading();
//        booksPage.clickAddBookToYourCollectionButton();
//        Assert.assertTrue(booksPage.getAlertText().contains("bookAddedToYourCollection"));
//        booksPage.acceptAlert();
//        booksPage.clickBackToBookStoreButton();
//
//        booksStorePage.waitForLoading();
//        booksStorePage.secondBookSelect();
//        booksPage.waitForLoading();
//        booksPage.clickAddBookToYourCollectionButton();
//        Assert.assertTrue(booksPage.getAlertText().contains(bookAddedToYourCollection));
//        booksPage.acceptAlert();
//        booksPage.clickBackToBookStoreButton();
//
//        booksStorePage.waitForLoading();
//        booksStorePage.thirdBookSelect();
//        booksPage.waitForLoading();
//        booksPage.clickAddBookToYourCollectionButton();
//        Assert.assertTrue(booksPage.getAlertText().contains(bookAddedToYourCollection));
//        booksPage.acceptAlert();
//        booksPage.clickBackToBookStoreButton();
//
//        booksStorePage.waitForLoading();
//        booksStorePage.fourthBookSelect();
//        booksPage.waitForLoading();
//        booksPage.clickAddBookToYourCollectionButton();
//        Assert.assertTrue(booksPage.getAlertText().contains(bookAddedToYourCollection));
//        booksPage.acceptAlert();
//        booksPage.clickBackToBookStoreButton();
//
//        booksStorePage.waitForLoading();
//        booksStorePage.fifthBookSelect();
//        booksPage.waitForLoading();
//        booksPage.clickAddBookToYourCollectionButton();
//        Assert.assertTrue(booksPage.getAlertText().contains(bookAddedToYourCollection));
//        booksPage.acceptAlert();
//        booksPage.clickBackToBookStoreButton();
//
//        booksStorePage.waitForLoading();
//        booksStorePage.sixthBookSelect();
//        booksPage.waitForLoading();
//        booksPage.clickAddBookToYourCollectionButton();
//        Assert.assertTrue(booksPage.getAlertText().contains(bookAddedToYourCollection));
//        booksPage.acceptAlert();
//        booksPage.clickBackToBookStoreButton();
//
//        booksStorePage.waitForLoading();
//        booksStorePage.seventhBookSelect();
//        booksPage.waitForLoading();
//        booksPage.clickAddBookToYourCollectionButton();
//        Assert.assertTrue(booksPage.getAlertText().contains(bookAddedToYourCollection));
//        booksPage.acceptAlert();
//        booksPage.clickBackToBookStoreButton();
//
//        booksStorePage.waitForLoading();
//        booksStorePage.eighthBookSelect();
//        booksPage.waitForLoading();
//        booksPage.clickAddBookToYourCollectionButton();
//        Assert.assertTrue(booksPage.getAlertText().contains(bookAddedToYourCollection));
//        booksPage.acceptAlert();
//    }
}
