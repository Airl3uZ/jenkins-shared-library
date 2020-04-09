#!groovy
def call(stageResults) {
    def token = "0vLiHpCXMxx5zKVYf9VdmQTRI61J250Eq2ozN3NW06M"
    def jobName = env.JOB_NAME +' '+env.BRANCH_NAME
    def buildNo = env.BUILD_NUMBER

    def url = 'https://notify-api.line.me/api/notify'
    def message = "${jobName} Build #${buildNo} ${stageResults.first} \r\n"
    // sh "curl ${url} -H 'Authorization: Bearer ${token}' -F 'message=${message}'"
    echo "curl ${url} -H 'Authorization: Bearer ${token}' -F 'message=${message}'"
}