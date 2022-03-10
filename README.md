# ImageUtil
An App Inventor extension that provides additional tools to the built-in Image component.

Made by Gordon Lu (AICODE). For details, please read my website:

https://sites.google.com/view/appinventor-aicode/my-extensions/imageutil

:package: Package name: com.gordonlu.imageutil.aix

:clock1: Version: 4

:date: Release date:  March 8, 2022 2:00 PM

:lollipop: Minimum API: 19 (Android 4.4 KitKat)

:open_book: **Documentation**

***Method blocks***

>
> **ApplyGrayscaleAndFade**
>
> ![image](https://user-images.githubusercontent.com/88015331/157586680-a5446a62-2c98-4f6d-a4d1-32bf412ecf32.png)
>
> Applies grayscale effect to an image and fades the image.
>
>*Parameters:* component = image

>
> **ApplyWatermark**
>
>![image](https://user-images.githubusercontent.com/88015331/157586833-351a96c6-0ff4-45bd-8914-bbd35c2eeb6e.png)
>
>Applies watermark text to the given image's content. Set the text of the watermark via the watermark parameter, and the x and y parameters are the co-ordinates of the watermark located on the image. The parameter color is the text color of the watermark, and alpha is the luminance of the watermark. The size parameter is the size of the watermark in points. Specify whether to underline the watermark via the underline boolean parameter. Use the blocks in the properties of this extension for the font parameter. If useCurrentFont is true, the font parameter will be ignored.
>
>*Parameters:* image = component, watermark = text, x = number (int), y = number (int), color = color, alpha = number (int), size = number (int), underline = boolean, font = text, useCurrentFont = boolean

>**ColorBoost**
>
>![194c8a5f4b80a6f0bd296fc6e7efc872d88047ed](https://user-images.githubusercontent.com/88015331/157586942-825c908c-9c26-4902-816e-166b8ce895b3.png)
>
>Applies color boost to the content of the given content. To find out the type parameter, go to: https://shaikhhamadali.blogspot.com/2013/07/color-boost-imagebitmap-in-imageview.html. type should be a value, either 1, or 2, or 3.
>
>*Parameters:* image = component, type = number (int), percent = number (float)

>**GammaEffect**
>
>![image](https://user-images.githubusercontent.com/88015331/157587094-f5f2af64-cab6-4591-bdae-d1a43997e553.png)
>
>Applies gamma effect to the given image.
>
>Parameters: image = component, red = number (double), green = number (double), blue = number (double)
