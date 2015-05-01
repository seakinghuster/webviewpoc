# Notes

## Required features in the Proof of Concept implementation

- Load an (integrated) HTML file
- Clean the HTML
- Render the HTML
- Use a custom font
- Scrollability
- Inject 3 styles
- React to links


## Notes for building and running from the command line

- Compile with `./gradlew assembleDebug`.
- Start the Android emulator using `~/Library/Android/sdk/tools/android avd &`, select the device, and start it
- Install the APK on the device using `~/Library/Android/sdk/platform-tools/adb install -r build/outputs/apk/webviewpoc-debug.apk`
- Optionally, ,onitor the device using `~/Library/Android/sdk/tools/monitor &`.


### Debugging from the command line

From http://codeseekah.com/2012/02/16/command-line-android-development-debugging/

    $ adb jdwp
    5384
    6385
    7051 # <- last launched
    $adb forward tcp:7777 jdwp:7051
    $ jdb -sourcepath src -attach localhost:7777

