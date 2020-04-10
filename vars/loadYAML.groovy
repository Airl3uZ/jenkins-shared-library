// @GrabResolver(name='restlet', root='http://maven.restlet.org/')
// @grab(group='org.codehaus.groovy', module='groovy-all', version='2.5.11')
// import groovy.grape.Grape
// grape.grab(group='org.codehaus.groovy', module='groovy-all', version='2.5.11')
// import groovy.yaml.YamlBuilder
def call(String file = 'ci/config.yml') {
    def parser = new Yaml()
    def example = parser.load(file.text)
    return example
}