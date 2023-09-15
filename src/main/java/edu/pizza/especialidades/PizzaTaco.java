package edu.pizza.especialidades;
import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaTaco extends Pizza {
    public PizzaTaco(String name, Topping... toppings) {
        super(name, toppings);

        agregarIngrediente("Taco");
        agregarIngrediente("Salsa");
        agregarIngrediente("Carne");
        agregarIngrediente("Queso");
        agregarIngrediente("Cebolla");
    }



}
