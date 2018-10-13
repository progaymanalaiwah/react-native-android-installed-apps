
# react-native-android-installed-apps

## Getting started

`$ npm install react-native-android-installed-apps --save`

### Mostly automatic installation

`$ react-native link react-native-android-installed-apps`

### Manual installation



#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.androidinstalledapps.RNAndroidInstalledAppsPackage;` to the imports at the top of the file
  - Add `new RNAndroidInstalledAppsPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-android-installed-apps'
  	project(':react-native-android-installed-apps').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-android-installed-apps/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-android-installed-apps')
  	```




## Usage
```javascript
import RNAndroidInstalledApps from 'react-native-android-installed-apps';

// TODO: What to do with the module?
RNAndroidInstalledApps;
```
  "# react-native-android-installed-apps-settings" 
"# react-native-android-installed-apps" 
