// https://mvnrepository.com/artifact/org.yaml/snakeyaml
import org.yaml.snakeyaml.*

Yaml yaml = new Yaml()
def configYaml = '''
application: "Sample App"
users:
  name: "mrhaki"
  likes: "Groovy"
steps:
  first: "WS1"
  second:"WS2"
'''
def result = yaml.load(configYaml)
result.application.each {
    assert it.key == 'user' || it.key == 'steps'
}

println result.inspect()