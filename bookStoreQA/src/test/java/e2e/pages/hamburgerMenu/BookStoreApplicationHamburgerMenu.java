package e2e.pages.hamburgerMenu;

import e2e.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookStoreApplicationHamburgerMenu extends PageBase {
    public BookStoreApplicationHamburgerMenu(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='element-list collapse show']//li[@id='item-0']")
    WebElement loginHamburgerButton;
    @FindBy(xpath = "//div[@class='element-list collapse show']//li[@id='item-2']")
    WebElement bookStoreHamburgerButton;
    @FindBy(xpath = "(//li[@id='item-3'])[5]")
    WebElement profileHamburgerButton;
    @FindBy(xpath = "//div[@class='element-list collapse show']//li[@id='item-4']")
    WebElement bookStoreAPI;

    public void clickLoginHamburgerButton(){
        click(loginHamburgerButton);
    }
    public void clickBookStoreHamburgerButton(){
        click(bookStoreHamburgerButton);
    }
    public void clickProfileHamburgerButton(){
        click(profileHamburgerButton);
    }
    public void clickBookStoreAPI(){
        click(bookStoreAPI);
    }
}
