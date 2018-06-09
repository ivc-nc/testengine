package testengine.application.database

import groovy.sql.Sql
import testengine.application.properties.PropertiesRead

/**
 * Set up a connection to postgres database for a given environment.
 * This is used by test to verify data is stored correctly.
 *
 * The connection to databases requires SSH tunnel connect to test environment while performing test.
 *
 */
class DbConnection {

    def properties = new PropertiesRead().loadProperties()

    // Set the database url
    def dbPort = properties.dbPostgresPort
    def dbHost = properties.dbPostgresHost
    def dbName = properties.dbName
    def dbUrl = "jdbc:postgresql://${dbHost}:${dbPort}/${dbName}"

    // Set user credentials
    def dbUser = properties.dbPostgresUser
    def dbPassword = properties.dbPostgresPassword

    // Set driver
    def dbDriver = "org.postgresql.Driver"

    def createDatabaseConnection() {
        Sql databaseConnection = Sql.newInstance(dbUrl, dbUser, dbPassword, dbDriver)
        databaseConnection
    }
}
