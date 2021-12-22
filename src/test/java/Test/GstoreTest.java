package Test;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class GstoreTest {
    @Before
    public void setup(){
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = true;
    }
    @Test
    public void authorization() {
        open("https://gstore.ua/?gclid=Cj0KCQiAnuGNBhCPARIsACbnLzpIm0BunNyor6hcWxx9U2nLgtBOfdnQK-V0vDatFLojDQgOK4Pne48aAncaEALw_wcB");
        $(By.xpath("//a[@class = 'userbar__button __active']")).click();
        $(By.xpath("//*[@id=\"login_form_id\"]/dl/dd[1]/input")).setValue("killativspidey@gmail.com");
        $(By.xpath("//*[@id=\"login_form_id\"]/dl/dd[2]/input")).setValue("Gimno3000").pressEnter();
        $(By.xpath("//input[@class = 'search__input']")).setValue("iphone");
        $(By.xpath("//button[@class = 'search__button']")).click();
        $(By.xpath("//button[@class = 'search__button']")).click();
    }
    @Test
    public void order(){
        $(By.xpath("//a[@id='j-buy-button-widget-421']")).click();
        String numberOfProduct = $(By.xpath("//*[@id=\"product_d2ae9b849ca51f72ff346193c93afd04\"]/td[3]/div/div/div[1]/div/input")).getAttribute("Value");
        Assert.assertEquals("1", numberOfProduct);
        String productName = $(By.xpath("//*[@id=\"product_d2ae9b849ca51f72ff346193c93afd04\"]/td[2]/div[1]/a")).getText();
        Assert.assertEquals("Apple iPhone 8 Plus 64Gb Gold (MQ8N2)", productName);
    }
}
