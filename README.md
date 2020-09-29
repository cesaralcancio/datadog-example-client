# datadog-example-client

## Versions
* Java 11.0.5 2019-10-15 LTS.
* Maven 3.6.3.
* Docker 18.09.2, build 6247962.

## Setup

1. Set "DATA_DOG_SECRET" with the API_KEY for DataDog Agent.
2. Set "URL_APP_LOG" where the App Log will be installed.

The API_KEY is to send metrics and logs to DataDog.
The URL_APP_LOG is to store the log for the app and share with DataDog Agent to send to DataDog Service.

3. Give full permission to the agent jar: `chmod 777 ./src/main/resources/datadog/dd-java-agent.jar`

Otherwise, it will not generate the "operation name" for trace.annotation.

## Usage

1. Run the ./src/docker/create-docker-image.sh - To create image
2. Run the ./src/docker/start_datadog_container.sh - To start DataDog Agent
2.5 Run the ./src/docker/run_inside_datadog.sh - To run bash in DataDog Agent
3. Run the ./src/docker/stop_all_container.sh - To stop all containers

## How it works?

1. Run the datadog agent before
2. Run the app but send the "Environment Variable" described in the setup item.
3. Run the app but send the "VM options" according to vm-argments.conf file.