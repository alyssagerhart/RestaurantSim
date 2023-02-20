package main;

import bean.EType;
import bean.Food;
import bean.Menu;
import bean.MenuItem;
import util.RestaurantUtility;

import java.util.HashMap;
import java.util.Map;


public class MenuGenerator {

    private MenuGenerator() {
    }

    public static Menu generateMenu() {
        Map<MenuItem, Double> appetizers = generateAppetizers();
        Map<MenuItem, Double> mains = generateMains();
        Map<MenuItem, Double> desserts = generateDesserts();
        return new Menu(appetizers, mains, desserts);
    }

    private static Map<MenuItem, Double> generateAppetizers() {

        MenuItem wings = generateWings();
        MenuItem garlicBread =  generategarlicBread();
        MenuItem breadSticks = generatebreadSticks();
        MenuItem meatballs = generateMeatballs();

        Map<MenuItem, Double> appetizerOptions = new HashMap<>();
        appetizerOptions.put(wings, 0.10);
        appetizerOptions.put(garlicBread, 0.35);
        appetizerOptions.put(breadSticks, 0.35);
        appetizerOptions.put(meatballs, 0.2);
        return appetizerOptions;
    }

    private static Map<MenuItem, Double> generateMains() {
        MenuItem fettuccineAlfredo = generatefettuccineAlfredo();
        MenuItem redPepperPasta = generateredPepperPasta();
        MenuItem cheeseRavioli = generateCheeseRavioli();
        MenuItem chickenParm = generateChickenParm();
        MenuItem italainSub = generateitalianSub();
        MenuItem margharitaPizza = generatemargharitaPizza();
        // populate main map with probabilities
        Map<MenuItem, Double> mainOptions = new HashMap<>();
        mainOptions.put(fettuccineAlfredo, 0.15);
        mainOptions.put(redPepperPasta, 0.24);
        mainOptions.put(cheeseRavioli, 0.1);
        mainOptions.put(chickenParm, 0.26);
        mainOptions.put(italainSub, 0.2);
        mainOptions.put(margharitaPizza, 0.05);
        return mainOptions;
    }

    private static Map<MenuItem, Double> generateDesserts() {
        MenuItem cremeBrulee = generateCremeBrulee();
        MenuItem cheesecake = generateCheesecake();
        MenuItem flan = generateflan();
        // populate dessert map with probabilities
        Map<MenuItem, Double> dessertOptions = new HashMap<>();
        dessertOptions.put(cremeBrulee, 0.5);
        dessertOptions.put(cheesecake, 0.35);
        dessertOptions.put(flan, 0.15);

        return dessertOptions;
    }

    private static MenuItem generateflan() {
        Map<Food, Integer> flanIngredients = new HashMap<>();
        flanIngredients.put(new Food("Egg"), 1);
        flanIngredients.put(new Food("Sugar"), 2);
        flanIngredients.put(new Food("Milk"), 1);
        return new MenuItem()
                .withName("Flan")
                .withMealType(EType.DESSERT)
                .withIngredients(flanIngredients)
                .withMinutesToCook(30)
                .withMinutesToEat(15)
                .withProbabilityOfBeingSentBack(0.02)
                .withCostOfMenuItem(1.50);
    }

    private static MenuItem generateCheesecake() {
        Map<Food, Integer> cheesecakeIngredients = new HashMap<>();
        cheesecakeIngredients.put(new Food("Heavy Cream"), 1);
        cheesecakeIngredients.put(new Food("Cheese"), 3);
        cheesecakeIngredients.put(new Food("Egg"), 1);
        cheesecakeIngredients.put(new Food("Vanilla"), 1);
        cheesecakeIngredients.put(new Food("Butter"), 1);
        cheesecakeIngredients.put(new Food("Sugar"), 2);
        cheesecakeIngredients.put(new Food("Graham Cracker"), 1);
        cheesecakeIngredients.put(new Food("Raspberry"), 1);
        return new MenuItem()
                .withName("Cheesecake")
                .withMealType(EType.DESSERT)
                .withIngredients(cheesecakeIngredients)
                .withMinutesToCook(2)
                .withMinutesToEat(15)
                .withProbabilityOfBeingSentBack(0)
                .withCostOfMenuItem(2.65);
    }

