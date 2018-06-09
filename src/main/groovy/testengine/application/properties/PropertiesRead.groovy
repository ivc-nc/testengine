package testengine.application.properties

import groovy.util.logging.Slf4j

@Slf4j
class PropertiesRead {


    static Properties loadFromFile(String name) {

        String configurationPath ="src/main/resources/properties/configuration"

        Properties p = new Properties()

        File propertiesFile = new File("${configurationPath}/${name}.properties")

        if (!propertiesFile.exists()) {
            throw new Exception("PropertiesFile '$propertiesFile' does not exist!")
        } else {
            log.debug("Loading properties from ${name}")
        }

        p.load(propertiesFile.newDataInputStream())
        p
    }



}
