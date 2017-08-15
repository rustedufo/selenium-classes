package com.mtrading.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by aleksandr.neguritsa on 8/8/2017.
 */
public class DashboardPage {

    private WebDriver webDriver;

    private static final String PAGE_URL = "https://tr3.mtrading.com/dashboard";

    public DashboardPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public String getUrl(){
        return DashboardPage.PAGE_URL;
    }

    public void open(){
        this.webDriver.get(this.getUrl());
    }

}
