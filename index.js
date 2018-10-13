// let RNAndroidInstalledApps = require("react-native").NativeModules
//   .RNAndroidInstalledApps;

import { NativeModules } from "react-native";

const { RNAndroidInstalledApps } = NativeModules;

module.exports = {
  getApps(): Promise<any> {
    return RNAndroidInstalledApps.getApps();
  },
  getNonSystemApps(): Promise<any> {
    return RNAndroidInstalledApps.getNonSystemApps();
  },
  getSystemApps(): Promise<any> {
    return RNAndroidInstalledApps.getSystemApps();
  }
};
