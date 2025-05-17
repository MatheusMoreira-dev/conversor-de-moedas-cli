import br.com.conversor.api.Request;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        // Coloque aqui sua APIKEY
        final String key =  "SUA_API_KEY";

        Map<String,String> allowed = new LinkedHashMap<>(){{
           put("USD", "Dólar americano");
           put("BRL", "Brasil");
           put("EUR","Euro");
           put("ARS","Peso Argentino");
           put("BOB","Boliviano");
           put("CLP","Peso chileno");
           put("COP","Peso colombiano");
        }};

        String base, target, value;
        Scanner input = new Scanner(System.in);

        byte opcao = 1;
        while (opcao == 1){
            System.out.println("""
                    
                    Conversão de Moedas
                    
                    1 - Iniciar
                    0 - Sair
                    
                    """);
            opcao = input.nextByte();
            if(opcao == 0){
                break;
            }

            System.out.println("Moedas aceitas:");
            System.out.println("--------------------------");

            for (Map.Entry<String, String> pair : allowed.entrySet()) {
                System.out.println(pair.getKey() + " - " + pair.getValue());
            }

            System.out.println("--------------------------");
            System.out.println("Digite a sigla: ");

            System.out.print("De: ");
            base = input.next();

            System.out.print("Para: ");
            target = input.next();

            System.out.print("Montante: ");
            value = input.next();

            if(allowed.containsKey(base) && allowed.containsKey(target)){
                Request request = new Request(key,base,target,value);
                System.out.println("\n" + request.getconversion());
            } else{
                System.out.println("\nEntradas inválidas !");
            }
        }
    }
}