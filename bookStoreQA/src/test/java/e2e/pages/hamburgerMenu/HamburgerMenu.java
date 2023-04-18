package e2e.pages.hamburgerMenu;

import e2e.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HamburgerMenu extends PageBase {
    public HamburgerMenu(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "(//div[contains(@class,'header-wrapper')])[1]")
    WebElement elementHamburgerElement;
    @FindBy(xpath = "(//div[contains(@class,'header-wrapper')])[2]")
    WebElement formsElement;
    @FindBy(xpath = "(//div[contains(@class,'header-wrapper')])[3]")
    WebElement alertsFrameAndWindowsElement;
    @FindBy(xpath = "(//div[contains(@class,'header-wrapper')])[4]")
    WebElement widgetsElement;
    @FindBy(xpath = "(//div[contains(@class,'header-wrapper')])[5]")
    WebElement interactionsElement;
    @FindBy(xpath = "(//div[contains(@class,'header-wrapper')])[6]")
    WebElement bookStoreApplication;
    public void clickElementHamburgerElement(){
        click(elementHamburgerElement);
    }
    public void clickFormsElement(){
        click(formsElement);
    }
    public void clickAlertsFrameAndWindowsElement(){
        click(alertsFrameAndWindowsElement);
    }
    public void clickWidgetsElement(){
        click(widgetsElement);
    }
    public void clickInteractionsElement(){
        click(interactionsElement);
    }
    public void clickBookStoreApplication(){
        click(bookStoreApplication);
    }
}
