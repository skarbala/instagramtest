# instagramtest

How to automate post on Instagram?

## Preconditions 
1. Android Debug Bridge (ADB is installed on your PC / MAC) - https://appuals.com/install-adb-windows-7-8-10/
2. Debug mode enabled on your phone - https://www.kingoapp.com/root-tutorials/how-to-enable-usb-debugging-mode-on-android.htm
3. Appium desktop installed and running locally - http://appium.io/downloads.html
4. Instagram app is installed on your phone

## Project
### edit test.properties 
1. enter data about your phone - `android.phone.id` can be found using command `adb devices`
2. enter data about your IG account (don't commit this one keep it locally! :) )
3. run test on IG using RunInstagramTest.class

Enjoy!
