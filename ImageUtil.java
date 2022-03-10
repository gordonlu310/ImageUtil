package com.gordonlu.imageutil;

import android.app.Activity;
import android.content.Context;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;

import android.graphics.ColorMatrix;
import android.view.View;
import androidx.core.content.ContextCompat;
import android.view.View;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import android.widget.ImageView;
import android.graphics.PorterDuff.Mode;

import android.graphics.ColorMatrixColorFilter;
import java.lang.Object;

import android.graphics.Paint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Bitmap.Config;

import android.view.View.OnLongClickListener;
import java.util.Arrays;
import java.lang.Object;

import android.graphics.Color;

import android.graphics.Typeface;

@DesignerComponent(
        version = 4,
        description = "A non-visible extension that provides additional tools to the built-in Image component." + 
        "<br><br>Made by Gordon Lu (AICODE). For details, please read my website: " + 
        "<a href='https://sites.google.com/view/appinventor-aicode/my-extensions/imageutil'>https://sites.google.com/view/appinventor-aicode/my-extensions/imageutil</a>",
        category = ComponentCategory.EXTENSION,
        nonVisible = true,
        iconName = "https://docs.google.com/drawings/d/e/2PACX-1vQCI87PHLBF0jb8QWyYmIRQSjjNW3EFXf-qpsWCvBYkUQ9vEgPAB8SpxcMpblxNpbIYrjCjLrRLIU2c/pub?w=16&h=16")

@SimpleObject(external = true)
//Libraries
@UsesLibraries(libraries = "")
//Permissions
@UsesPermissions(permissionNames = "")

public class ImageUtil extends AndroidNonvisibleComponent {

    //Activity and Context
    private Context context;
    private Activity activity;

    public ImageUtil(ComponentContainer container){
        super(container.$form());
        this.activity = container.$context();
        this.context = container.$context();
    }

