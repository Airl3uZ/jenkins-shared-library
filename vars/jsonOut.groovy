#!groovy
def someMap = [
  'key1': "value",
  'key2': 142.1
  ]

def json = new groovy.json.JsonBuilder()

json rootKey: someMap

println "json output: "
println groovy.json.JsonOutput.prettyPrint(json.toString())