#!/bin/bash
docker run -d --name datadog-agent \
              -v /var/run/docker.sock:/var/run/docker.sock:ro \
              -v /proc/:/host/proc/:ro \
              -v /sys/fs/cgroup/:/host/sys/fs/cgroup:ro \
              -v /Users/cesaralcancio/repos/datadog-example-client/logs:/logs \
              -p 127.0.0.1:8126:8126/tcp \
              -e DD_API_KEY="$DATA_DOG_SECRET" \
              -e DD_APM_ENABLED=true \
              -e DD_TAGS=env:dev \
              -e DD_APM_NON_LOCAL_TRAFFIC=true \
              -e DD_LOGS_ENABLED=true \
              -e DD_LOGS_CONFIG_CONTAINER_COLLECT_ALL=true \
              -e DD_LOGS_INJECTION=true \
              -e DD_CONTAINER_EXCLUDE="name:datadog-agent" \
              custom-datadog-image