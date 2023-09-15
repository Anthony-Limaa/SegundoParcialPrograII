package edu.formularios;

import edu.pizza.Ingrediente;
import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Menú {
    private JPanel menupizzas;
    private JComboBox comboPizza;
    private JComboBox comboIngredientes;
    private JTextField textField1;
    private JButton botonAgregar;
    private JList listaingredientes;
    private JButton botoneliminar;
    private JLabel lbltotal;
    private JButton botonpreparar;
    private JRadioButton radiopequeña;
    private JRadioButton radiomediana;
    private JRadioButton radiogrande;
    double total = 0;
    double precioPequena = 40;
    double precioMediana = 60;
    double precioGrande = 80;
    double precioseleccionado = 0.0;


    public static void main (String[]args){
        Menú menú = new Menú();
        JFrame frame = new JFrame("Menú");
        frame.setContentPane(menú.menupizzas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setVisible(true);


    }


    public Menú() {


        HashMap<String, List<Ingrediente>> ingredientesPorPizza = new HashMap<>();

        ingredientesPorPizza.put("Pizza de Tacos", Arrays.asList(
                new Ingrediente("Salsa Q.10", 10.0),
                new Ingrediente("Taco Q.8.5", 8.5),
                new Ingrediente("Carne Q.11", 11.0),
                new Ingrediente("Queso Q.8.60", 8.60),
                new Ingrediente("Cebolla Q.7", 7.0)
        ));

        ingredientesPorPizza.put("Pizza de Sushi", Arrays.asList(
                new Ingrediente("Salsa de soja Q.7", 7.0),
                new Ingrediente("Sushi Q.6", 6.0),
                new Ingrediente("Arroz Q.5.55", 5.55),
                new Ingrediente("Alga Q.5", 5.0),
                new Ingrediente("Pescado Q.6", 6.0)
        ));

        ingredientesPorPizza.put("Pizza de Chocolate", Arrays.asList(
                new Ingrediente("Chocolate Q.8", 8.0),
                new Ingrediente("Fresa Q.9", 9.0),
                new Ingrediente("Crema Q.6", 6.0),
                new Ingrediente("Queso Q.8.60", 8.60)
                ));

        ingredientesPorPizza.put("Pizza de Espárragos y Camarones", Arrays.asList(
                new Ingrediente("Espárragos Q.7", 7.0),
                new Ingrediente("Camarones Q.8", 8.0),
                new Ingrediente("Queso Q.8.60", 8.60),
                new Ingrediente("Cebolla Q.7", 7.0)
                ));

        ingredientesPorPizza.put("Pizza YO LA ARMO", Arrays.asList(
                new Ingrediente("Salsa Q.10", 10.0),
                new Ingrediente("Taco Q.8.5", 8.5),
                new Ingrediente("Carne Q.11", 11.0),
                new Ingrediente("Queso Q.8.60", 8.60),
                new Ingrediente("Cebolla Q.7", 7.0),
                new Ingrediente("Salsa de soja Q.7", 7.0),
                new Ingrediente("Sushi Q.6", 6.0),
                new Ingrediente("Arroz Q.5.55", 5.55),
                new Ingrediente("Alga Q.5", 5.0),
                new Ingrediente("Pescado Q.6", 6.0),
                new Ingrediente("Chocolate Q.8", 8.0),
                new Ingrediente("Fresa Q.9", 9.0),
                new Ingrediente("Crema Q.6", 6.0),
                new Ingrediente("Espárragos Q.7", 7.0),
                new Ingrediente("Camarones Q.8", 8.0),
                new Ingrediente("Queso Q.8.60", 8.60),
                new Ingrediente("Cebolla Q.7", 7.0)
        ));


        //Función para agregar las pizzas al combo box.
        comboPizza.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                for (String pizza : ingredientesPorPizza.keySet()) {
                    comboPizza.addItem(pizza);
                }
            }
        });
        radiopequeña.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                precioseleccionado = precioPequena;
                total = precioseleccionado;
            }
        });

        radiomediana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               precioseleccionado = precioMediana;
               total = precioseleccionado;
            }
        });

        radiogrande.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                precioseleccionado = precioGrande;
                total = precioseleccionado;
            }
        });

        //Función para agregar los ingredientes al combo box.
        comboPizza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pizzaSeleccionada = (String) comboPizza.getSelectedItem();
                List<Ingrediente> ingredientesPizza = ingredientesPorPizza.get(pizzaSeleccionada);

                // Borra los ingredientes anteriores
                comboIngredientes.removeAllItems();

                // Agrega los nuevos ingredientes
                if (ingredientesPizza != null) {
                    for (Ingrediente ingrediente : ingredientesPizza) {
                        comboIngredientes.addItem(ingrediente);
                    }
                }
            }
        });


        DefaultListModel<Ingrediente> listModel = new DefaultListModel<>();
        listaingredientes.setModel(listModel);

        //Función para agregar los ingredientes a la lista.
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtén el ingrediente seleccionado en el comboIngredientes
                Ingrediente ingredienteSeleccionado = (Ingrediente) comboIngredientes.getSelectedItem();

                // Verifica que se haya seleccionado un ingrediente
                if (ingredienteSeleccionado != null) {
                    // Agrega el ingrediente al modelo de lista
                    listModel.addElement(ingredienteSeleccionado);

                    // Suma el precio al total actual
                    total += ingredienteSeleccionado.getPrecio();

                    // Actualiza el texto en lbltotal con el nuevo total
                    lbltotal.setText("" +total);
                } else {
                    // Manejar el caso en el que no se haya seleccionado un ingrediente
                    JOptionPane.showMessageDialog(null, "Seleccione un ingrediente primero.");
                }
            }




        });

        //Función para eliminar los ingredientes de la lista.
        botoneliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indiceSeleccionado = listaingredientes.getSelectedIndex();

                if (indiceSeleccionado != -1) {
                    Ingrediente ingredienteEliminado = listModel.getElementAt(indiceSeleccionado);
                    listModel.remove(indiceSeleccionado);

                    // Resta el precio del ingrediente eliminado del total
                    total -= ingredienteEliminado.getPrecio();
                    lbltotal.setText("Total: " + total); // Actualiza el texto en lbltotal
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un ingrediente primero.");
                }
            }
        });

            //Función para poder preparar la pizza.
        botonpreparar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verifica si se ha ingresado un nombre para la pizza
                if (textField1 == null || textField1.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese el nombre de la pizza.");
                    return; // Sale del ActionListener, ya que no se puede preparar la pizza sin una seleccionada.
                }

                    // Verifica si se ha seleccionado una pizza en el comboPizza
                    String pizzaSeleccionada = (String) comboPizza.getSelectedItem();
                    if (pizzaSeleccionada == null || pizzaSeleccionada.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Seleccione una pizza primero.");
                        return; // Sale del ActionListener, ya que no se puede preparar la pizza sin una seleccionada.
                    }

                // Verificar si se ha seleccionado un tamaño de pizza
                if (precioseleccionado == 0.0) {
                    JOptionPane.showMessageDialog(null, "Seleccione un tamaño de pizza primero.");
                    return;
                }

                    // Verifica si se han seleccionado ingredientes en la lista
                    if (listModel.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Agregue al menos un ingrediente a la lista.");
                        return; // Sale del ActionListener, ya que no se pueden preparar pizzas sin ingredientes.
                    }

                    // Construye el mensaje de preparación de la pizza
                    StringBuilder mensajePreparacion = new StringBuilder();
                    mensajePreparacion.append("Preparando pizza de ").append(pizzaSeleccionada).append(":\n");

                    for (int i = 0; i < listModel.size(); i++) {
                        Ingrediente ingrediente = listModel.getElementAt(i);
                        mensajePreparacion.append("- ").append(ingrediente.getNombre()).append("\n");
                    }

                    mensajePreparacion.append("Pizza lista!");

                    // Muestra el mensaje de preparación de la pizza
                    JOptionPane.showMessageDialog(null, mensajePreparacion.toString());


                }


}
        );
        }
    }

















