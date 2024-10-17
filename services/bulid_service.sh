#!/bin/sh

cd config-server; echo "\033[1;96m Execution directory: `pwd | xargs basename` \033[0m"; ./gradlew clean build; cd ../
cd discovery; echo "\033[1;96m Execution directory: `pwd | xargs basename` \033[0m"; ./gradlew clean build; cd ../
cd pubs-data-service; echo "\033[1;96m Execution directory: `pwd | xargs basename` \033[0m"; ./gradlew clean build; cd ../
cd pubs-routes-service; echo "\033[1;96m Execution directory: `pwd | xargs basename` \033[0m"; ./gradlew clean build; cd ../
cd gateway; echo "\033[1;96m Execution directory: `pwd | xargs basename` \033[0m"; ./gradlew clean build; cd ../