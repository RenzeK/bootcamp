using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace bootcamp
{
    [TestClass]
    public class UnitTest2
    {
        [TestMethod]
        public void TestMethod1()
        {
            String urlTest = "techblog.polteq.com/testshop/index.php";
            IWebDriver browser = new ChromeDriver();
            browser.Navigate().GoToUrl("https://"+ urlTest);
            browser.FindElement(By.ClassName("login")).Click();
            //browser.FindElement(By.className("login")).click();
            browser.FindElement(By.Id("email")).SendKeys("renze.klamer@polteq.com");
            browser.FindElement(By.Id("passwd")).SendKeys("Mijn-1956");
            browser.FindElement(By.Id("SubmitLogin")).Click();
            IWebElement header = browser.FindElement(By.ClassName("logout"));
            Assert.IsTrue(header.Displayed);
            browser.Close();
        }
    }
}

