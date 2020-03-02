using OpenQA.Selenium.Winium;
using System;
using System.IO;

namespace CalcCheck.Driver
{
    public static class DriverManager
    {
        private const string calculatorAppPath = @"C:/windows/system32/calc.exe";
        private static WiniumDriver driver;

        public static WiniumDriver SetupDriver()
        {
            if (driver == null)
            {
                Setup();
            }
            return driver;
        }

        private static void Setup()
        {
            var options = new DesktopOptions();
            options.ApplicationPath = calculatorAppPath;

            string winiumDriverPath = Directory.GetParent(
                Directory.GetParent(Directory.GetParent(Directory.GetParent(
                    AppDomain.CurrentDomain.BaseDirectory).ToString()).ToString()).ToString()).ToString() + "/Resources";

            var service = WiniumDriverService.CreateDesktopService(winiumDriverPath);
            driver = new WiniumDriver(service, options);
        }
    }
}
