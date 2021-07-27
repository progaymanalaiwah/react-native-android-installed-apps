
# react-native-android-installed-apps

## Getting started

`$ npm install react-native-android-installed-apps --save`

### Mostly automatic installation

`$ react-native link react-native-android-installed-apps`

### Manual installation



#### Android

1. Open up your application file `android/app/src/main/java/[...]/MainActivity.java` or `android/app/src/main/java/[...]/MainApplication.java` depending on your project.
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


## Methods

#### 1 - getApps()
#### 2 - getNonSystemApps()
#### 3 - getSystemApps()

## Return Result 

- packageName
- versionName
- versionCode
- firstInstallTime
- lastUpdateTime
- appName
- icon // Base64
- apkDir
- size // Bytes


## Usage
```javascript
import RNAndroidInstalledApps from 'react-native-android-installed-apps';


RNAndroidInstalledApps.getApps()
      .then(apps => {
        this.setState({apps})
      })
      .catch(error => {
        alert(error);
      });

```
