package tests;

import org.openqa.selenium.By;

import Utilities.BaseClass;
import Utilities.commonMethods;

public class testingJavaFakerTest {

	public static void main(String[] args) {

		System.out.println(commonMethods.generateEmail());
		System.out.println(commonMethods.generateAddress());
		System.out.println(commonMethods.generateBeer());
		System.out.println(commonMethods.chuckNorrisFact());

		commonMethods.sendKeyDynamically(commonMethods.getFakerObject().gameOfThrones().dragon(), BaseClass.getDriver().findElement(By.xpath("")));

	}

}
