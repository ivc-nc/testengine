package testengine.application.database

import groovy.sql.GroovyRowResult
import groovy.sql.Sql
import groovy.util.logging.Slf4j

@Slf4j
class Utilities {

    final static int MAX_ATTEMPTS = 300
    final static int ATTEMPT_SLEEP_TIME = 100

    /**
     * Poll the database with an sql statement.
     * The statement is executed up to MAX_ATTEMPTS times, until it returns a set of 1 or more rows.
     * Each unsuccesfull attempt means that the test-suite will sleep for a standard given time. (400ms)
     *
     * @param connection The Sql connection to use. From steps this should be SharedState.connection
     * @param sqlString The string to execute as sql query
     * @param maxAttempts The maximum number of attempts before the query "gives up".
     * @return List<GroovyRowResult> A list of rows with the requested data.
     */
    static List<GroovyRowResult> pollDatabase(Sql connection, String sqlString, int maxAttempts = MAX_ATTEMPTS) {

        int attempts = 0
        int resultSize = 0

        List<GroovyRowResult> rows = null

        while (attempts < maxAttempts && resultSize == 0) {
            rows = connection.rows(sqlString)
            resultSize = rows.size()
            attempts++
            Thread.sleep(ATTEMPT_SLEEP_TIME)
        }

        if (!rows) {
            throw new Exception("No result found for Sql query ${sqlString} after ${maxAttempts} attempts (${maxAttempts * ATTEMPT_SLEEP_TIME} ms)")
        } else {

            log.info("Found ${rows.size()} results in the database for: ${sqlString}")

        }

        rows

    }


}
