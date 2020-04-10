#!groovy
def call(String yaml = "config.yml") {
    Map cfg = readYaml(file: "${yaml}".config)
    Map app_cfg = readYaml(file: "${yaml}".environment)
    return [cfg, app_cfg]
}