    @SimpleFunction(description = "Applies grayscale effect to an image and fades the image.")
    public void ApplyGrayscaleAndFade(AndroidViewComponent image){
        // https://stackoverflow.com/a/28312202/17802442
        View view = image.getView();
        ImageView v = (ImageView) view;
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        ColorMatrixColorFilter cf = new ColorMatrixColorFilter(matrix);
        v.setColorFilter(cf);
        v.setImageAlpha(128);
    }
    @SimpleFunction(description = "Undos the grayscale and fade effects applied with the AplyGrayscaleAndFade method.")
    public void UndoGrayscaleAndFade (AndroidViewComponent image) {
        View view = image.getView();
        ImageView v = (ImageView) view;
        v.setColorFilter(null);
        v.setImageAlpha(255);
    }
    @SimpleFunction(description = "Checks whether this ImageView crops to padding.")
    public boolean IsCroppedToPadding(AndroidViewComponent image) {
        View view = image.getView();
        ImageView v = (ImageView) view;
        return v.getCropToPadding();
    }
    @SimpleFunction(description = "Returns the alpha that was applied to this ImageView.")
    public int ImageAlpha(AndroidViewComponent image) {
        View view = image.getView();
        ImageView v = (ImageView) view;
        return v.getImageAlpha();
    }
    @SimpleFunction(description = "Sets the alpha value that should be applied to the image.") 
    public void SetImageAlpha(AndroidViewComponent image, int alpha) {
        View view = image.getView();
        ImageView v = (ImageView) view;
        v.setImageAlpha(alpha);
    }
    @SimpleFunction(description = "Change the image tint color. You can use too alpha values if you want with the 'make a list' block."+
    " Do not forget to use the 'make color' block together with the 'make a list' block.")
    public void SetImageTintColor(AndroidViewComponent image, int tint) {
        View view = image.getView();
        ImageView imageView = (ImageView) view;
        imageView.setColorFilter(tint);
    }
    @SimpleFunction(description = "Applies watermark text to the given image's content. Set the text of the watermark via the watermark parameter" + 
    ", and the x and y parameters are the co-ordinates of the watermark located on the image. The parameter color is the text color of the watermark, and alpha is the luminance of the watermark." + 
    " The size parameter is the size of the watermark in points. Specify whether to underline the watermark via the underline boolean parameter. " + 
    "Use the blocks in the properties of this extension for the font parameter. If useCurrentFont is true, the font parameter will be ignored. ")
    public void ApplyWatermark(AndroidViewComponent image, String watermark, int x, int y, int color, int alpha, int size, boolean underline, String font, boolean useCurrentFont) {
        View view = image.getView();
        ImageView imageView = (ImageView) view;
        imageView.invalidate();
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap src = drawable.getBitmap();
        int w = src.getWidth();
        int h = src.getHeight();
        Bitmap result = Bitmap.createBitmap(w, h, src.getConfig());

        Canvas canvas = new Canvas(result);
        canvas.drawBitmap(src, 0, 0, null);

        Paint paint = new Paint();
        paint.setColor(color);
        paint.setAlpha(alpha);
        paint.setTextSize(size);
        paint.setAntiAlias(true);
        paint.setUnderlineText(underline);
        Typeface t = Typeface.DEFAULT;
        if (useCurrentFont) {
        t = paint.getTypeface();
        } else {
        if (font == "DEFAULT") {
            t = Typeface.DEFAULT;
        } else if (font == "SERIF") {
            t = Typeface.SERIF;
        } else if (font == "SANS SERIF") {
            t = Typeface.SANS_SERIF;
        } else if (font == "MONOSPACE") {
            t = Typeface.MONOSPACE;
        }
        }
        paint.setTypeface(t);
        canvas.drawText(watermark, x, y, paint);

        Bitmap bitmap = result;
        imageView.setImageBitmap(bitmap);
    }
    @SimpleFunction(description = "Applies round corners to the Image, with the radius parameter as the radius of each corner.")
    public void RoundCorners(AndroidViewComponent image, int radius) {
        View view = image.getView();
        ImageView imageView = (ImageView) view;
        imageView.invalidate();
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        // https://stackoverflow.com/questions/2459916/how-to-make-an-imageview-with-rounded-corners#:~:text=https%3A//stackoverflow.com/a/3292810/17802442
        Bitmap bitmap = drawable.getBitmap();
                Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap
                .getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = radius;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        imageView.setImageBitmap(output);
    }
    @SimpleFunction(description = "Adds gamma effect to the given image.")
    public void GammaEffect(AndroidViewComponent image, double red, double green, double blue) {
        View view = image.getView();
        ImageView imageView = (ImageView) view;
        imageView.invalidate();
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        // https://shaikhhamadali.blogspot.com/2013/06/before-gamma-correction-after-gamma.html 
        Bitmap src = drawable.getBitmap();
        Bitmap bmOut = Bitmap.createBitmap(src.getWidth(), src.getHeight(), src.getConfig());
        int width = src.getWidth();
        int height = src.getHeight();
        int A, R, G, B;
        int pixel;
        final int MAX_SIZE = 256;
        final double MAX_VALUE_DBL = 255.0;
        final int MAX_VALUE_INT = 255;
        final double REVERSE = 1.0;
        int[] gammaR = new int[MAX_SIZE];
        int[] gammaG = new int[MAX_SIZE];
        int[] gammaB = new int[MAX_SIZE];
        for(int i = 0; i < MAX_SIZE; ++i) {
            gammaR[i] = (int)Math.min(MAX_VALUE_INT,
            (int)((MAX_VALUE_DBL * Math.pow(i / MAX_VALUE_DBL, REVERSE / red)) + 0.5));
            gammaG[i] = (int)Math.min(MAX_VALUE_INT,
            (int)((MAX_VALUE_DBL * Math.pow(i / MAX_VALUE_DBL, REVERSE / green)) + 0.5));
            gammaB[i] = (int)Math.min(MAX_VALUE_INT,
            (int)((MAX_VALUE_DBL * Math.pow(i / MAX_VALUE_DBL, REVERSE / blue)) + 0.5));
        }
        for(int x = 0; x < width; ++x) {
            for(int y = 0; y < height; ++y) {
            // get pixel color
            pixel = src.getPixel(x, y);
            A = Color.alpha(pixel);
            R = gammaR[Color.red(pixel)];
            G = gammaG[Color.green(pixel)];
            B = gammaB[Color.blue(pixel)];
            bmOut.setPixel(x, y, Color.argb(A, R, G, B));
        }
    }
  imageView.setImageBitmap(bmOut);
}
    @SimpleFunction(description = "Applies color boost to the content of the given content. " + 
    "To find out the type parameter, go to: https://shaikhhamadali.blogspot.com/2013/07/color-boost-imagebitmap-in-imageview.html.")
    public void ColorBoost(AndroidViewComponent image, int type, float percent) {
        View view = image.getView();
        ImageView imageView = (ImageView) view;
        imageView.invalidate();
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap src = drawable.getBitmap();
        int width = src.getWidth();
        int height = src.getHeight();
        Bitmap bmOut = Bitmap.createBitmap(width, height, src.getConfig());
        int A, R, G, B;
        int pixel;
        for(int x = 0; x < width; ++x) {
            for(int y = 0; y < height; ++y) {
                pixel = src.getPixel(x, y);
                A = Color.alpha(pixel);
                R = Color.red(pixel);
                G = Color.green(pixel);
                B = Color.blue(pixel);
                if(type == 1) {
                    R = (int)(R * (1 + percent));
                if(R > 255) R = 255;
                }
                else if(type == 2) {
                    G = (int)(G * (1 + percent));
                if(G > 255) G = 255;
                }
                else if(type == 3) {
                    B = (int)(B * (1 + percent));
                if(B > 255) B = 255;
                }
        bmOut.setPixel(x, y, Color.argb(A, R, G, B));
   }
  }
        imageView.setImageBitmap(bmOut);
    }
    @SimpleProperty(description = "A font block.")
    public String DefaultFont() {
        return "DEFAULT";
    }
    @SimpleProperty(description = "A font block.")
    public String Serif() {
        return "SERIF";
    }
    @SimpleProperty(description = "A font block.")
    public String SansSerif() {
        return "SANS SERIF";
    }
    @SimpleProperty(description = "A font block.")
    public String Monospace() {
        return "MONOSPACE";
    }
    @SimpleFunction(description = "Sets the brightness of the content for the given image, according to the value parameter.")
    public void SetBrightness(AndroidViewComponent image, int value) {
        View view = image.getView();
        ImageView imageView = (ImageView) view;
        imageView.invalidate();
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap src = drawable.getBitmap();
        // https://shaikhhamadali.blogspot.com/2013/07/set-brightness-of-imageincreasedecrease.html     
        int width = src.getWidth();
        int height = src.getHeight();
        Bitmap bmOut = Bitmap.createBitmap(width, height, src.getConfig());
        int A, R, G, B;
        int pixel;
        for(int x = 0; x < width; ++x) {
            for(int y = 0; y < height; ++y) {
                pixel = src.getPixel(x, y);
                A = Color.alpha(pixel);
                R = Color.red(pixel);
                G = Color.green(pixel);
                B = Color.blue(pixel);
                R += value;
                if(R > 255) { R = 255; }
                    else if(R < 0) { R = 0; }
  
                G += value;
                if(G > 255) { G = 255; }
                else if(G < 0) { G = 0; }
  
                B += value;
                if(B > 255) { B = 255; }
                else if(B < 0) { B = 0; }
  
             // apply new pixel color to output bitmap
             bmOut.setPixel(x, y, Color.argb(A, R, G, B));
         }
     }
     imageView.setImageBitmap(bmOut);
    }
    @SimpleFunction(description = "Sets the padding of the given image.")
    public void SetPadding(AndroidViewComponent image, int left, int top, int right, int bottom) {
        View view = image.getView();
        view.setPadding(left, top, right, bottom);
    }
    @SimpleFunction(description = "Sets the image to a Sepia Toning version of the image.") 
    public void SepiaToningEffect(AndroidViewComponent image, int depth, double red, double green, double blue) {
        View view = image.getView();
        ImageView imageView = (ImageView) view;
        imageView.invalidate();
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap src = drawable.getBitmap();      
        int width = src.getWidth();
        int height = src.getHeight();
        Bitmap bmOut = Bitmap.createBitmap(width, height, src.getConfig());
        final double GS_RED = 0.3;
        final double GS_GREEN = 0.59;
        final double GS_BLUE = 0.11;
        int A, R, G, B;
        int pixel;
        for(int x = 0; x < width; ++x) {
            for(int y = 0; y < height; ++y) {
                pixel = src.getPixel(x, y);
                A = Color.alpha(pixel);
                R = Color.red(pixel);
                G = Color.green(pixel);
                B = Color.blue(pixel);
                B = G = R = (int)(GS_RED * R + GS_GREEN * G + GS_BLUE * B);
                R += (depth * red);
                if(R > 255) { R = 255; }
                G += (depth * green);
                if(G > 255) { G = 255; }
                B += (depth * blue);
                if(B > 255) { B = 255; }
                bmOut.setPixel(x, y, Color.argb(A, R, G, B));
        }
    }
        imageView.setImageBitmap(bmOut); 
    }
    @SimpleFunction(description = "Sets whether the image should crop to padding.")
    public void SetCropToPadding(AndroidViewComponent image, boolean cropToPadding) {
        View view = image.getView();
        ImageView imageView = (ImageView) view;
        imageView.setCropToPadding(cropToPadding);
    }
}
