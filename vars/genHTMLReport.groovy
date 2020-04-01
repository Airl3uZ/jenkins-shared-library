#!/usr/bin/env groovy
def call(Map htmlreport) {
    publishHTML([
        allowMissing: false,
        alwaysLinkToLastBuild: true,
        keepAll: true,
        reportDir: htmlreport.reportDir,
        reportFiles: htmlreport.reportFiles,
        reportName: reportDir.reportName
    ])
}