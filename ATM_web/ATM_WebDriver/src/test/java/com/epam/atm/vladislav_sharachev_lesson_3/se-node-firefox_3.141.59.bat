:: Beginning of hub batch file
set SERVER_VERSION=3.141.59
set TASK_NAME=SeleniumServerNode2
set NODE_PORT=5558
set HUB_PORT=4445
set REGISTER_IP=localhost
set FIREFOX_DRIVER=C:\_webdriver\chromedriver\geckodriver.exe
java -Dwebdriver.firefox.driver=%FIREFOX_DRIVER% -jar selenium-server-standalone-%SERVER_VERSION%.jar -role node -hub http://%REGISTER_IP%:%HUB_PORT%/grid/register -browser "browserName=firefox,platform=WINDOWS" -port 5557
:: End of hub batch file
pause