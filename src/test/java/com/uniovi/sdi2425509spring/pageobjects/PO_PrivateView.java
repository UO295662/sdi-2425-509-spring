package com.uniovi.sdi2425509spring.pageobjects;

import com.uniovi.sdi2425509spring.util.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PO_PrivateView extends PO_NavView {
    static public void fillFormAddMark(WebDriver driver, int userOrder, String descriptionp, String scorep)
    {
        //Esperamos 5 segundo a que carge el DOM porque en algunos equipos falla
        SeleniumUtils.waitSeconds(driver, 5);
        //Seleccionamos el alumnos userOrder
        new Select(driver.findElement(By.id("user"))).selectByIndex(userOrder);
        //Rellenemos el campo de descripción
        WebElement description = driver.findElement(By.name("description"));
        description.clear();
        description.sendKeys(descriptionp);
        WebElement score = driver.findElement(By.name("score"));
        score.click();
        score.clear();
        score.sendKeys(scorep);
        By boton = By.className("btn");
        driver.findElement(boton).click();
    }
    static public void fillFormAddProfessor(WebDriver driver, String dnip, String namep, String surnamep, String categoryp)
    {
        WebElement dni = driver.findElement(By.name("dni"));
        dni.click();
        dni.clear();
        dni.sendKeys(dnip);
        WebElement name = driver.findElement(By.name("name"));
        name.click();
        name.clear();
        name.sendKeys(namep);
        WebElement surname = driver.findElement(By.name("surname"));
        surname.click();
        surname.clear();
        surname.sendKeys(surnamep);
        WebElement category = driver.findElement(By.name("category"));
        category.click();
        category.clear();
        category.sendKeys(categoryp);
        By boton = By.className("btn");
        driver.findElement(boton).click();
    }
    static public void logout(WebDriver driver){
        String loginText = PO_HomeView.getP().getString("signup.message", PO_Properties.getSPANISH());
        PO_PrivateView.clickOption(driver, "logout", "text", loginText);
    }
    static public void check(WebDriver driver,String text,int pos){
        List<WebElement> elements = PO_View.checkElementBy(driver, "free",
                text);
        elements.get(pos).click();
    }
}