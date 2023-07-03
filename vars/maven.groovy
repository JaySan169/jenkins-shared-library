def call() {
    node {
        git branch: 'main', url: "https://github.com/JaySan169/${COMPONENT}.git"
        env.APPTYPE="maven"
        common.lintChecks()
        env.ARGS="-Dsonar.java.binaries=target/"
        common.sonarChecks()   
        common.testCases()
        env.SONARURL = "sonar.robot.internal"
        env.NEXUSURL = "nexus.robot.internal"
        if(env.TAG_NAME != null ) {
            common.artifacts()
        }
    }
}

 