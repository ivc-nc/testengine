package testengine.interaction.database

import groovy.sql.GroovyRowResult
import testengine.application.database.DbUtilities
import testengine.interaction.sharedstate.SharedState

class Lookups {

    /**
     * TODO TO BE CONSIDERED WHEN OUTMESSAGE MESREFID IS MADE UNIQUE
     * This code would also work for messages correlated only by correlation id, since they are connected in same way.
     * @param outMessage
     * @param countryCode
     */
    static void findSomethingInDatabase () {

        def table = "mytable"


        String sqlString = "select * from '${table}'"

        List<GroovyRowResult> rows = DbUtilities.pollDatabase (
                SharedState.connection,
                sqlString
        )

        // assert something about rows

    }


}
