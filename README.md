# AksaIntar
Aksa Intar is an object detector and color detector application. This application is intended for people who have vision problems.

People who have deficiencies must have their own challenges. An example of this is the blind who need an object to identify objects around them. what should he see. Because of this, the blind will have difficulty in living their daily lives. With the difficulty of being blind, our team created a project that can recognize an object through the camera. With the application that we made, we hope that it will be easier for the blind to live their lives. The apps we build combine machine learning and object recognition technologies in android apps. When recognizing an object, the application will tell the user the name of the object via audio. The main topic of our research on capstones is the application of applications for those who need help identifying objects in real-time. Apart from identifying an object, we also designed this application to be able to identify a color. This makes our application also suitable for color blind people. The name of the application is "Aksa Intar". We take the name from Sanskrit which means sight.

### TEAM OF AKSA INTAR
|Name|Role|ID|
|:------|:------|:------|       
|Muh. Ridha Agam 	        |Machine Learning	|M251DSX3131|
|Putri Maharani Isnainiyah	|Machine Learning	|M251DSY0474|
|Jeremy Lewi Munthe         |Mobile Developer	|A243DSX2749|
|Kelvin Aprilio	            |Mobile Developer	|A251DSX2720|
|Cahyo Dwi Setiono	        |Cloud Computing	|C286DSX0832|
|Noah Kiano Napitupulu	    |Cloud Computing	|C243DSX0628|

## MACHINE LEARNING 

### Overview
Part of machine learning in this application is detecting items. We utilize a dataset of nearby objects to build a model that can detect items. And developed it in TensorFlow-based machine learning solution. We use the MobileNetV2 type to modeling. 

### Step in Deploy the Machine Learning 
<details>
<summary>Object detection </summary>

![flowchart of mobilenetv2 drawio](https://github.com/ridhaagam/Capstone-Project-C23-PS361/assets/71591898/892a997e-b5a4-424d-bd61-999fe60a672e)

</details>

### Dataset and Data Preparation 
The dataset we use for this model is "Common Objects" dataset taken in 2014. The dataset can be download in [here](https://cocodataset.org/#download). This dataset contains (jumlah gambar dalam dataset) images. 
For modeling, we use 2000 images. We split the dataset into training set of 1600 images and testing set of 400 images. And we do a rescale and augmentation on the images. 

### Model
Our model in this application is using MobileNetV2. We did some modification and adjustable to make the best model possible.
<details>
<summary>Model Summary</summary>

<img width="517" alt="Screenshot 2023-05-31 043402" src="https://github.com/ridhaagam/Capstone-Project-C23-PS361/assets/71591898/db5ad9b0-eaf7-4ab2-a12e-4b24fd05db98">

</details>

<details>
<summary>Model Flowchart</summary>

<>

</details>

<details>
<summary>Accuracy</summary>

<img width="274" alt="Screenshot 2023-05-31 044543" src="https://github.com/ridhaagam/Capstone-Project-C23-PS361/assets/71591898/4a6f85ee-e826-4acb-9903-160a24a88a64">

</details>
<details>
<summary>Loss</summary>

<img width="261" alt="Screenshot 2023-05-31 044653" src="https://github.com/ridhaagam/Capstone-Project-C23-PS361/assets/71591898/4a6b5aa7-d8cd-4fd9-9b30-a7311094f0a5">

</details>

## MOBILE DEVELOPMENT

### Overview
As the Mobile Development team, we use native Kotlin and Android Studio to create our Android app. Our responsibilities is setting up the Android app environment, designing the user interface through Figma, and implementing both object detection and color detection features for the app's functionalities. And once the application is complete, we monitor and fix any issues found to ensure the application runs as it should.
 
## CLOUD COMPUTING
### Overview
For the cloud computing path, we create an API for authentication and authorization of the apps. Then, to make it easier for users to login, we want to add Google Authentication. We use the Google Cloud Platform ( Compute Engine or cloud run  and Cloud Storage ) as the medium to deploy the project, and we may also use other third-party APIs as needed during development.
