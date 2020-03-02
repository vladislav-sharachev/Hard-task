using CalcCheck.Driver;
using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Winium;
using System;
using System.Linq;
using System.Text.RegularExpressions;

namespace CalcCheck.Page
{
    class StandartPage
    {
        protected WiniumDriver _driver = DriverManager.SetupDriver();

        #region Elements
        private IWebElement ClearButton => _driver.FindElementById("clearButton");

        private IWebElement SquareRootButton => _driver.FindElementById("squareRootButton");

        private IWebElement CalculatorExpressionField => _driver.FindElementById("CalculatorExpression");

        private IWebElement CalculatorResultsField => _driver.FindElementById("CalculatorResults");

        private IWebElement MultiplyButton => _driver.FindElementById("multiplyButton");

        private IWebElement EqualButton => _driver.FindElementById("equalButton");

        private IWebElement CloseButton => _driver.FindElementById("Close");
        #endregion

        public void ClickOnClearButton()
        {
            DriverManager.SetupDriver();
            ClearButton.Click();
        }

        public int InputNumbers(int random)
        {
            var numByStr = random.ToString();
            var count = numByStr.Length;

            string numButton = "num{0}Button";

            switch (count)
            {
                case 1:
                    ClickOnButton(numButton, numByStr[0]);
                    break;
                case 2:
                    ClickOnButton(numButton, numByStr[0]);
                    ClickOnButton(numButton, numByStr[1]);
                    break;
                default:
                    ClickOnButton(numButton, '1');
                    ClickOnButton(numButton, '0');
                    ClickOnButton(numButton, '0');
                    break;
            }
            return random;
        }

        private void ClickOnButton(string button, char numberOfTheButton)
        {
            _driver.FindElementById(string.Format(button, numberOfTheButton)).Click();
        }

        public void ClickOnSquareRootButton()
        {
            SquareRootButton.Click();
        }

        public void CheckThatTheOperationIsCorrect(int number)
        {
            var name = CalculatorExpressionField.GetAttribute("Name");
            var actualResult = Regex.Replace(name, "[а-яa-z ]", "", RegexOptions.IgnoreCase);

            Assert.That(actualResult, Is.EqualTo(string.Format("√({0})", number)),
                "Actual result is not equal to the expected");
        }

        public void CheckThatTheResultIsCorrect(int number)
        {
            var expectedResult = Math.Round(Math.Sqrt(number), 14);
            var getCalcResult = CalculatorResultsField.GetAttribute("Name");
            var actualResult = Math.Round(Convert.ToDouble(
                Regex.Replace(getCalcResult, "[а-яa-z ]", "", RegexOptions.IgnoreCase)), 14);

            Assert.That(actualResult, Is.EqualTo(expectedResult),
                "Actual result is not equal to the expected");
        }

        public void ClickOnMultiplyButton()
        {
            MultiplyButton.Click();
        }

        public void ClickOnEqualButton()
        {
            EqualButton.Click();
        }

        public void CheckThatTheSecondResultIsCorrect(int number)
        {
            var getCalcResult = CalculatorResultsField.GetAttribute("Name").ToString();
            int actualResult;
            int.TryParse(string.Join("", getCalcResult.Where(r => char.IsDigit(r))), out actualResult);

            Assert.That(actualResult, Is.EqualTo(number),
                "Actual result is not equal to the expected");
        }

        public void Close()
        {
            _driver.Quit();
            _driver.Dispose();
        }

        public void CloseCalculator()
        {
            CloseButton.Click();
        }
    }
}
