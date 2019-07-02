package hw4.ex2;

import hw3.enums.PageTitle;
import hw4.MetalAndColorsPage;
import hw4.base.BaseTest;
import hw3.enums.HeaderMenuItem;
import hw4.builder.MetalAndColorsData;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.title;

public class Exercise2 extends BaseTest {

    @Test(dataProvider = "dataset")
    public void exercise2Test(MetalAndColorsData data) {

        hp.clickOnHeaderMenuItem(HeaderMenuItem.METALS_AND_COLORS);

        MetalAndColorsPage mcp = new MetalAndColorsPage();

        Assert.assertEquals(title(), PageTitle.METAL_AND_COLORS.getName());

        mcp.fillForm(data);

    }
}
