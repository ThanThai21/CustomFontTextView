# CustomFontTextView

You can using your font instead of default font of Android


![alt text](https://github.com/ThanThai21/CustomFontTextView/blob/master/screenshot.PNG)

## Step1. Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
## Step 2. Add the dependency
```
	dependencies {
	        compile 'com.github.ThanThai21:CustomFontTextView:1.0.1'
	}
```
  
## Step 3. Create new assets folder and fonts directory like this:
<br/>
<br/>
![alt text](http://i.imgur.com/D3yu0jF.png)
<br/>

## Step 4. Copy your font into assets/fonts directory. Make sure your font ends with .ttf or .ttc

## Usage
```
<com.esp.customfonttextview.CustomFontTextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="20sp"
        android:text="Custom font"
        android:textSize="30sp"
        app:typefaceAssets="fonts/font.ttf" />
```
