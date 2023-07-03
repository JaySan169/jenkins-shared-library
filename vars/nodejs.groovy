def call() {
    node {
        git branch: 'main', url: "https://github.com/JaySan169/${COMPONENT}.git"
        env.APPTYPE="nodejs"
        common.lintChecks()
        env.ARGS="-Dsonar.sources=."
        common.sonarChecks()   
        common.testCases()
        env.SONARURL = "sonar.robot.internal"
        env.NEXUSURL = "nexus.robot.internal"
        env.NEXUS = credentials ('NEXUS-CRED')
        common.artifacts()
        if(env.TAG_NAME != null ) {
            common.artifacts()
        }
    }
}
