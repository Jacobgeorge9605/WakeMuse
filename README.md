# WakeMuse
The Daily Motivation Alarm App helps users start each day with positivity. Developed in Java for Android, it offers personalized motivational songs, a daily quote, and a customizable to-do list with notifications to inspire and organize users. Ideal for boosting morning motivation, it supports users in waking up with purpose and staying on track.


<img width="1280" alt="readme-banner" src="https://github.com/user-attachments/assets/35332e92-44cb-425b-9dff-27bcf1023c6c">



### Team Name: Orion Nebula


### Team Members
- Team Lead: Jacob George - LBS College of Engineering Kasaragod
- Member 2: Nithish Nayak - LBS College of Engineering Kasaragod
- Member 3: Aravind Ramesh - LBS College of Engineering Kasaragod

### Project Description
We are dedigned a motivational alaram in which the alaram rings every day respective time that is set by the user, once the user snooze it, the motivational tone will be played 

### The Problem (that doesn't exist)
for humans, the entire day begins with what mood he is on the morning. the mood of the day mostly determined by the specific thing they hears or do daily.
we proposing a motivational alarm that rings based on set by user when the day before he slept

### The Solution (that nobody asked for)
Motivational alarm and task setting is the feature and main thing about our project, this method help the human to stay positively and remainds him how many task he has to do on particular that day.
so that he stay positive the entire day 


## Technical Details
### Technologies/Components Used
For Software:
1. Programming Language: Java (for Android app development)
2. Development Environment: Android Studio (IDE for designing and building Android apps)
3. Libraries and Frameworks:
    AndroidX Core: For compatibility features like NotificationCompat.
    WorkManager: For scheduling recurring tasks such as daily alarms.
    MediaPlayer: For playing alarm tones and motivational audio.
    AudioManager: For managing audio streams (e.g., alarms).
4. System Components:
    AlarmManager: For scheduling precise alarms and wake-up triggers.
    BroadcastReceiver: To respond to alarm triggers and initiate app                           actions.
    Notification Channels: For managing and displaying notifications.
5. Testing and Debugging:
    Android Emulator for testing app behavior.
    Logcat for debugging and monitoring app activities.

   
### Implementation

We propose an innovative alarm application built using Java and Firebase that dynamically generates motivational tones to provide a positive start to the day. Users can set alarms for the next day, with each alarm playing a unique tone fetched from Firebase Storage. The app also allows users to set and save daily tasks in Firebase Firestore or Realtime Database, ensuring their goals are easily accessible. By combining dynamic audio playback with personalized task management, the app delivers an inspiring and productive morning routine while leveraging Firebase for reliable backend support.


# Installations in this Project
1. Android Studio: IDE for developing, debugging, and testing the     
                   application.
2.Firebase SDK:  Add the following Firebase dependencies to your build.gradle file:

implementation 'com.google.firebase:firebase-storage:20.2.1'
implementation 'com.google.firebase:firebase-firestore:24.6.0'
implementation 'com.google.firebase:firebase-database:20.2.1'

3.AndroidX Libraries: For notifications and modern app compatibility:

implementation 'androidx.core:core:1.6.0'
implementation 'androidx.work:work-runtime:2.7.0'

Java Development Kit (JDK): Ensure JDK 8 or higher is installed for Java development.



# Run
Follow these steps to run the project on your local system or emulator

1. Clone or Download the Project: Clone the repository or download the project ZIP file and extract it.
2. Open in Android Studio: Open Android Studio and select "Open an existing project".
Navigate to the project folder and open it.
3.Install Dependencies
Ensure all required dependencies are added in the build.gradle file.
Sync the project with Gradle by clicking "Sync Now" in Android Studio.
4.Setup Firebase
Go to the Firebase Console and create a new project.
Add an Android app to the Firebase project and download the google-services.json file.
Place the google-services.json file in the app/ directory of the project.
Enable Firebase Storage and Firestore/Realtime Database in the Firebase Console.
5. Configure Emulator or Device: Set up an Android Emulator in Android Studio or connect a physical Android device via USB with USB debugging enabled.
6. Build and Run the App: 
Click the Run button in Android Studio or press Shift + F10.
Select the target device or emulator for deploying the app.
Test the Functionality
7.Set an alarm and add tasks to test the app.
Verify the motivational tone is fetched dynamically and daily tasks are stored in Firebase.



# Screenshots (Add at least 3)

![img 1](https://github.com/user-attachments/assets/fea3b2f8-93c6-4d82-b5da-409cde7d597d)
Alaram can be set by clicking the SET ALARAM BUTTON



![img 2](https://github.com/user-attachments/assets/c2765871-0623-4c76-a98c-938c886d75b2)
Hour needle can be Adjusted using an Virtual Analogue clock

![img 3](https://github.com/user-attachments/assets/086912c5-3859-41cf-a990-4c81762675f1)
Minute needle can be Adjusted using an Virtual Analogue clock



![img 4](https://github.com/user-attachments/assets/5a00337e-3188-45e2-99d4-64472dd8f579)
Now ALARAM has been set we can also set our daily task in the Section



![img 5](https://github.com/user-attachments/assets/0ac30d0c-fe1a-4b84-9f91-f14806df8580)
After entering the daily task, we can save our task using SAVE button.



![img 6](https://github.com/user-attachments/assets/d83c32ae-c068-4cd7-8673-e807345ab46e)
Now the task has been saved at the database and it will displayed as long as alram rings



### Project Demo
# Video


https://github.com/user-attachments/assets/0bb6a94c-7d56-494a-a5c2-c9353a5d429c


video demonstrates the working of Our application



## Team Contributions
- Nithish Nayak: Coding
- Jacob George: Idea creation and UI design
- Aravind ramesh: Literature Survey and resorce collection

-----------------------------------------------------------------------
Made with ❤ at TinkerHub Useless Projects 

![Static Badge](https://img.shields.io/badge/TinkerHub-24?color=%23000000&link=https%3A%2F%2Fwww.tinkerhub.org%2F)
![Static Badge](https://img.shields.io/badge/UselessProject--24-24?link=https%3A%2F%2Fwww.tinkerhub.org%2Fevents%2FQ2Q1TQKX6Q%2FUseless%2520Projects)
