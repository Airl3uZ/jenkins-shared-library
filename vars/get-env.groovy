@Library('SharedLibrary')_
import com.jenkins.*;

def call(ProjectConfiguration projectConfig, def _, def nextClosure) {
      return { variables ->
            timeout(time: projectConfig.timeout, unit: 'SECONDS') {
                  withEnv(projectConfig.environment) {
                        wrap([$class: 'AnsiColorBuildWrapper', 'colorMapName': 'XTerm']) {
                        nextClosure(variables)
                        }
                  }
            }
      }
}