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
                        .elements(Collections.singletonList(CheckboxItem.EARTH))
                        .color(Colors.YELLOW)
                        .metal(RadioItem.GOLD)
                        .build()},
                {MetalAndColorsData.builder()
                        .oddNumber(3)
                        .evenNumber(8)
                        .vegetables(Arrays.asList(Vegetables.CUCUMBER, Vegetables.TOMATO))
                        .build()},
                {MetalAndColorsData.builder()
                        .oddNumber(3)
                        .evenNumber(2)
                        .elements(Arrays.asList(CheckboxItem.WIND, CheckboxItem.FIRE, CheckboxItem.WATER))
                        .metal(RadioItem.BRONZE)
                        .vegetables(Collections.singletonList(Vegetables.ONION))
                        .build()},
                {MetalAndColorsData.builder()
                        .oddNumber(5)
                        .evenNumber(6)
                        .elements(Collections.singletonList(CheckboxItem.WATER))
                        .color(Colors.GREEN)
                        .metal(RadioItem.SELEN)
                        .vegetables(Arrays.asList(Vegetables.CUCUMBER, Vegetables.TOMATO, Vegetables.VEGETABLES, Vegetables.ONION))
                        .build()},
                {MetalAndColorsData.builder()
                        .elements(Collections.singletonList(CheckboxItem.FIRE))
                        .color(Colors.BLUE)
                        .vegetables(Arrays.asList(Vegetables.CUCUMBER, Vegetables.TOMATO, Vegetables.VEGETABLES))
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
