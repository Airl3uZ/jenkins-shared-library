import org.yaml.snakeyaml.*

@NonCPS
def constructString(ArrayList options, String keyOption, String separator = ' ') {
    return options.collect { keyOption + it }.join(separator).replaceAll('\n', '')
}
@NonCPS
def loadYAML(String data) {
  def yaml = new Yaml()
  return yaml.load(data)
}