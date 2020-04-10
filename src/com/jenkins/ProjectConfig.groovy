package com.jenkins;

import com.jenkins.docker.DockerConfiguration;

class ProjectConfiguration {
    def environment;
    def dockerfile;
    def projectName;
    DockerConfiguration dockerConfiguration;
    def env;
}