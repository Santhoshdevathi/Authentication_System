@echo off
setlocal

:: Optional: Start MySQL (comment out if already running)
REM net start MySQL80 >nul 2>&1

:: 1. Start Spring Boot backend (Authify.jar)
start "" /min cmd /c "java -jar D:\Authentication_System\Authify.jar >nul 2>&1"

:: 2. Start Vite React frontend
cd /d "D:\Authentication_System\Authify_frontend"
start "" /min cmd /c "npm run dev >nul 2>&1"

:: 3. Open Chrome browser to the frontend
start "" chrome "http://localhost:5173"

:: 4. Wait until Chrome closes
:WAIT
tasklist | find /I "chrome.exe" >nul
if %ERRORLEVEL%==0 (
    timeout /t 5 >nul
    goto WAIT
)

:: 5. Kill backend and frontend servers after Chrome closes
taskkill /F /IM java.exe >nul 2>&1
taskkill /F /IM node.exe >nul 2>&1

exit
