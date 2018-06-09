package testengine.interaction.database

import groovy.sql.GroovyRowResult
import testengine.application.database.Utilities
import testengine.interaction.sharedstate.SharedState

class Lookups {

    static void findSomethingInDatabase () {

        def table = "mytable"


        String sqlString = "select * from '${table}'"

        List<GroovyRowResult> rows = Utilities.pollDatabase (
                SharedState.connection,
                sqlString
        )

        // assert something about rows

    }


}
