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
  

