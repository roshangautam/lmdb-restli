## LMDB
This is a standalone example that demonstrates a very simple RestLi server application 

## Documentation
Please find a step by step guide on RestLi [here](https://github.com/linkedin/rest.li/wiki/Quickstart:-A-Tutorial-Introduction-to-Rest.li)

## Getting Started

- Install Java and Gradle
  
  On macOs, with homebrew
  
  `brew cask install java` && `brew install gradle`

- Clone this repository

  `git clone url && cd lmdb-restli`

- Run the following for the first time to propagate the pdsc and idl changes.

  `gradle publishRestliIdl`
  
- Build 

  `gradle build`
  
- Run the Server

  `gradle startLmdbServer`
  
  You can access server resources using `http://localhost:8080/actors/1` or `http://localhost:8080/movies/1`  
  
  
## Optional IDE Setup

This project is setup to work with Intellij Idea out of the box. If you already don't have Intellij Idea in your machine you can download a copy from https://jetbrains.com. 

- Generate Intellij Idea files
  
  From within the project folder execute the following
  
  `gradle idea`
  
- Open the generated lmdb-restli.ipr file either from your file explorer or from command line and it should launch Intellij Idea and load the project.
  

