package tests.day21_ReusableMethods_HTMLReports;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HepsiburadaPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;


public class C02_Odev_Hepsiburada {
    //Hepsiburada sayfasına gidiniz
    //Elektronik altında bilgisayar/tablet altındaki tüm linkleri tıklayalım
    //Her linkten sonra o sayfaya gittimizi test edelim ve o sayfanın resmini alalım
    //Sayfayı kapatalım
    HepsiburadaPage hepsiburadaPage;
    Actions actions;

    @Test
    public void test01() throws InterruptedException, IOException {
        //Hepsiburada sayfasına gidiniz
        Driver.getDriver().get("https://www.hepsiburada.com");
        //Elektronik altında bilgisayar/tablet altındaki tüm linkleri tıklayalım
        //Her linkten sonra o sayfaya gittimizi test edelim ve o sayfanın resmini alalım
        hepsiburadaPage = new HepsiburadaPage();
        actions = new Actions(Driver.getDriver());
        ReusableMethods.hover(hepsiburadaPage.elektronik);
        ReusableMethods.hover(hepsiburadaPage.bilgisayarTablet);
        for (int i = 0; i < hepsiburadaPage.altBasliklar.size(); i++) {
            ReusableMethods.waitFor(5);
            hepsiburadaPage.altBasliklar.get(i).click();
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            ReusableMethods.waitFor(5);
            ReusableMethods.getScreenshot("hepsiburada");
            Assert.assertTrue(hepsiburadaPage.sonucYazi.isDisplayed());
            ReusableMethods.waitFor(2);
            ReusableMethods.hover(hepsiburadaPage.elektronik);
            ReusableMethods.waitFor(2);
            ReusableMethods.hover(hepsiburadaPage.bilgisayarTablet);
        }
         Driver.closeDriver();
    }
}
