package main;

import bean.*;
import util.MetricsUtility;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class RestaurantMain {

    private static final List<Party> partiesInRestaurant = new ArrayList<>();

    private static void runSimulation() throws InterruptedException {
        Restaurant restaurant = createRestaurant();
        for (int i = 0; i < 3360; i++) {
            incrementWaitTime(restaurant);
            checkIfPartyEntersRestaurant(restaurant);
            decrementTimeForPartiesSeated(restaurant);
            checkIfPartyCanBeSeated(restaurant);
        }
    }

    @NotNull
    private static Restaurant createRestaurant() {
        List<Table> tables = TableListGenerator.generateTables(12, 10, 8);
        Menu menu = MenuGenerator.generateMenu();
        return new Restaurant(tables, menu);
    }

    private static void checkIfPartyCanBeSeated(Restaurant restaurant) {
        List<Table> unoccupiedTables = restaurant.getUnoccupiedTables();
        for (Table table : unoccupiedTables) {
            ETableType tableType = table.getTableType();
            Optional<Party> nextParty = restaurant.getNextParty(tableType);
            nextParty.ifPresent(party -> seatParty(restaurant, table, party));
        }
    }

    private static void seatParty(Restaurant restaurant, Table table, Party nextParty) {
        table.seatParty(nextParty);
        nextParty.generateOrder(restaurant.getMenu());
    }

    private static void decrementTimeForPartiesSeated(Restaurant restaurant) {
        List<Table> occupiedTables = restaurant.getOccupiedTables();
        for (Table table : occupiedTables) {
            table.getParty().decrementTimeLeftToCompletion();
            if (table.getParty().isDone()) {
                table.unseatParty();
            }
        }
    }

    private static void checkIfPartyEntersRestaurant(Restaurant restaurant) {
        Optional<Party> newParty = PartyGenerator.generateParty();
        if (newParty.isPresent()) {
            restaurant.addParty(newParty.get());
            partiesInRestaurant.add(newParty.get());
        }
    }

    private static void incrementWaitTime(Restaurant restaurant) {
        restaurant.incrementPartyWaitTime();
    }

    private static void printStats() {
        MetricsUtility metricsUtility = new MetricsUtility(partiesInRestaurant);
        System.out.println("One week of operation, 8 hours a day, 7 days a week");
        System.out.println("Parties that entered restaurant: " + metricsUtility.totalPartiesThatEnteredRestaurant());
        System.out.println("Parties that got seated: " + metricsUtility.totalPartiesThatGotSeated());
        System.out.println("Average Wait Time for Parties that got seated: " + metricsUtility.averageWaitTimeForPartiesThatGotSeated() + " mins");
        System.out.println("Average Sit Down Time of Parties Who Completed Meals: " + metricsUtility.averageSitDownTimeOfPartiesWhoCompletedMeal() + " mins");
        System.out.println("Average time party spent in restaurant (entrance to completion): " + metricsUtility.averageTotalTimeOfFullJourney() + " mins");
        System.out.println("Distribution of items ordered at restaurant:");
        List<Map<String, Integer>> distributionOfItemsOrdered = metricsUtility.getMealItemDistribution();
        Map<String, Integer> apps = distributionOfItemsOrdered.get(0);
        Map<String, Integer> mains = distributionOfItemsOrdered.get(1);
        Map<String, Integer> desserts = distributionOfItemsOrdered.get(2);
        System.out.println("Appetizers: ");
        System.out.println(MetricsUtility.mapToString(apps) + "\n");
        System.out.println("Mains: ");
        System.out.println(MetricsUtility.mapToString(mains) + "\n");
        System.out.println("Desserts: ");
        System.out.println(MetricsUtility.mapToString(desserts));
        System.out.println("Food Items Used During Time: ");
        Map<String, Integer> foodItemDistribution = metricsUtility.foodItemDistribution();
        System.out.println(MetricsUtility.mapToString(foodItemDistribution));

    }



    public static void main(String[] args) throws InterruptedException {
        runSimulation();
        printStats();
    }

}