    private static MenuItem generateCremeBrulee() {
        Map<Food, Integer> cremeBruleeIngredients = new HashMap<>();
        cremeBruleeIngredients.put(new Food("Heavy Cream"), 2);
        cremeBruleeIngredients.put(new Food("Sugar"), 1);
        cremeBruleeIngredients.put(new Food("Egg"), 1);
        cremeBruleeIngredients.put(new Food("Vanilla"), 1);
        return new MenuItem()
                .withName("Creme Brulee")
                .withMealType(EType.DESSERT)
                .withIngredients(cremeBruleeIngredients)
                .withMinutesToCook(5)
                .withMinutesToEat(15)
                .withProbabilityOfBeingSentBack(0)
                .withCostOfMenuItem(3.10);
    }

    private static MenuItem generatefettuccineAlfredo() {
        Map<Food, Integer> fettuccineAlfredoIngredients = new HashMap<>();
        fettuccineAlfredoIngredients.put(new Food("Alfredo Sauce"), 2);
        fettuccineAlfredoIngredients.put(new Food("Pasta"), 2);
        fettuccineAlfredoIngredients.put(new Food("Basil"), 1);
        fettuccineAlfredoIngredients.put(new Food("Salt"), 1);
        return new MenuItem()
                .withName("Fettuccine Alfredo")
                .withMealType(EType.MAIN)
                .withIngredients(fettuccineAlfredoIngredients)
                .withMinutesToCook(20)
                .withMinutesToEat(15)
                .withProbabilityOfBeingSentBack(0.02)
                .withCostOfMenuItem(4.15);
    }

    private static MenuItem generatemargharitaPizza() {
        Map<Food, Integer> margharitaPizzaIngredients = new HashMap<>();
        margharitaPizzaIngredients.put(new Food("Flour"), 2);
        margharitaPizzaIngredients.put(new Food("Tomatoes"), 1);
        margharitaPizzaIngredients.put(new Food("Herbs"), 1);
        margharitaPizzaIngredients.put(new Food("Cheese"), 1);
        margharitaPizzaIngredients.put(new Food(""), 1);
        margharitaPizzaIngredients.put(new Food("Garlic"), 1);
        return new MenuItem()
                .withName("Margharita Pizza")
                .withMealType(EType.MAIN)
                .withIngredients(margharitaPizzaIngredients)
                .withMinutesToCook(25)
                .withMinutesToEat(10)
                .withProbabilityOfBeingSentBack(0.01)
                .withCostOfMenuItem(3.25);
    }

    private static MenuItem generateChickenParm() {
        Map<Food, Integer> chickenParmIngredients = new HashMap<>();
        chickenParmIngredients.put(new Food("Flour"), 1);
        chickenParmIngredients.put(new Food("Egg"), 1);
        chickenParmIngredients.put(new Food("Chicken"), 3);
        chickenParmIngredients.put(new Food("Cheese"), 5);
        chickenParmIngredients.put(new Food("Tomato"), 1);
        chickenParmIngredients.put(new Food("Garlic"), 1);
        return new MenuItem()
                .withName("Chicken Parmesan")
                .withMealType(EType.MAIN)
                .withIngredients(chickenParmIngredients)
                .withMinutesToCook(30)
                .withMinutesToEat(20)
                .withProbabilityOfBeingSentBack(0)
                .withCostOfMenuItem(5.25);
    }

    private static MenuItem generateCheeseRavioli() {
        Map<Food, Integer> ravioliIngredients = new HashMap<>();
        ravioliIngredients.put(new Food("Flour"), 1);
        ravioliIngredients.put(new Food("Egg"), 1);
        ravioliIngredients.put(new Food("Cheese"), 3);
        ravioliIngredients.put(new Food("Tomato"), 1);
        ravioliIngredients.put(new Food("Garlic"), 1);
        return new MenuItem()
                .withName("Cheese Ravioli")
                .withMealType(EType.MAIN)
                .withIngredients(ravioliIngredients)
                .withMinutesToCook(25)
                .withMinutesToEat(20)
                .withProbabilityOfBeingSentBack(0)
                .withCostOfMenuItem(2.50);
    }

    private static MenuItem generateitalianSub() {
        Map<Food, Integer> italianSubIngredients = new HashMap<>();
        italianSubIngredients.put(new Food("Bread"), 2);
        italianSubIngredients.put(new Food("Cheese"), 4);
        italianSubIngredients.put(new Food("Pepperoni"), 1);
        italianSubIngredients.put(new Food("Ham"), 1);
        italianSubIngredients.put(new Food("Bacon"), 1);
        italianSubIngredients.put(new Food("Tomatoes"), 1);
        italianSubIngredients.put(new Food("Lettuce"), 1);
        return new MenuItem()
                .withName("Italian Sub")
                .withMealType(EType.MAIN)
                .withIngredients(italianSubIngredients)
                .withMinutesToCook(10)
                .withMinutesToEat(15)
                .withProbabilityOfBeingSentBack(0.03)
                .withCostOfMenuItem(5.00);
    }

