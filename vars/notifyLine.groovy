#!groovy
def call(String stageResults = 'No result send from pipeline') {
    def token_t2p = "0vLiHpCXMxx5zKVYf9VdmQTRI61J250Eq2ozN3NW06M"
    def test_token = "BX9PfOsvLw8s1voSR8XqsSOyfKrRGVnxtSUpjvS6h6f"
    def jobName = env.JOB_NAME +' '+env.BRANCH_NAME
    def buildNo = env.BUILD_NUMBER
    if (jobName == 'testScript') {
        def token = test_token
    }
    else {
        def token = token_t2p
    }

    def url = 'https://notify-api.line.me/api/notify'
    def message = "${jobName} Build #${buildNo} ${stageResults} \r\n"
    // sh "curl ${url} -H 'Authorization: Bearer ${token}' -F 'message=${message}'"
    echo "curl ${url} -H 'Authorization: Bearer ${token}' -F 'message=${message}'"
}