docker run -d --name prometheus -p 9090:9090 \
    -v ~/Dev/docker/prometheus/prometheus.yml:/etc/prometheus/prometheus.yml \
    prom/prometheus --config.file=/etc/prometheus/prometheus.yml
