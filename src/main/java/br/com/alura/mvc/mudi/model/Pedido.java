package br.com.alura.mvc.mudi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter
@Entity
public class Pedido {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeProduto;
    private BigDecimal valorNegociado;
    private LocalDate dataEntrega;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    @JsonBackReference
    private User user;

    @Column(columnDefinition = "TEXT")
    private String urlProduto;

    @Column(columnDefinition = "TEXT")
    private String urlImagem;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;
}
