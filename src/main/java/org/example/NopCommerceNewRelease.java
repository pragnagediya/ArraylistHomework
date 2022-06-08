package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class NopCommerceNewRelease extends Utils {
    public void checkURLOfThePage() {
        //Verify that user is on the nopcommerce new release page (Assert Point - verify URL)
        String actualNopCommerceNewReleaseUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualNopCommerceNewReleaseUrl.contains("release"), "your register url does not contain release word");
    }

    //Verify the title of the page "nopCommerce new release!" (Assert Point - verify Title)
    public void checkTitleOfThePage() {
        String expectedTitle = "nopCommerce new release!";
        String actualTitle = getTextFromElement(By.className("page-title"));
        Assert.assertEquals(actualTitle, expectedTitle);

    }

    //Enter Title
    public void enterTitle() {
        typeText(By.id("AddNewComment_CommentTitle"), "productNike");

    }

    //Enter Comment
    public void enterComment() {
        typeText(By.id("AddNewComment_CommentText"), "good");
    }

    //Click on New Comment Button
    public void clickOnCommentButton() {
        clickOnElement(By.name("add-comment"));

    }

    //Verify comment added message "News comment is successfully added." (Assert Point - verify Message)
    public void verifyMessageAfterClickingCommentButton() {
        String actualMessage = getTextFromElement(By.className("result"));
        String expectedMessage = "News comment is successfully added.";
        Assert.assertEquals(actualMessage, expectedMessage, "News comment is not successfully added.");
    }

    //Verify that user's comment has been added to the comments list (Assert Point - Comment has been added to the list)
    public void verifyCommentHasBeenAddedToTheCommentList() {
        String title = "productNike";
        //Verify that user's comment has been added to the comments list (Assert Point - Comment has been added to the list)
        List<WebElement> comments = driver.findElements(By.xpath("//div[@class='comment-title']"));
        List<String> listOfComments = new ArrayList<>();
        for (WebElement we : comments) {
            listOfComments.add(we.getText());
        }
        Assert.assertTrue(listOfComments.contains(title));
        String lastComment = listOfComments.get(listOfComments.size() - 1);
        System.out.println(lastComment);
        Assert.assertEquals(lastComment, title, "Comments are not listed in order");
    }


}