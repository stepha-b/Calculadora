 // Maria Jose Sanchez, Karol Bernal Moncada
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame {

    private JTextField display;
    private double num1, num2;
    private String operador;
    private boolean nuevoNumero = true;

    public Calculadora() {
        // Configuración del JFrame
        setTitle("Calculadora Moderna");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(240, 240, 240));  // Fondo gris claro

        // Crear el campo de texto para el display
        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setEditable(false);  // No se permite la edición directa
        display.setBackground(Color.WHITE);
        display.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margen interno
        add(display, BorderLayout.NORTH);

        // Crear panel para los botones
        JPanel buttonPanel = new JPanel(new GridLayout(6, 4, 5, 5)); // Cambiamos a 6 filas y 4 columnas
        buttonPanel.setBackground(new Color(240, 240, 240));  // Fondo gris claro

        // Estilo de los botones
        Font buttonFont = new Font("Arial", Font.BOLD, 18);
        Color buttonColor = new Color(60, 63, 65);  // Color de fondo de los botones
        Color textColor = Color.WHITE;  // Color del texto de los botones

        // Crear botones numéricos y de operaciones
        JButton[] numButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numButtons[i] = crearBoton(String.valueOf(i), buttonFont, buttonColor, textColor);
            int finalI = i; // Variable para usar en ActionListener
            numButtons[i].addActionListener(e -> ingresarNumero(finalI));
        }

        // Botones adicionales para las nuevas funcionalidades
        JButton raizCuadradaBtn = crearBoton("√", buttonFont, buttonColor, textColor);
        raizCuadradaBtn.addActionListener(e -> calcularRaizCuadrada());

        JButton potenciaCuadradoBtn = crearBoton("x²", buttonFont, buttonColor, textColor);
        potenciaCuadradoBtn.addActionListener(e -> calcularPotenciaCuadrado());

        JButton potenciaNBtn = crearBoton("xⁿ", buttonFont, buttonColor, textColor);
        potenciaNBtn.addActionListener(e -> seleccionarOperacion("xⁿ"));

        JButton porcentajeBtn = crearBoton("%", buttonFont, buttonColor, textColor);
        porcentajeBtn.addActionListener(e -> calcularPorcentaje());

        JButton senoBtn = crearBoton("sin", buttonFont, buttonColor, textColor);
        senoBtn.addActionListener(e -> calcularSeno());

        JButton cosenoBtn = crearBoton("cos", buttonFont, buttonColor, textColor);
        cosenoBtn.addActionListener(e -> calcularCoseno());

        JButton tangenteBtn = crearBoton("tan", buttonFont, buttonColor, textColor);
        tangenteBtn.addActionListener(e -> calcularTangente());

        JButton sumaBtn = crearBoton("+", buttonFont, buttonColor, textColor);
        sumaBtn.addActionListener(e -> seleccionarOperacion("+"));

        JButton restaBtn = crearBoton("-", buttonFont, buttonColor, textColor);
        restaBtn.addActionListener(e -> seleccionarOperacion("-"));

        JButton multiplicacionBtn = crearBoton("×", buttonFont, buttonColor, textColor);
        multiplicacionBtn.addActionListener(e -> seleccionarOperacion("×"));

        JButton divisionBtn = crearBoton("÷", buttonFont, buttonColor, textColor);
        divisionBtn.addActionListener(e -> seleccionarOperacion("÷"));

        JButton igualBtn = crearBoton("=", buttonFont, new Color(39, 174, 96), Color.WHITE);
        igualBtn.addActionListener(e -> calcularResultado());

        JButton limpiarBtn = crearBoton("C", buttonFont, new Color(192, 57, 43), Color.WHITE);
        limpiarBtn.addActionListener(e -> limpiar());

        // Añadir botones al panel (6x4 GridLayout)
        buttonPanel.add(raizCuadradaBtn);
        buttonPanel.add(potenciaCuadradoBtn);
        buttonPanel.add(potenciaNBtn);
        buttonPanel.add(porcentajeBtn);

        buttonPanel.add(senoBtn);
        buttonPanel.add(cosenoBtn);
        buttonPanel.add(tangenteBtn);
        buttonPanel.add(sumaBtn);

        buttonPanel.add(numButtons[7]);
        buttonPanel.add(numButtons[8]);
        buttonPanel.add(numButtons[9]);
        buttonPanel.add(restaBtn);

        buttonPanel.add(numButtons[4]);
        buttonPanel.add(numButtons[5]);
        buttonPanel.add(numButtons[6]);
        buttonPanel.add(multiplicacionBtn);

        buttonPanel.add(numButtons[1]);
        buttonPanel.add(numButtons[2]);
        buttonPanel.add(numButtons[3]);
        buttonPanel.add(divisionBtn);

        buttonPanel.add(numButtons[0]);
        buttonPanel.add(limpiarBtn);
        buttonPanel.add(igualBtn);

        

        // Añadir panel de botones al JFrame
        add(buttonPanel, BorderLayout.CENTER);
    }

    // Método para crear un botón con un estilo específico
    private JButton crearBoton(String texto, Font font, Color bgColor, Color textColor) {
        JButton boton = new JButton(texto);
        boton.setFont(font);
        boton.setBackground(bgColor);
        boton.setForeground(textColor);
        boton.setFocusPainted(false); // Quitar borde de enfoque
        boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Bordes más amplios
        return boton;
    }

    // Método para ingresar números al display
    private void ingresarNumero(int numero) {
        if (nuevoNumero) {
            display.setText(String.valueOf(numero));
            nuevoNumero = false;
        } else {
            display.setText(display.getText() + numero);
        }
    }

    // Métodos para las nuevas funcionalidades
    private void calcularRaizCuadrada() {
        double numero = Double.parseDouble(display.getText());
        display.setText(String.valueOf(Math.sqrt(numero)));
    }

    private void calcularPotenciaCuadrado() {
        double numero = Double.parseDouble(display.getText());
        display.setText(String.valueOf(Math.pow(numero, 2)));
    }

    private void calcularPorcentaje() {
        double numero = Double.parseDouble(display.getText());
        display.setText(String.valueOf(numero / 100));
    }

    private void calcularSeno() {
        double numero = Double.parseDouble(display.getText());
        display.setText(String.valueOf(Math.sin(numero))); // Sin en radianes
    }
    
    private void calcularCoseno() {
        double numero = Double.parseDouble(display.getText());
        display.setText(String.valueOf(Math.cos(numero))); // Cos en radianes
    }
    
    private void calcularTangente() {
        double numero = Double.parseDouble(display.getText());
        display.setText(String.valueOf(Math.tan(numero))); // Tan en radianes
    }

    private void seleccionarOperacion(String operador) {
        num1 = Double.parseDouble(display.getText());
        this.operador = operador;
        nuevoNumero = true;
    }

    private void calcularResultado() {
        num2 = Double.parseDouble(display.getText());
        double resultado = 0;

        switch (operador) {
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "×":
                resultado = num1 * num2;
                break;
            case "÷":
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede dividir entre cero.");
                    return;
                }
                break;
            case "xⁿ":
                resultado = Math.pow(num1, num2);
                break;
        }

        display.setText(String.valueOf(resultado));
        nuevoNumero = true;
    }

    private void limpiar() {
        display.setText("");
        num1 = num2 = 0;
        operador = "";
        nuevoNumero = true;
    }

    // Método principal para ejecutar la calculadora
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculadora calculadora = new Calculadora();
            calculadora.setVisible(true);
        });
    }
}