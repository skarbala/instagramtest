# instagramtest

How to automate post on Instagram?

## Preconditions 
1. Android Debug Bridge (ADB is installed on your PC / MAC) - [how to ?](https://appuals.com/install-adb-windows-7-8-10/)
1. Debug mode enabled on your phone - [how to?](https://www.kingoapp.com/root-tutorials/how-to-enable-usb-debugging-mode-on-android.htm)
1. Appium desktop installed and running locally - [download appium](http://appium.io/downloads.html)
1. Instagram app is installed on your phone
    - if not you can download it from [here](https://apkpure.com/instagram/com.instagram.android)
    - and install it using `adb install {filename}`

## Project
### edit test.properties 
1. enter data about your phone - `android.phone.id` can be found using command `adb devices`
2. enter data about your IG account **don't commit this one keep it locally!**
3. run test on IG using RunInstagramTest.class

Enjoy!
