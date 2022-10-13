package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.Oferta;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class RequisicaoNovaOferta {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @NotNull
    private Long pedidoId;

    @NotNull
    @Pattern(regexp = "^\\d+(\\.\\d{1,2})?$")
    private String valorNegociado;

    @NotNull
    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}")
    private String dataEntrega;
    private String comentario;

    public Oferta toOferta() {
        Oferta oferta = new Oferta();
        oferta.setComentario(this.comentario);
        oferta.setDataEntrega(LocalDate.parse(this.dataEntrega, formatter));
        oferta.setValorNegociado(new BigDecimal(this.valorNegociado));
        return oferta;
    }
}
