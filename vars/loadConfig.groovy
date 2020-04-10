#!groovy
def loadConfig(String yaml = "config.yml") {
    Map cfg = readYaml(file: "${yaml}")
    return cfg
}