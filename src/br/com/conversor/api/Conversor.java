package br.com.conversor.api;

public record Conversor(String base_code, String target_code, String conversion_rate, String conversion_result) {

    @Override
    public String toString() {
        return """
                De: %s | Para: %s
                Taxa de Conversão: %s
                Resultado: %s
                """.formatted(base_code,target_code,conversion_rate, conversion_result);
    }
}