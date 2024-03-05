import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ReciclagemGUI extends JFrame {

    private Map<String, ImageIcon> imagens = new HashMap<>();
    private Map<String, Double> precos = new HashMap<>();

    public ReciclagemGUI() {
        setTitle("Sistema de Reciclagem");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        carregarDados();


        JPanel selecaoMaterialPanel = new JPanel(new FlowLayout());
        selecaoMaterialPanel.setBorder(BorderFactory.createTitledBorder("Selecione o Material"));

        JComboBox<String> materialComboBox = new JComboBox<>(imagens.keySet().toArray(new String[0]));
        materialComboBox.addActionListener(e -> {
            String materialSelecionado = (String) materialComboBox.getSelectedItem();
            if (materialSelecionado != null) {
                ImageIcon imagem = imagens.get(materialSelecionado);
                JLabel imagemLabel = new JLabel(imagem);
                JOptionPane.showMessageDialog(this, imagemLabel, "Imagem do Material", JOptionPane.PLAIN_MESSAGE);
            }
        });
        selecaoMaterialPanel.add(materialComboBox);


        JPanel quantidadePanel = new JPanel(new FlowLayout());
        quantidadePanel.setBorder(BorderFactory.createTitledBorder("Quantidade"));

        JTextField quantidadeField = new JTextField(10);
        quantidadePanel.add(quantidadeField);


        JButton calcularValorVendaButton = new JButton("Calcular Valor de Venda");
        calcularValorVendaButton.addActionListener(e -> {
            String material = (String) materialComboBox.getSelectedItem();
            double quantidade = Double.parseDouble(quantidadeField.getText());
            double valorVenda = calcularValorVenda(material, quantidade);
            JOptionPane.showMessageDialog(this, "O valor de venda é: R$ " + valorVenda, "Valor de Venda", JOptionPane.INFORMATION_MESSAGE);
        });

        mainPanel.add(selecaoMaterialPanel, BorderLayout.NORTH);
        mainPanel.add(quantidadePanel, BorderLayout.CENTER);
        mainPanel.add(calcularValorVendaButton, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private void carregarDados() {
       
        imagens.put("Papelão", new ImageIcon("papelao.jpg"));
        imagens.put("Plástico", new ImageIcon("plastico.jpg"));
        imagens.put("Ferro", new ImageIcon("ferro.jpg"));
        imagens.put("Cobre", new ImageIcon("cobre.jpg"));
        imagens.put("Alumínio", new ImageIcon("aluminio.jpg"));
        imagens.put("Bateria", new ImageIcon("bateria.jpg"));
        imagens.put("Bronze", new ImageIcon("bronze.jpg"));
        imagens.put("Chumbo", new ImageIcon("chumbo.jpg"));
        imagens.put("Metal", new ImageIcon("metal.jpg"));
        imagens.put("Motores", new ImageIcon("motores.jpg"));
        imagens.put("Pneus", new ImageIcon("pneus.jpg"));
        imagens.put("Vidros", new ImageIcon( "vidros.jpg"));
        imagens.put("Madeira", new ImageIcon("madeira.jpg"));




        precos.put("Papelão", 1.0);
        precos.put("Plástico", 0.8);
        precos.put("Ferro", 2.0);
        precos.put("Cobre", 4.0);
        precos.put("Alumínio", 3.5);
        precos.put("Bateria", 5.0);
        precos.put("Bronze", 4.5);
        precos.put("Chumbo", 2.5);
        precos.put("Metal", 3.0);
        precos.put("Motores", 6.0);
        precos.put("Pneus", 2.0);
        precos.put("Vidro", 0.5);
        precos.put("Madeira", 1.5);

    }
    private void exibirImagem(String material, ImageIcon imagem) {
        JLabel imagemLabel = new JLabel(imagem);
        JOptionPane.showMessageDialog(this, imagemLabel, "Imagem do Material: " + material, JOptionPane.PLAIN_MESSAGE);
    }

    private double calcularValorVenda(String material, double quantidade) {
        if (precos.containsKey(material)) {
            double precoUnitario = precos.get(material);
            return quantidade * precoUnitario;
        } else {
            return 0.0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ReciclagemGUI::new);
    }
}

// por algum motivo que não sei, as imagens não estão aparecendo professora