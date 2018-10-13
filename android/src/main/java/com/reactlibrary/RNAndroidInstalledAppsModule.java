
package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import android.content.pm.PackageInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.annotation.Nullable;

import com.helper.*;

public class RNAndroidInstalledAppsModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNAndroidInstalledAppsModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNAndroidInstalledApps";
  }

  private List<Map> getApps() {

    PackageManager pm = this.reactContext.getPackageManager();
    List<PackageInfo> pList = pm.getInstalledPackages(0);
    List<Map> list = new ArrayList();

    for (int i = 0; i < pList.size(); i++) {
      PackageInfo packageInfo = pList.get(i);
      Map appInfo = new HashMap();
      appInfo.put("packageName", packageInfo.packageName);
      appInfo.put("versionName", packageInfo.versionName);
      appInfo.put("versionCode", packageInfo.versionCode);
      appInfo.put("firstInstallTime", packageInfo.firstInstallTime);
      appInfo.put("lastUpdateTime", packageInfo.lastUpdateTime);
      appInfo.put("appName", ((String) packageInfo.applicationInfo.loadLabel(pm)).trim());
      Drawable icon = pm.getApplicationIcon(packageInfo.applicationInfo);
      appInfo.put("icon", Utility.convert(icon));
      list.add(appInfo);
    }
    return list;
  }

  private List<Map> getNonSystemApps() {

    PackageManager pm = this.reactContext.getPackageManager();
    List<PackageInfo> pList = pm.getInstalledPackages(0);
    List<Map> list = new ArrayList();

    for (int i = 0; i < pList.size(); i++) {
              PackageInfo packageInfo = pList.get(i);

      if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
        Map appInfo = new HashMap();
        appInfo.put("packageName", packageInfo.packageName);
        appInfo.put("versionName", packageInfo.versionName);
        appInfo.put("versionCode", packageInfo.versionCode);
        appInfo.put("firstInstallTime", packageInfo.firstInstallTime);
        appInfo.put("lastUpdateTime", packageInfo.lastUpdateTime);
        appInfo.put("appName", ((String) packageInfo.applicationInfo.loadLabel(pm)).trim());
        Drawable icon = pm.getApplicationIcon(packageInfo.applicationInfo);
        appInfo.put("icon", Utility.convert(icon));
        list.add(appInfo);
      }
    }
    return list;
  }
}