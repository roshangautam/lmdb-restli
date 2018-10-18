## LMDB
This is a standalone example that demonstrates a very simple RestLi server application 

## Documentation
Please find a step by step guide on RestLi [here](https://github.com/linkedin/pegasus/wiki/Quickstart:-A-Tutorial-Introduction-to-RestLi)

## Getting Started

- Clone this repository

  `git clone url && cd directory`

- Run the following for the first time to propagate the pdsc and idl changes.

  `gradle publishRestliIdl`
  
- Build 

  `gradle build`
  
- Run the Server

  `gradle startLmdbServer`
  
  You can access server resources using `http://localhost:8080/actors/1` or `http://localhost:8080/movies/1`  
  

