def call(String yamlFile = null) {
    def yaml = readYaml (file: "${yamlFile}")
    return yaml;
}