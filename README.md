## Description 

Streamify: Your Ultimate Streaming Platform

Streamify revolutionizes the way you experience digital content, offering a seamless and personalized streaming experience like no other. With an intuitive interface and a vast library of diverse content, Streamify caters to every taste and preference, ensuring endless entertainment for users worldwide.
   ## 1. Main Classes
In the heart of Streamify are three main classes, each tailored to its unique role:

--> Streamers: Representing the creative individuals who share their content.

--> Streams: Housing the diverse array of content available for streaming.

--> User: Capturing the profiles and preferences of those engaging with the platform.

## 2. List Classes
Utilizing the Singleton design pattern, the List Classes ensure the efficient management of resources by allowing instantiation only once:

ListaStreamari: For managing Streamers' information.

StreamsList: For organizing the available Streams.

ListaUseri: Handling User data with ease and efficiency.

## 3. Implementation of Builder Classes
To streamline the process of adding items to lists without the clutter of constructors and setters, Builder classes are employed for each main class, ensuring simplicity and clarity.

## 4. Commands Classes
Commands are the backbone of user interaction within Streamify. These classes meticulously organize and execute user and system commands:

Streamer Commands: Including additions, deletions, and listings of streams.

User Commands: Providing functionalities for viewing streams, recommendations, and surprises.

Main Class Commands: Orchestrating high-level actions like adding data, displaying information, and clearing data to maintain a clean and efficient system.

## 5. Facade Class
To enhance code reusability and maintainability, the Facade class consolidates common operations under one roof, effectively abstracting complexities and promoting a more cohesive architecture:

Facade: Simplifying operations related to ordering, conversion, and search within the Streams class, ensuring a seamless user experience while keeping the codebase tidy and manageable.
