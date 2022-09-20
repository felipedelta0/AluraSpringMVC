package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        Pedido pedido = new Pedido();
        pedido.setNomeProduto("PlayStation®5 + Horizon Forbidden West");
        pedido.setUrlImagem("https://m.media-amazon.com/images/I/71A+sWU7zAL._AC_SL1500_.jpg");
        pedido.setUrlProduto("https://www.amazon.com.br/PlayStation-CFI-1114A01X-PlayStation®5-Horizon-Forbidden/dp/B0B3Z4WB52/ref=sr_1_1?__mk_pt_BR=ÅMÅŽÕÑ&crid=1YVKOC9C4VRX1&keywords=playstation+5&qid=1663642249&sprefix=playstation+5%2Caps%2C229&sr=8-1&ufe=app_do%3Aamzn1.fos.25548f35-0de7-44b3-b28e-0f56f3f96147");
        pedido.setDescricao("PlayStation5: O console PS5 oferece novas possibilidades de jogabilidade que você nunca imaginou. Reproduza jogos para PS5 e PS4 em Blu-ray Disc. Além disso, você também pode baixar jogos digitais para PS5 e PS4 pela PlayStation Store. Experimente o carregamento extremamente rápido do SSD de ultra-velocidade, uma imersão mais profunda com suporte à resposta tátil, gatilhos adaptáveis e áudio 3D. Além de uma geração totalmente nova de jogos incríveis PlayStation.");
        pedido.setValorNegociado(new BigDecimal("4464.90"));
        pedido.setDataEntrega(LocalDate.of(2022, 12, 25));

        List<Pedido> pedidos = List.of(pedido);
        model.addAttribute("pedidos", pedidos);

        return "home";
    }
}
