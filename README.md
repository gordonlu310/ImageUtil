# ImageUtil

🖼️ **Introduction**

An App Inventor extension that provides additional tools to the built-in Image component.

Made by Gordon Lu (AICODE). For details, please read my website:

https://sites.google.com/view/appinventor-aicode/my-extensions/imageutil

:package: Package name: com.gordonlu.imageutil.aix

:clock1: Version: 5

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

>
>**HueFilter**
>
>![image](https://user-images.githubusercontent.com/88015331/159150725-1836880a-bdf8-4619-b7fa-17be6a8a2f9d.png)
>
>Sets the hue filter for the image, with the given level.
>
>*Parameters:* image = component, level = number (int)

>**ImageAlpha**
>
>![image](https://user-images.githubusercontent.com/88015331/157587228-7ef7994f-74be-400e-b375-50d46a997865.png)
>
>*Returns:* number (int)
>
>*Parameters:* image = component

>**IsCroppedToPadding**
>
>![image](https://user-images.githubusercontent.com/88015331/157587396-0230a3d3-2a5a-4906-8ef4-ac83f49c77f7.png)
>
>Checks whether this image is cropped to padding.
>
>*Returns:* boolean
>
>*Parameters:* image = component

>**RoundCorners**
>
>![image](https://user-images.githubusercontent.com/88015331/157588122-5f4ba444-fc4e-48c2-ab30-f101878ae8b4.png)
>
>Applies round corners to the Image, with the radius parameter as the radius of each corner.
>
>*Parameters:* image = component, radius = number (int)

>**SepiaToningEffect**
>
>![image](https://user-images.githubusercontent.com/88015331/157588443-dc17d770-ac08-4d90-88f7-a527adde10a0.png)
>
>Turns the image to a Sephia Toned version of the image, by specifying the depth, red, green and blue parameters.
>
>*Parameters:* image = component, depth = number (int), red = number (double), green = number (double), blue = number (double)

>**SetBrightness**
>
>![image](https://user-images.githubusercontent.com/88015331/157588582-b625d470-10dd-4b37-9197-cebc2686582b.png)
>
>Sets whether the image should crop to padding.
>
>*Parameters:* image = component, cropToPadding = boolean

>
>**SetColorDepth**
>
>![image](https://user-images.githubusercontent.com/88015331/159150735-55752ceb-5772-4e2a-923f-ecb66bd0ab8b.png)
>
>Sets the color depth of the image.
>
>*Parameters:* image = component, bitOffset = number (int)

>**SetImageAlpha**
>
>![image](https://user-images.githubusercontent.com/88015331/157588641-405a2329-ba87-4a74-8b64-de345c3dc78a.png)
>
>Sets the alpha value that should be applied to the image.
>
>*Parameters:* image = component, alpha = number (int)

>**SetImageTintColor**
>
>![image](https://user-images.githubusercontent.com/88015331/157588739-b7868b73-e03c-4dbd-9175-78b5a71b9de9.png)
>
>Change the image tint color. You can use too alpha values if you want with the 'make a list' block. Do not forget to use the 'make color' block together with the 'make a list' block.
>
>*Parameters:* image = component, tint = color

>**SetPadding**
>
>![image](https://user-images.githubusercontent.com/88015331/157589009-101470c3-2dca-4db3-b92f-454f5c694d7b.png)
>
>Sets the padding of the given image.
>
>*Parameters:* image = component, left = number (int), top = number (int), right = number (int), bottom = number (int)

>**UndoGrayscaleAndFade**
>
>![image](https://user-images.githubusercontent.com/88015331/157589078-c68e2be1-f5ed-4197-b791-a5cb0d2ff0cf.png)
>
>Undos the grayscale and fade effects applied with the AplyGrayscaleAndFade method.
>
>*Parameters:* image = component

There are also some properties for the font parameter in the ApplyWatermark method.

![image](https://user-images.githubusercontent.com/88015331/157589125-b5d17acd-f372-46f5-923d-9ba6b0f85df7.png)