    private static MenuItem generateredPepperPasta() {
        Map<Food, Integer> PepperPastaIngredients = new HashMap<>();
        PepperPastaIngredients.put(new Food("Pasta"), 3);
        PepperPastaIngredients.put(new Food("Red Peppers"), 2);
        PepperPastaIngredients.put(new Food("Green Peppers"), 2);
        PepperPastaIngredients.put(new Food("Paprika"), 1);
        PepperPastaIngredients.put(new Food("Chicken"), 2);
        PepperPastaIngredients.put(new Food("Tomato"), 1);
        PepperPastaIngredients.put(new Food("Cheese"), 1);
        return new MenuItem()
                .withName("Pepper Pasta")
                .withMealType(EType.MAIN)
                .withIngredients(PepperPastaIngredients)
                .withMinutesToCook(6)
                .withMinutesToEat(8)
                .withProbabilityOfBeingSentBack(0.04)
                .withCostOfMenuItem(4.25);
    }

    private static MenuItem generateWings() {
        Map<Food, Integer> WingsIngredients = new HashMap<>();
        WingsIngredients.put(new Food("Chicken"), 2);
        WingsIngredients.put(new Food("Barbecue"), 1);
        WingsIngredients.put(new Food("Flour"), 1);
        return new MenuItem()
                .withName("Wings")
                .withMealType(EType.APPETIZER)
                .withIngredients(WingsIngredients)
                .withMinutesToCook(15)
                .withMinutesToEat(10)
                .withProbabilityOfBeingSentBack(0.03)
                .withCostOfMenuItem(3.00);
    }

    private static MenuItem generategarlicBread() {
        Map<Food, Integer> garlicBreadIngredients = new HashMap<>();
        garlicBreadIngredients.put(new Food("Bread"), 2);
        garlicBreadIngredients.put(new Food("Garlic"), 1);
        garlicBreadIngredients.put(new Food("Butter"), 1);
        return new MenuItem()
                .withName("Garlic Bread")
                .withMealType(EType.APPETIZER)
                .withIngredients(garlicBreadIngredients)
                .withMinutesToCook(5)
                .withMinutesToEat(5)
                .withProbabilityOfBeingSentBack(0.01)
                .withCostOfMenuItem(1.00);
    }

    private static MenuItem generatebreadSticks() {
        Map<Food, Integer> breadSticksIngredients = new HashMap<>();
        breadSticksIngredients.put(new Food("Bread"), 3);
        breadSticksIngredients.put(new Food("Butter"), 1);
        breadSticksIngredients.put(new Food("Garlic"), 1);
        return new MenuItem()
                .withName("Breadsticks")
                .withMealType(EType.APPETIZER)
                .withIngredients(breadSticksIngredients)
                .withMinutesToCook(8)
                .withMinutesToEat(5)
                .withProbabilityOfBeingSentBack(0.0)
                .withCostOfMenuItem(1.00);
    }

    private static MenuItem generateMeatballs() {
        Map<Food, Integer> MeatballsIngredients = new HashMap<>();
        MeatballsIngredients.put(new Food("Ground Beef"), 4);
        MeatballsIngredients.put(new Food("Marinara Sauce"), 2);
        MeatballsIngredients.put(new Food("Cheese"), 1);
        return new MenuItem()
                .withName("Meatballs")
                .withMealType(EType.APPETIZER)
                .withIngredients(MeatballsIngredients)
                .withMinutesToCook(15)
                .withMinutesToEat(10)
                .withProbabilityOfBeingSentBack(0.02)
                .withCostOfMenuItem(2.75);
    }

    public static void main(String[] args) {
        Menu menu = generateMenu();
        Map<String, Integer> countOfItems = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            MenuItem app = RestaurantUtility.pickItemFromMap(menu.getDesserts());
            if (countOfItems.containsKey(app.getName())) {
                int oldCount = countOfItems.get(app.getName());
                countOfItems.put(app.getName(), oldCount+1);
            } else {
                countOfItems.put(app.getName(), 1);
            }
        }
        countOfItems.forEach((k, v) -> System.out.println(k + ": " + v));
    }

}