package restaurant.entities.tables;

import restaurant.common.ExceptionMessages;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static restaurant.common.ExceptionMessages.*;

public abstract class BaseTable implements Table {
    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    public BaseTable(int number, int size, double pricePerPerson) {
        healthyFood = new ArrayList<>();
        beverages = new ArrayList<>();


        this.pricePerPerson = pricePerPerson;
        this.number = number;
        this.setSize(size);


    }

    private void setSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }

        this.size = size;
    }

    @Override
    public int getTableNumber() {
        return number;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int numberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return isReservedTable;
    }

    @Override
    public double allPeople() {
        return allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }

        isReservedTable = true;

        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        if(isReservedTable) {
            healthyFood.add(food);
        }
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        if(isReservedTable) {
            this.beverages.add(beverages);
        }
    }

    @Override
    public double bill() {
        double billForFood = healthyFood.stream()
                .mapToDouble(HealthyFood::getPrice).sum();

        double billForBeverages = beverages.stream()
                .mapToDouble(Beverages::getPrice).sum();

        allPeople = pricePerPerson * numberOfPeople;

        return billForFood + billForBeverages + allPeople;
    }

    @Override
    public void clear() {
        healthyFood.clear();
        beverages.clear();
        allPeople = 0;
        numberOfPeople = 0;
        isReservedTable = false;

    }

    @Override
    public String tableInformation() {
        return String.format("Table - %d" +
                        "Size - %d" +
                        "Type - %s" +
                        "All price - %.2f",
                number,
                size,
                this.getClass().getSimpleName(),
                allPeople
        );
    }
}
