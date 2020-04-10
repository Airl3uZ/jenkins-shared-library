#!groovy
def call(String yaml = "config.yml", String yamlName = 'config') {
    Map cfg = readYaml(file: "${yaml}"."${yamlName}")
    return [cfg, app_cfg]
}