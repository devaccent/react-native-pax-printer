# react-native-pax-printer

React-Native printer module for PAX POS devices

## Installation

## Step 1

```sh
yarn add react-native-pax-printer
```

## Step 2

Download the file [libDeviceConfig.so](./armeabi-files/libDeviceConfig.so) and place it in `android/app/src/main/jniLibs/armeabi-v7a`

## Step 3

Open _`android/app/build.gradle`_ and add the armeabi-v7a **filter** for the **ndk** in **defaultConfig**

```
...
android {
    ...
    defaultConfig {
        ...
        ndk {
            abiFilters "armeabi-v7a"
        }
    }
}
```

## Printing

```javascript
import {printString} from "react-native-pax-printer";

...
await printString('String to print');
await printStrings(['String one', 'String two', 'String 3']);
...
```


## License

MIT
