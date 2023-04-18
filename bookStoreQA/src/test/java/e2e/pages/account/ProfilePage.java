package e2e.pages.account;

import e2e.pages.PageBase;
import e2e.wait.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertTrue;

public class ProfilePage extends PageBase {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    Wait wait;

    @FindBy(xpath = "(//button[normalize-space()='Log out'])[1]")
    WebElement logOutButton;
    @FindBy(xpath = "//input[@id='searchBox']")
    WebElement searchBooksField;
    @FindBy(xpath = "//span[@id='basic-addon2']")
    WebElement searchButton;
    @FindBy(xpath = "//label[@id='userName-value']")
    WebElement userNameText;
    @FindBy(xpath = "jump to page")
    WebElement jumpPageField;
    @FindBy(xpath = "(//button[normalize-space()='Go To Book Store'])[1]")
    WebElement goToBookStoreButton;
    @FindBy(xpath = "(//button[@id='gotoStore'])[1]")
    WebElement deleteAccountButton;
    @FindBy(xpath = "(//button[@id='submit'])[3]")
    WebElement deleteAllBooksButton;
    @FindBy(xpath = "//button[@id='closeSmallModal-ok']")
    WebElement okConfirmationDeleteBook;
    @FindBy(xpath = "//button[@id='closeSmallModal-cancel']")
    WebElement cancelDeleteBook;
    @FindBy(xpath = "(//div[@role='gridcell'])[2]")
    WebElement tableProfileTextExist;
    @FindBy(xpath = "//div[@class='rt-tbody']")
    WebElement checkingForMissingBooks;


    //добавить WebElement книг которые появляются в таблицу и их удаление по одиночке

    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(logOutButton);
    }

    public void clickLogOutButton() {
        click(logOutButton);
    }

    public void searchBooksField(String nameBooks) {
        searchBooksField.sendKeys(nameBooks);
    }

    public void clickSearchButton() {
        click(searchButton);
    }

    public void selectValuePageRowsList(String value) {
        Select select = new Select(driver.findElement(By.xpath("//select[@aria-label='rows per page']")));
        select.selectByVisibleText(value);
    }

    public void selectJumpPageField(String numberOfPage) {
        jumpPageField.clear();
        jumpPageField.sendKeys(numberOfPage);
    }

    public void clickGoToBookStore() {
        click(goToBookStoreButton);
    }

    public void clickDeleteAccount() {
        click(deleteAccountButton);
    }

    public void clickDeleteAllBooks() {
        click(deleteAllBooksButton);
    }

    public void clickOkConfirmationDeleteBook() {
        click(okConfirmationDeleteBook);
    }

    public void clickCancelDeleteBook() {
        click(cancelDeleteBook);
    }

    //    public boolean isElementBooksExist(){
//        try {
//            driver.findElement((By) checkingForMissingBooks);
//            return true;
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//    }
    public String getUserBooks() {
        return checkingForMissingBooks.getText();
    }


    public Object tableProfileTextExist() {
        return tableProfileTextExist;
    }
}


