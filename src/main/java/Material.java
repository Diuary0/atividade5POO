
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

   public class Material implements Serializable {
        private String nome;
        private String tipo;
        private String categoria;
        private String descricao;

        private double valorReciclagem;
        public Material(String nome, String tipo, String categoria, String descricao, double valorReciclagem) {
            this.nome = nome;
            this.tipo = tipo;
            this.categoria = categoria;
            this.descricao = descricao;
            this.valorReciclagem = valorReciclagem;

        }

       public String getNome() {
           return nome;
       }

       public void setNome(String nome) {
           this.nome = nome;
       }

       public String getTipo() {
           return tipo;
       }

       public void setTipo(String tipo) {
           this.tipo = tipo;
       }

       public String getCategoria() {
           return categoria;
       }

       public void setCategoria(String categoria) {
           this.categoria = categoria;
       }

       public String getDescricao() {
           return descricao;
       }

       public void setDescricao(String descricao) {
           this.descricao = descricao;
       }

       public double getValorReciclagem() {
           return valorReciclagem;
       }

       public void setValorReciclagem(double valorReciclagem) {
           this.valorReciclagem = valorReciclagem;
       }
   }

