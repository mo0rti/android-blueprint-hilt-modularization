<h1 align="center">Android Blueprints</h1>

<div align="center">
  <img src="./images/banner.png" alt="Hilt & Modularization" width=500>
</div>
<br>

## Hilt & Modularization

This is an Android project template that implements the Model-View-Intent (MVI) architecture using Kotlin, 
Coroutine flow, Hilt, multi module structure, navigation coordinator, and single activity architecture.

The project is designed to be used as a blueprint for other Android developers who want to start building 
a new app with MVI architecture. It provides a ready-to-use code structure that can be easily extended and modified to fit different app requirements.

## Project Structure

The project is structured using the multi-module architecture approach, which separates different functionalities into individual modules. The following is a brief overview of each module:

- app module: The main module that contains the single activity and app-level dependencies, such as Hilt and navigation components.
- data module: The module that handles data retrieval from different sources, such as APIs or local databases. It uses Retrofit and Room libraries to implement the data layer.
- domain module: The module that contains the business logic and domain models of the app. It provides the use cases and repositories that are used by the presentation layer.
- presentation module: The module that handles the UI and user interactions. It implements the MVI architecture using Coroutine flow and provides the view models and view states that are used by the app.

Top level structure is based on flows. There are three main flows in this project:
- account module: The module for account flow which includes the network services, DI classes and screens when user is authenticated
- onboarding module: The module for onboarding flow which contains the network services, DI classes and screens for user onboarding
- auth module


## Architecture Overview
The project implements the following architecture:

* Model-View-Intent (MVI): A reactive architecture that separates the view logic from the business logic and data layer. It provides a unidirectional data flow that ensures a predictable and scalable app.
* Hilt: A dependency injection library that provides a simple and efficient way to handle app-level dependencies.
* Domain Use cases: To have a clean code and share the logic in one place.
* Coroutine flow: A reactive programming library that simplifies asynchronous operations and provides a more efficient and concise code.
* Navigation coordinator: A pattern that separates the navigation logic from the view layer and provides a central coordinator that handles the app navigation.
* Single activity architecture: A pattern that uses a single activity and multiple fragments to implement the app UI. This provides a more efficient and flexible way to handle UI navigation and reduces the app complexity.

## Who is it for?

* Intermediate developers are looking for a way to structure their app in a testable and maintainable way.
* Advanced developers looking for quick reference.

## Getting Started
To use this project as a template, follow these steps:

1- Clone the repository:
```bash
git clone https://github.com/mo0rti/android-blueprint-hilt-modularization.git
```
2- Open the project in Android Studio.
3- Modify the project name and package name according to your app requirements.
4- Start implementing your app functionalities using the provided code structure.

## Acknowledgments
This project was inspired by several open-source projects that use the MVI architecture and provide a clean and efficient code structure for Android apps. Special thanks to the following projects:

- [Android MVI Sample](https://github.com/android/architecture-samples) by Google Android Architecture Team

## What's next?

This project is still in progress for Intermediate and advanced Android developers.
There is [another repository](https://github.com/mo0rti/android-blueprint-advanced-modularization) which contains the latest practices for 
multi module projects including feature flags and latest Android navigation patterns.

So Stay tuned!!