import com.jenkins.parser.*
import org.yaml.snakeyaml.*
import org.yaml.snakeyaml.constructor.*
import groovy.transform.*
// def call(String yaml = "testconfig.yml") {
//     def cfg = readYaml(file: "${yaml}")
//     cfg.map{ case (k,v)s"\t$k: $v\n" }
//     return [cfg]
// }
String exampleYaml = '''config:
                       |    project_name: 'demo-php-ci'
                       |    sonar_config: 'sonar-demo-php-ci.properties'
                       |env: 
                       |    test: '1938484' '''.stripMargin()

@ToString(includeNames=true)
class def config {
    String project_name
    String sonar_config
}
class env {
    String test
}

@ToString(includeNames=true)
class MyConfig {
    Map<config> config()
    Map<env> env

    static MyConfig fromYaml(yaml) {
        Constructor c = new Constructor(MyConfig)
        TypeDescription t = new TypeDescription(MyConfig)
        t.putListPropertyType('config', config)
        c.addTypeDescription(t);

        new Yaml(c).load(yaml)
    }
}

println MyConfig.fromYaml(exampleYaml)