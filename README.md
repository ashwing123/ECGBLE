
Ashwin's Bluetooth Low Energy Heart Rate Grapher
===================================

This sample demonstrates how to use the Bluetooth LE Generic Attribute Profile (GATT) to obtain data

Introduction
------------

This sample shows a list of available Bluetooth LE devices and provides
an interface to connect, read, and graph characteristics supported by the devices.

It creates a [Service][1] for managing connection and data communication with a GATT server
hosted on a given Bluetooth LE device.

The Activities communicate with the Service, which in turn interacts with the [Bluetooth LE API][2].

References used from the Android Developer Website:
[1]:http://developer.android.com/reference/android/app/Service.html
[2]:https://developer.android.com/reference/android/bluetooth/BluetoothGatt.html

Pre-requisites
--------------

- Android SDK 27
- Android Build Tools v27.0.2
- Android Support Repository

Screenshots
-------------

<img src="screenshots/myMain.png" height="400" alt="Screenshot"/> <img src="screenshots/afterConnect.png" height="400" alt="Screenshot"/>

Getting Started
---------------

This sample uses the Gradle build system. To build this project, use the
"gradlew build" command or use "Import Project" in Android Studio.

