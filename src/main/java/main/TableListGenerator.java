package main;

import bean.ETableType;
import bean.Table;

import java.util.ArrayList;
import java.util.List;

public class TableListGenerator {

    public static List<Table> generateTables(int numSmall, int numMedium, int numLarge) {
        List<Table> tables = new ArrayList<>();
        tables.addAll(generateTableOfSize(numSmall, ETableType.SMALL));
        tables.addAll(generateTableOfSize(numMedium, ETableType.MEDIUM));
        tables.addAll(generateTableOfSize(numLarge, ETableType.LARGE));
        return tables;
    }

    private static List<Table> generateTableOfSize(int numberOfTables, ETableType tableType) {
        List<Table> tables = new ArrayList<>();
        for (int i = 0; i < numberOfTables; i++) {
            Table table = new Table(tableType);
            tables.add(table);
        }
        return tables;
    }

}