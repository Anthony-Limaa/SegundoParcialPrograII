package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaSushi extends Pizza {
    public PizzaSushi (String name, Topping... toppings){
        super(name, toppings);

        agregarIngrediente("Sushi");
        agregarIngrediente("Salsa de soja");
        agregarIngrediente("Arroz");
        agregarIngrediente("Alga");
        agregarIngrediente("Pescado");
    }
}
