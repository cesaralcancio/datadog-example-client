#!/bin/bash

echo "Configure the env variables... Don't forget to configure the app as well. The logback uses these variables..."
echo "To check each data dog agent env variable... "

# DOCUMENTS
# https://docs.datadoghq.com/agent/docker/apm/?tab=linux#docker-apm-agent-environment-variables
# https://docs.datadoghq.com/agent/docker/?tab=standard#environment-variables
# KEY
# ENABLE PROCESS AGENT
# ENABLE PM
# ENABLE STATSD
# ENABLE LOG

docker run -d --name datadog-agent \
              -v /var/run/docker.sock:/var/run/docker.sock:ro \
              -v /proc/:/host/proc/:ro \
              -v /sys/fs/cgroup/:/host/sys/fs/cgroup:ro \
              -v "$URL_APP_LOG":/logs \
              -p 127.0.0.1:8126:8126/tcp \
              -p 127.0.0.1:8125:8125/udp \
              -e DD_API_KEY="$DATA_DOG_SECRET" \
              -e DD_PROCESS_AGENT_ENABLED=true \
              -e DD_APM_ENABLED=true \
              -e DD_APM_NON_LOCAL_TRAFFIC=true \
              -e DD_DOGSTATSD_NON_LOCAL_TRAFFIC=true \
              -e DD_LOGS_ENABLED=true \
              -e DD_LOGS_CONFIG_CONTAINER_COLLECT_ALL=true \
              -e DD_LOGS_INJECTION=true \
              -e DD_LOG_LEVEL=info \
              -e DD_CONTAINER_EXCLUDE="name:datadog-agent" \
              -e DD_TAGS=env:dev \
              -e DD_SITE=datadoghq.com \
              -e DD_TRACE_ANALYTICS_ENABLED=true \
              custom-datadog-image