# ANCSSC Mapping Tool API Provider

This is the API provider for **ANCSSC Mapping Tool**. It is build on Java Spring Boot *2.2.1* and connect to SQL Database version *8.0*.
The Java SE JDK version is *1.8*. This is based on a RESTful style API, which use **GET**, **POST**, **PUT** and **DELETE** to demonstrate 
the operation to corresponding data  

## API Interactive Documents
This Project is annotated using Swagger, which provide us a online play ground of using available APIs.
You can directly access it by this [link](https://mapping-tool-api.azurewebsites.net/swagger-ui.html#/).

Also, Json format static API docs are available at this [link](http://mapping-tool-api.azurewebsites.net/v2/api-docs)

## Current API Base Url
These are current implemented version of API base urls:
* Version 1 (https://mapping-tool-api.azurewebsites.net/api/v1)
    * Users (https://mapping-tool-api.azurewebsites.net/api/v1/users)
    * Projects (https://mapping-tool-api.azurewebsites.net/api/v1/projects)
    * Search (Not Yet? May not Need it)


## Attentions
Here are some notice when you play with these APIs:
* **GET** is *save* to use since it doesn't alter the state of the server. In other words, a method is safe if it leads to a read-only operation.
* **PUT** and **DELETE** is *prohibit* to use for test purposes, which means you have to ensure the design of usage is correct to implement.
* Current version is already connected to the database so that it is very *dangerous* to use **PUT** and **DELETE**
    
    
## Developing Process
This section will discuss about conducting the development of one API module
### Version Control
It is implemented to three main branches: **master**, **dev** and **prod**.
* master: It is for stable version only, which means developers can only commit to this branch
when this state can *smoothly* work on the real server
* dev: It is for developing processes, i.e. the 'master' branch for developing,
 however developers cannot directly commit on this branch, they should make new branches for their own module
* prod: It is the pipeline trigger. merge to this stage when developer wants to deplopy to the server

### Spring Boot
Generally, three steps should be implemented:
* domain: where developer create POJO or Database Entity(if applicable)
* repository: This project using JPA as the accessing tool so that developers need to implements the connection to database by JPA
* service: First needs to have service interface then implement it.
    * Service: this is interface which you should include *add*, *update* and *delete*
    * ServiceImpl: implements the things above and add **@Service**
* Controller: Only for sending and getting messages.