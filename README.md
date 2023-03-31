
//TOBESCU DALYA-ALEXANDRA//


1. MAIN CLASSES
        
        I put the specific attributes for each type of class:
        --> Streamers 
        --> Streams 
        --> User 

2. LIST CLASSES
        
        I used Singleton to be able to instantiate each class only once.
        Also for their easier use in the rest of the classes.
        -->ListaStreamari
        -->ListaStreams
        -->ListaUseri

3. IMPLEMENTAREA CLASELOR BUILDER
   
        I used Builder for each main classes for make it easier to add in lists, without 
        the need for constructors, setter and getter in the rest of the code.

4.COMMANDS CLASSES
        
        I used Commands for users, streamers and Proiect_POO class to clearly highlight 
        each command and separate the code like this:
        --> as Streamer you can have commands like: add, delete, list
        more specifically ComandaAdaugare, ComandaAfisarebyStreamer, ComandaStergere
        --> as User you can have ComandaAfisarebyUser, ComandaAscultare, ComandaRecomandari
        ComandaSurpriza
        --> in the case of the main class, I separated each command that I read from the file,
        thus the main has its commands: add, display, clearData (empty all lists
        at the end), makeLists (make the lists according to the data read from the file).
        PS: this part with the main class, I made it more to make the code more compact.

5.FATADE CLASS
   
        To avoid writing duplicate code in the command classes, I created an interface
        Operations and a Facade class, to "hide" at the same time the code it referred to
        to ordering, conversion, search, from the rest of the code. Considering that these
        operations are related to the Streams class, everything is related to it.
