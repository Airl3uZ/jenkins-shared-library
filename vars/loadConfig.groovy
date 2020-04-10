@grab('org.yaml:snakeyaml:1.26')
import org.yaml.snakeyaml.*
import org.yaml.snakeyaml.constructor.*
import groovy.transform.*
// def call(String yaml = "testconfig.yml") {
//     def cfg = readYaml(file: "${yaml}")
//     cfg.map{ case (k,v)s"\t$k: $v\n" }
//     return [cfg]
// }
String exampleYaml = '''widgets:
                       |  - name: blah
                       |    age: 3000
                       |    silly: true
                       |  - name: blah meh
                       |    age: 13939
                       |    silly: false
                       |uuid: 1938484
                       |isActive: false'''.stripMargin()

@ToString(includeNames=true)
class Widget {
    String name
    Integer age
    boolean silly
}

@ToString(includeNames=true)
class MyConfig {
    List<Widget> widgets
    String uuid
    boolean isActive

    static MyConfig fromYaml(yaml) {
        Constructor c = new Constructor(MyConfig)
        TypeDescription t = new TypeDescription(MyConfig)
        t.putListPropertyType('widgts', Widget)
        c.addTypeDescription(t);

        new Yaml(c).load(yaml)
    }
}

println MyConfig.fromYaml(exampleYaml)