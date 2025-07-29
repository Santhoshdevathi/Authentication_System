@echo off
setlocal

:: Optional: Start MySQL (comment out if already running)
REM net start MySQL80 >nul 2>&1

:: 1. Start Spring Boot backend (Authify.jar)
echo Launching Spring Boot Backend...
start "" /min java -jar "D:\Authify_project\Authify.jar"

:: 2. Start Vite React frontend
echo Launching React Frontend...
cd /d "D:\Authify_project\Authify_frontend"
start "" /min cmd /c "npm run dev"

:: 3. Open Chrome browser to the frontend
echo Opening browser...
start "" chrome "http://localhost:5173"

:: 4. Wait until Chrome closes
:WAIT
tasklist | find /I "chrome.exe" >nul
if %ERRORLEVEL%==0 (
    timeout /t 5 >nul
    goto WAIT
)

:: 5. Kill backend and frontend servers
echo Closing backend and frontend servers...
taskkill /F /IM java.exe >nul 2>&1
taskkill /F /IM node.exe >nul 2>&1

echo All servers stopped.
exit
