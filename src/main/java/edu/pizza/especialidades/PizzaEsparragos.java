package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaEsparragos extends Pizza {
    public PizzaEsparragos(String name, Topping... toppings) {
        super(name, toppings);

        agregarIngrediente("Esparragos");
        agregarIngrediente("Camarones");
        agregarIngrediente("Salsa");
        agregarIngrediente("Queso");
        agregarIngrediente("Cebolla");
    }
}
