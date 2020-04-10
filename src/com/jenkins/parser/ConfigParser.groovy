package com.jenkins.parser

import com.jenkins.ProjectConfiguration;
import com.jenkins.docker.DockerConfiguration;
class ConfigParser {
    static ProjectConfiguration parse(def yaml, def env) {
        ProjectConfiguration projectConfiguration = new ProjectConfiguration();
        projectConfiguration.env = env;
        projectConfiguration.dockerConfiguration = new DockerConfiguration(projectConfiguration: projectConfiguration);
        projectConfiguration.app_env = parseAppENV(yaml.config)
        return projectConfiguration;
    }
    static def parseEnvironment(def environment) {
        if (!environment) {
            return "";
        }
        return environment.collect { k, v -> "${k}=${v}"};
    }
    static def parseDockerfile(def config) {
        if (!config || !config["dockerfile"]) {
            return "Dockerfile";
        }

        return config["dockerfile"];
    }

    static def parseProjectName(def config) {
        if (!config || !config["project_name"]) {
            return "woloxci-project";
        }

        return config["project_name"];
    }
}