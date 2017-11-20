FROM java:8-jdk
MAINTAINER irskl
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64

ENV KARAF_VERSION=3.0.8
    KARAF_HOME="/opt/karaf" \

RUN apk-install openssh && \
    curl -L http://archive.apache.org/dist/karaf/${KARAF_VERSION}/apache-karaf-${KARAF_VERSION}.tar.gz | \
    tar -xzf - -C /tmp && \
    mv /tmp/apache-karaf-${KARAF_VERSION} /opt/karaf && \
    cleanup
COPY rest-1.0-SNAPSHOT.kar
VOLUME ["/deploy"]
EXPOSE 8181
ENTRYPOINT ["/opt/karaf/bin/karaf"]