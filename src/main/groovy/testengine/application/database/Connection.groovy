package testengine.application.database

import groovy.sql.Sql
import testengine.application.properties.PropertiesRead

/**
 *
 * Set up a connection to a database for a given environment.
 * This is used by test to verify data is stored correctly.
 *
 */
class Connection {


    static def postgres() {

        Properties properties = new PropertiesRead().loadFromFile("dbconnection-postgres")
        def dbUrl = "jdbc:postgresql://${properties.host}:${properties.port}/${properties.name}"
        Sql.newInstance(dbUrl, properties.user, properties.password, properties.driver)


    }



}
