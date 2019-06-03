# TechnologieObiektowe
Few small projects written in java for design patterns classes 
---------------------------------------------------------------------------------
<b>Algebra:</b><br>
Scalar and vector product of two vectors calculator. Made with decorator design pattern.

---------------------------------------------------------------------------------
<b>ShapeDrawer:</b><br>
Program that reads text file and draws shapes based on file content. 
It uses resposibility chain pattern to determine which shape should be drawn next.

---------------------------------------------------------------------------------
<b>PhoneBook:</b><br>
Program stores names(objects) and numbers inside memory. Uses flyweight pattern to save memory usage. 
Objects are created based on text file content. 

---------------------------------------------------------------------------------
<b>Iterator:</b><br>
Array sorting program. Each array contains a number of arrays with integer numbers. 
Iterator pattern is used to iterate through them. User decides which sorting algorithm should be used for each internal array(strategy pattern). 

---------------------------------------------------------------------------------
<b>FileSystem:</b><br>
Program imitates file tree inside operating system. Each catalog contains either any amount of catalogs, or any amount of text files. 
Program was written with composite design pattern, so that objects are stored inside another objects. 
Deleting one catalog causes its contents to also be deleted no matter how deeply they are nested inside of him.  

---------------------------------------------------------------------------------
<b>Keylogger:</b><br>
Simple keylogger that allows to capture keys pressed by victim or to make a shot of victrims screen. Program is separated into two parts:</br>
<b>Server</b> which sends request to clients and recives answers from them. Each client is handled on diffrent thread. Server can send three diffrent type of request:<br>
- to make a screenshot and send it to the server in form of byte array,<br>
- to start reading keyboard inputs until other type of request is send from server, after diffrent type of request is send to client, he answers with captured text in form of byte array,<br>
- to idle and wait for next request.
Uses responsibility chain pattern to decide what type of answer he recieved(screen or text) so he can handle it. 

<b>Client</b> actuall "virus", which stalks user activity. Uses state design pattern to determine
which acction should he take based on server request. Client program uses jnativehook to capture pressed keys.<br>
Jnativehook: https://github.com/kwhat/jnativehook
