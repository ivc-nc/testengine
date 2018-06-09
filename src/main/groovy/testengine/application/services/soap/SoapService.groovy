package testengine.application.services.soap

import testengine.application.properties.PropertiesRead
import wslite.soap.SOAPClient
import wslite.soap.SOAPResponse

/**
 * Interact with a SOAP endpoint
 */
class SoapService {

    Properties properties = new PropertiesRead().loadProperties()

    /**
     * Manually wrap the SOAP request to have full control over content rather than relying on markup-builder
     * @param xml
     * @return
     */
    static String wrapSoap(String xml) {

        String preSoap = '''<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:v10="http://www.ellixxir.org/lxr/ccn/submission/wsdl/v10"><soap:Header/><soap:Body>'''
        String postSoap = '''</soap:Body></soap:Envelope>'''
        "${preSoap}${xml}${postSoap}"

    }

    /**
     *
     * @param xml Should be a LXR receive request in xml format.
     * @return SOAPResponse The response from the application callback endpoint for delivering LXR requests in SOAP format
     */
    SOAPResponse sendSoap(String xml) {

        // todo generic endpoint
        //String endpoint = "http://${properties.cbcImsHost}:${properties.cbcImsPort}/services/callback"

        String endpoint = ""

        SOAPClient client = new SOAPClient(endpoint)
        String soapXml = wrapSoap(xml)
        client.send([:], soapXml)

    }


}
