import java.util.HashMap;
import java.util.Map;
import java.io.*;
public class SistemaReciclagem {
    private static final String FILENAME = "materiais.ser";
    private Map<String, Material> materiais;
    public SistemaReciclagem() {
            this.materiais = new HashMap<>();
            carregarMateriais();
        }
        public void adicionarMaterial(String nome, Material material) {
            materiais.put(nome, material);
            salvarMateriais();
        }
    private void salvarMateriais() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            out.writeObject(materiais);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void carregarMateriais() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILENAME))) {
            Object obj = in.readObject();
            if (obj instanceof Map) {
                materiais = (Map < String, Material> ) obj;
            }
        } catch (IOException | ClassNotFoundException e) {
        }
    }


    public void registrarReciclagem(String nomeMaterial, double peso) {
            if (materiais.containsKey(nomeMaterial)) {
                Material material = materiais.get(nomeMaterial);
                double valorReciclagem = peso * material.getValorReciclagem();
                System.out.println("Reciclagem de " + nomeMaterial + " registrada com sucesso.");
                System.out.println("Valor reciclado: " + valorReciclagem);
            } else {
                System.out.println("Material não encontrado.");
            }
        }
    }




