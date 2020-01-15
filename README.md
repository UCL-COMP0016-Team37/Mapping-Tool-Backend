# ANCSSC Mapping Tool API Provider

This is the API provider for **ANCSSC Mapping Tool**. It is build on Java Spring Boot *2.2.1* and connect to SQL Database version *8.0*.
The Java SE JDK version is *1.8*.

## API Interactive Documents
This Project is annotated using Swagger, which provide us a online play ground of using available APIs.
You can directly access it by this [link](https://mapping-tool-api.azurewebsites.net/swagger-ui.html#/).

Also, Json format static API docs are available at this [link](http://mapping-tool-api.azurewebsites.net/v2/api-docs)

## Current API Base Url
These are current implemented version of API base urls:
* Version 1 (https://mapping-tool-api.azurewebsites.net/api/v1)
    * Users (https://mapping-tool-api.azurewebsites.net/api/v1/users)
    * Projects


## Attentions
Here are some notice when you play with these APIs:
* **GET** is *save* to use since it doesn't alter the state of the server. In other words, a method is safe if it leads to a read-only operation.
* **PUT** and **DELETE** is *prohibit* to use for test purpose, which means you have to ensure the design of usage is correct to implement.
* Current version is already connected to the database so that it is very *dangerous* to use **PUT** and **DELETE**
    
    

    
   
