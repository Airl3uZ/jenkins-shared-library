#!groovy
def call(String file) {
    config = readYaml file: "${file}.yml"
    println config
}