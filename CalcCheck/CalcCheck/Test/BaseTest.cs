using CalcCheck.Page;
using CalcCheck.Step;
using NUnit.Framework;

namespace CalcCheck.Test
{
    [TestFixture]
    public class BaseTest
    {
        [SetUp]
        public void BeforeTest()
        {
            new StandartPage().ClickOnClearButton();
        }

        [TestCase]
        public void CalcTest()
        {
            var getNumber = CalcSteps.InputRandomNumber();
            CalcSteps.ClickOnSqureRootButton();
            CalcSteps.CheckThatInTheFieldTheCorrectOperationIsShown(getNumber);
            CalcSteps.CheckThatTheResultIsCorrect(getNumber);
            CalcSteps.ClickOnMultiplyButton();
            CalcSteps.ClickOnEqualButton();
            CalcSteps.CheckThatResultIsTheInputedNumber(getNumber);
        }
        [TearDown]
        public void AfterTest()
        {
            new StandartPage().CloseCalculator();
            new StandartPage().Close();
        }
    }
}
