using CalcCheck.Page;
using System;

namespace CalcCheck.Step
{
    class CalcSteps
    {
        public static int InputRandomNumber()
        {
            Console.WriteLine("Ввести случаное число");
            var number = GenerateRandomNumber();
            new StandartPage().InputNumbers(number);
            return number;
        }

        public static void CheckThatInTheFieldTheCorrectOperationIsShown(int number)
        {
            Console.WriteLine("Проверить что в поле отображается корректная операция");
            new StandartPage().CheckThatTheOperationIsCorrect(number);
        }

        public static void CheckThatResultIsTheInputedNumber(int number)
        {
            Console.WriteLine("Проверить что результат равен введенному числу");
            new StandartPage().CheckThatTheSecondResultIsCorrect(number);
        }

        public static void ClickOnEqualButton()
        {
            Console.WriteLine("Кликнуть на кнопку Равно");
            new StandartPage().ClickOnEqualButton();
        }

        public static void ClickOnMultiplyButton()
        {
            Console.WriteLine("Кликнуть на кнопку умножения");
            new StandartPage().ClickOnMultiplyButton();
        }

        internal static void CheckThatTheResultIsCorrect(int number)
        {
            Console.WriteLine("Проверить что результат корректный");
            new StandartPage().CheckThatTheResultIsCorrect(number);
        }

        public static void ClickOnSqureRootButton()
        {
            Console.WriteLine("Кликнуть на кнопку Извлечь корень");
            new StandartPage().ClickOnSquareRootButton();
        }

        private static int GenerateRandomNumber()
        {
            int number = new Random().Next(1, 100);
            return number;
        }
    }
}
