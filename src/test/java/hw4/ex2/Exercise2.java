package hw4.ex2;

import hw3.enums.CheckboxItem;
import hw3.enums.PageTitle;
import hw3.enums.RadioItem;
import hw4.MetalAndColorsPage;
import hw4.base.BaseTest;
import hw3.enums.HeaderMenuItem;
import hw4.builder.MetalAndColorsData;
import hw4.enums.Colors;
import hw4.enums.Vegetables;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

import static com.codeborne.selenide.Selenide.title;

public class Exercise2 extends BaseTest {

    @DataProvider(name = "dataset")
    public Object[][] getData() {
        return new Object[][]{
                {MetalAndColorsData.builder()
                        .elements(Collections.singletonList(CheckboxItem.EARTH.getName()))
                        .color(Colors.YELLOW)
                        .metal(RadioItem.GOLD)
                        .build()},
                {MetalAndColorsData.builder()
                        .odd(3)
                        .even(8)
                        .vegetables(Arrays.asList(Vegetables.CUCUMBER.getName(), Vegetables.TOMATO.getName()))
                        .build()},
                {MetalAndColorsData.builder()
                        .odd(3)
                        .even(2)
                        .elements(Arrays.asList(CheckboxItem.WIND.getName(), CheckboxItem.FIRE.getName(),
                                CheckboxItem.WATER.getName()))
                        .metal(RadioItem.BRONZE.getName())
                        .vegetables(Collections.singletonList(Vegetables.ONION.getName()))
                        .build()},
                {MetalAndColorsData.builder()
                        .odd(5)
                        .even(6)
                        .elements(Collections.singletonList(CheckboxItem.WATER.getName()))
                        .color(Colors.GREEN.getName())
                        .metal(RadioItem.SELEN.getName())
                        .vegetables(Arrays.asList(Vegetables.CUCUMBER.getName(), Vegetables.TOMATO.getName(),
                                Vegetables.VEGETABLES.getName(), Vegetables.ONION.getName()))
                        .build()},
                {MetalAndColorsData.builder()
                        .elements(Collections.singletonList(CheckboxItem.FIRE))
                        .color(Colors.BLUE.getName())
                        .vegetables(Arrays.asList(Vegetables.CUCUMBER.getName(),
                                Vegetables.TOMATO.getName(), Vegetables.VEGETABLES.getName()))
                        .build()},
        };
    }

    @Test(dataProvider = "dataset")
    public void exercise2Test(MetalAndColorsData data) {

        hp.clickOnHeaderMenuItem(HeaderMenuItem.METALS_AND_COLORS);

        MetalAndColorsPage mcp = new MetalAndColorsPage();

        Assert.assertEquals(title(), PageTitle.METAL_AND_COLORS.getName());

        mcp.fillForm(data);

        mcp.submitForm();

        mcp.checkForm();
    }
}
