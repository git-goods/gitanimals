# Filebeat Base Image
FROM docker.elastic.co/beats/filebeat:8.10.0

# Copy custom Filebeat configuration
COPY filebeat.yml /usr/share/filebeat/filebeat.yml

# Set permissions
USER root
RUN chmod go-w /usr/share/filebeat/filebeat.yml

# Set working directory
WORKDIR /usr/share/filebeat

# Entry point
ENTRYPOINT ["filebeat"]
CMD ["-e", "-c", "/usr/share/filebeat/filebeat.yml"]
