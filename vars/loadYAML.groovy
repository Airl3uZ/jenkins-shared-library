// @GrabResolver(name='restlet', root='http://maven.restlet.org/')
// @grab(group='org.codehaus.groovy', module='groovy-all', version='2.5.11')
// import groovy.grape.Grape
// grape.grab(group='org.codehaus.groovy', module='groovy-all', version='2.5.11')
import org.yaml.snakeyaml.Yaml
import hudson.model.*
def call(String file = 'ci/config.yml') {
    // def parser = new Yaml()
    // def example = parser.load(file.text)
    // println example
    sh "pwd"
    Yaml parser = new Yaml()
    servers=parser.load(("${file}" as File).text)
    println servers
}