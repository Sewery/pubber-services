# Pubber Services
Pubber REST API is part of the Pubber Project, which aims to create an app for searching for favorite pubs in nearby locations.
This repository is responsible for the pub management system, providing public access data to pubs details and destiantions distance calculation using [GeoApify Api](https://www.geoapify.com/).
## Architecture
Pubber Services consists of following services:
- Config Server - is responsible for configuration files
- Gateway
- Pubs Data Service
- Pubs Routes Service
For monitoring, Zipkin is used, while Eureka Server handles service discovery.
## Deployment
The Application is deployed on EC2 server using GitHub Workflows
## Local development
The application is designed for local deployment using Docker Compose, allowing it to run in any enviroment.

