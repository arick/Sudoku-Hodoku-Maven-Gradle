$exe = Join-Path $PSScriptRoot "build\dist\HoDoKu\HoDoKu.exe"

if (-not (Test-Path $exe)) {
    Write-Error "Executable not found: $exe`nRun './gradlew jpackageWin' first."
    exit 1
}

& $exe
