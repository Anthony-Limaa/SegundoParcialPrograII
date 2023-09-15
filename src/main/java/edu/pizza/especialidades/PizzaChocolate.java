package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaChocolate extends Pizza {
    public PizzaChocolate(String name, Topping... toppings) {
        super(name, toppings);

        agregarIngrediente("Chocolate");
        agregarIngrediente("Crema");
        agregarIngrediente("Fresas");
        agregarIngrediente("Queso");

    }
}

