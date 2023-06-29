def call() {
    node {
        git branch: 'main', url: "https://github.com/JaySan169/${COMPONENT}.git"
        env.APPTYPE="nodejs"
        common.lintChecks()
        env.ARGS="-Dsonar.sources=."
        common.sonarChecks()   
        common.testCases()
        env.SONARURL = "http://sonar.robot.internal:9000"
        env.NEXUSURL = "172.31.2.247"
        if(env.TAG_NAME != null ) {
            common.artifacts()
        }
    }
}
