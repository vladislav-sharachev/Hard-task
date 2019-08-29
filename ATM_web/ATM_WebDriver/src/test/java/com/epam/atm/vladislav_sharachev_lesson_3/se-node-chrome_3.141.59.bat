:: Beginning of hub batch file
set SERVER_VERSION=3.141.59
set TASK_NAME=SeleniumServerNode1
set HUB_PORT=4445
set REGISTER_IP=localhost
set CHROME_DRIVER=C:\_webdriver\chromedriver\chromedriver.exe
java -Dwebdriver.chrome.driver=%CHROME_DRIVER% -jar selenium-server-standalone-%SERVER_VERSION%.jar -role node -hub http://%REGISTER_IP%:%HUB_PORT%/grid/register -browser "browserName=chrome,platform=WINDOWS"
:: End of hub batch file
pause