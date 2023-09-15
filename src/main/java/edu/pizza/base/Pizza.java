package edu.pizza.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/*
Ejercicio 1
Crear la clase pizza con los siguientes atributos:
 */
public class Pizza {
    private String name;
    protected List<String> ingredientes = new ArrayList<>();
    private List<Topping> toppings = new ArrayList<>();

    public Pizza(String name,  Topping... toppings) {
        this.name = name;
        for (Topping topping : toppings) {
            this.toppings.add(topping);
        }
    }

    public void removeTopping(int index) {
        this.toppings.remove(index);
    }

    public List<Topping> getToppings() {
        return Collections.unmodifiableList(new ArrayList<>(toppings));
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Pizza{" + "name='" + name + '\'' + ", toppings=" + toppings + '}';
    }

    public void agregarIngrediente(String ingrediente) {
        this.ingredientes.add(ingrediente);
    }

    public void prepare() {
        System.out.println("Preparing..... " + name);
        System.out.println("Adding toppings:");
        for (Topping topping : toppings) {
            System.out.println("- " + topping.getNombre() + " " + topping.getPrecio());
            // Put 1 second delay
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("The Pizza is ready!");
    }
}