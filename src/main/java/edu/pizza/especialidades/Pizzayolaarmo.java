package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class Pizzayolaarmo extends Pizza {
    public Pizzayolaarmo (String name, Topping... toppings){
        super(name,  toppings);

       Topping tp1 = new Topping("Tomato", 10);
         Topping tp2 = new Topping("Cheddar", 8);
            Topping tp3 = new Topping("Mozzarella", 6);
            Topping tp4 = new Topping("Parmesano", 7.50);
            Topping tp5 = new Topping("Jamon", 10);
            Topping tp6 = new Topping("Salame", 8);
            Topping tp7 = new Topping("Aceitunas", 4.50);
            Topping tp8 = new Topping("Cebolla", 5);
            Topping tp9 = new Topping("Champiñones", 6);
            Topping tp10 = new Topping("Carne", 7);
    }
}
