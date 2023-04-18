package e2e.tests.books;

import e2e.pages.Books.BooksPage;
import e2e.pages.Books.BooksStorePage;
import e2e.pages.Books.DeleteAllBooks;
import e2e.pages.account.HomePage;
import e2e.pages.account.LoginPage;
import e2e.pages.account.ProfilePage;
import e2e.pages.hamburgerMenu.BookStoreApplicationHamburgerMenu;
import e2e.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AddBooks extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    BooksPage booksPage;
    ProfilePage profilePage;
    BooksStorePage booksStorePage;
    BookStoreApplicationHamburgerMenu bookStoreApplicationHamburgerMenu;
    DeleteAllBooks deleteAllBooks;

    String allBooksDeleted = "All Books deleted.";
    String bookAddedToYourCollection = "Book added to your collection.";
    String checkingExistBook = "Git Pocket Guide";


    @Test
    public void addNewBookInUserAccount(){
//        homePage = new HomePage(app.driver);
//        homePage.waitForLoading();
//        homePage.clickLoginButton();
//
//        loginPage = new LoginPage(app.driver);
//        loginPage.waitForLoading();
//        loginPage.userNameField(userName);
//        loginPage.passwordField(password);
//        loginPage.clickLoginButton();
//
        profilePage = new ProfilePage(app.driver);
        profilePage.waitForLoading();
//        profilePage.clickGoToBookStore();

        booksStorePage = new BooksStorePage(app.driver);
        booksStorePage.waitForLoading();
        booksStorePage.firstBookSelect();

        booksPage = new BooksPage(app.driver);
        booksPage.waitForLoading();
        booksPage.clickAddBookToYourCollectionButton();

        Assert.assertTrue(booksPage.getAlertText().contains(bookAddedToYourCollection));

        booksPage.acceptAlert();
        booksPage.clickBackToBookStoreButton();

        bookStoreApplicationHamburgerMenu = new BookStoreApplicationHamburgerMenu(app.driver);
        bookStoreApplicationHamburgerMenu.clickProfileHamburgerButton();

        profilePage.waitForLoading();
        profilePage.clickDeleteAllBooks();
        profilePage.clickOkConfirmationDeleteBook();

        Assert.assertTrue(profilePage.getAlertText().contains(allBooksDeleted));

        profilePage.acceptAlert();

        String actualResult = profilePage.getUserBooks();
        Assert.assertFalse(actualResult.contains(checkingExistBook));
    }
    @Test
    public void addEightBooks(){

        profilePage = new ProfilePage(app.driver);
        profilePage.waitForLoading();

        booksStorePage = new BooksStorePage(app.driver);
        booksStorePage.waitForLoading();
        booksStorePage.firstBookSelect();
        booksPage = new BooksPage(app.driver);
        booksPage.waitForLoading();
        booksPage.clickAddBookToYourCollectionButton();
        assertTrue(booksPage.getAlertText().contains(bookAddedToYourCollection));
        booksPage.acceptAlert();
        booksPage.clickBackToBookStoreButton();

        booksStorePage.waitForLoading();
        booksStorePage.secondBookSelect();
        booksPage.waitForLoading();
        booksPage.clickAddBookToYourCollectionButton();
        assertTrue(booksPage.getAlertText().contains(bookAddedToYourCollection));
        booksPage.acceptAlert();
        booksPage.clickBackToBookStoreButton();

        booksStorePage.waitForLoading();
        booksStorePage.thirdBookSelect();
        booksPage.waitForLoading();
        booksPage.clickAddBookToYourCollectionButton();
        assertTrue(booksPage.getAlertText().contains(bookAddedToYourCollection));
        booksPage.acceptAlert();
        booksPage.clickBackToBookStoreButton();

        booksStorePage.waitForLoading();
        booksStorePage.fourthBookSelect();
        booksPage.waitForLoading();
        booksPage.clickAddBookToYourCollectionButton();
        assertTrue(booksPage.getAlertText().contains(bookAddedToYourCollection));
        booksPage.acceptAlert();
        booksPage.clickBackToBookStoreButton();

        booksStorePage.waitForLoading();
        booksStorePage.fifthBookSelect();
        booksPage.waitForLoading();
        booksPage.clickAddBookToYourCollectionButton();
        assertTrue(booksPage.getAlertText().contains(bookAddedToYourCollection));
        booksPage.acceptAlert();
        booksPage.clickBackToBookStoreButton();

        booksStorePage.waitForLoading();
        booksStorePage.sixthBookSelect();
        booksPage.waitForLoading();
        booksPage.clickAddBookToYourCollectionButton();
        assertTrue(booksPage.getAlertText().contains(bookAddedToYourCollection));
        booksPage.acceptAlert();
        booksPage.clickBackToBookStoreButton();

        booksStorePage.waitForLoading();
        booksStorePage.seventhBookSelect();
        booksPage.waitForLoading();
        booksPage.clickAddBookToYourCollectionButton();
        assertTrue(booksPage.getAlertText().contains(bookAddedToYourCollection));
        booksPage.acceptAlert();
        booksPage.clickBackToBookStoreButton();

        booksStorePage.waitForLoading();
        booksStorePage.eighthBookSelect();
        booksPage.waitForLoading();
        booksPage.clickAddBookToYourCollectionButton();
        assertTrue(booksPage.getAlertText().contains(bookAddedToYourCollection));
        booksPage.acceptAlert();

        bookStoreApplicationHamburgerMenu = new BookStoreApplicationHamburgerMenu(app.driver);
        bookStoreApplicationHamburgerMenu.clickProfileHamburgerButton();

        profilePage.waitForLoading();
        profilePage.clickDeleteAllBooks();
        deleteAllBooks = new DeleteAllBooks(app.driver);
        deleteAllBooks.waitForLoading();
        deleteAllBooks.clickOkDeleteAllBooks();
        assertTrue(profilePage.getAlertText().contains("All Books deleted."));



        //проверка идет ли удаление = нет//Хотел эту проверку сделать но не понял как можно с вебелемента выхашить текст



    }
    public void FunctionalPageChoseAndRowsList(){


    }

}
