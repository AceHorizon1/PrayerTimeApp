# Prayer Times Android App

A modern Android application for calculating and displaying Islamic prayer times. This app provides accurate prayer time calculations based on your location and preferred calculation method.

## Features

- **Accurate Prayer Times**: Get precise prayer times for Fajr, Dhuhr, Asr, Maghrib, and Isha
- **Multiple Calculation Methods**: Support for various Islamic calculation methods including:
  - Muslim World League
  - Egyptian General Authority of Survey
  - University of Islamic Sciences, Karachi
  - Umm al-Qura University, Makkah
  - And many more
- **Location-based**: Automatically calculates prayer times based on your current location
- **Modern UI**: Clean and intuitive user interface built with Jetpack Compose
- **Settings Management**: Customize calculation parameters and preferences

## Prayer Time Calculation

This app uses the [adhan-kotlin](https://github.com/batoulapps/adhan-kotlin) library for high-precision Islamic prayer time calculations. The library implements astronomical algorithms from "Astronomical Algorithms" by Jean Meeus, which is recommended by the U.S. Naval Observatory and NOAA.

### Supported Calculation Methods

- **Muslim World League**: Fajr angle: 18°, Isha angle: 17°
- **Egyptian**: Fajr angle: 19.5°, Isha angle: 17.5°
- **Karachi**: Fajr angle: 18°, Isha angle: 18°
- **Umm al-Qura**: Fajr angle: 18°, Isha interval: 90 minutes
- **Dubai**: Fajr and Isha angles: 18.2°
- **Qatar**: Modified Umm al-Qura method
- **Kuwait**: Fajr angle: 18°, Isha angle: 17.5°
- **Moonsighting Committee**: Fajr angle: 18°, Isha angle: 18°
- **Singapore**: Fajr angle: 20°, Isha angle: 18°
- **North America (ISNA)**: Fajr angle: 15°, Isha angle: 15°

## Technical Details

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM with Repository pattern
- **Prayer Time Library**: [adhan-kotlin](https://github.com/batoulapps/adhan-kotlin) by batoulapps
- **Minimum SDK**: API 26 (Android 8.0)

## Getting Started

1. Clone the repository
2. Open the project in Android Studio
3. Build and run the application
4. Grant location permissions to get accurate prayer times for your area

## Dependencies

- [adhan-kotlin](https://github.com/batoulapps/adhan-kotlin) - High precision Islamic prayer time library
- Jetpack Compose - Modern Android UI toolkit
- Kotlin Coroutines - Asynchronous programming
- Android Architecture Components

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

- [batoulapps/adhan-kotlin](https://github.com/batoulapps/adhan-kotlin) - For providing the high-precision prayer time calculation library
- The astronomical algorithms are based on "Astronomical Algorithms" by Jean Meeus 