package testengine.application.testdata.library

import groovy.json.JsonSlurper
import groovy.util.logging.Slf4j

import java.lang.Exception

@Slf4j
class ReadFile {

    public final static String TESTDATA_LIBRARY = "src/main/resources/testdata/"

    /**
     *
     * @param name String describing name of xml testdatafile.
     * @return GPathResult from slurped xml
     */
    static def readXml(def name) {

        File file = new File("${TESTDATA_LIBRARY}${name}.xml")
        XmlSlurper slurper = new XmlSlurper()
        slurper.parse(file)

        //todo consider if marshalling should be included

    }

    /**
     *
     * @param name String describing name of json testdatafile.
     * @return JsonSlurped data from file.
     */
    static def readJson(def name) {


        File file = new File("${TESTDATA_LIBRARY}${name}.json")
        JsonSlurper slurper = new JsonSlurper()
        slurper.parse(file)

    }


}


