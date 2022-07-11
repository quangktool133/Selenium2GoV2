/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hanlg.selenium2gov2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author DELL
 */
public class Main {
    public static void main(String[] args) {
        WebDriver myBrowser;
         WebDriverManager.chromedriver().setup();
         
         myBrowser = new ChromeDriver();
         
         myBrowser.get("https://phptravels.net/login");
         // trang login len r thi ta đi tìm username vs pass de đổ data vô
         // sau do ta click Login -> thấy Hi, FullName
    
    
    
    
    // tìm ô nhập userName
        WebElement userName =myBrowser.findElement(By.name("username"));
        userName.sendKeys("quangktool133@gmail.com");
        
        WebElement password =myBrowser.findElement(By.name("password"));
        password.sendKeys("ktool133");
        
        
        ////form[@id='loginfrm']//button
        WebElement btnLogin = myBrowser.findElement(By.xpath("//form[@id='loginfrm']//button"));
        btnLogin.click();
        
        try {
            //chuyển trang
            //chờ 1 xíu dể trang render xong, -> v mới tìm dc các tag
            //VIP, Rất Quan Trọng
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
        //đi tìm thẻ Welcome
        WebElement msg = myBrowser.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[1]/div/div[2]/h3"));
        System.out.println("Welcome msg: " + msg.getText());
    
    }   
    //Test Case: Check if the login process shows correct full name
    //Steps:
    //1. Open a certain web brower, e.g. Chrome
    //2. Type the following URL: https://phptravels.net/login
    //      *Expected: the login page appears, with 3 elements:
    //                                  username textbox, password textbox, login button
    //3. Type a pre-registered account/ existed account, e.g.quangld...
    //4. Hit the login button
    // *Expected: a dashboard/main page appears with the Welcome msg
    // Hi, FullName. In this case, the Welcome msg will be Hi, Quang KTool
    //Status: ??? chờ chạy mới biết được, test tay mới biết được
}
