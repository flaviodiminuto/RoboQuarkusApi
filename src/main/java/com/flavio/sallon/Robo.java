package com.flavio.sallon;

import com.flavio.sallon.abstracts.AbstractOperacao;
import com.flavio.sallon.abstracts.AbstractRobo;
import com.flavio.sallon.model.RoboConcreteCalculador;
import com.flavio.sallon.model.operacao.Dividir;
import com.flavio.sallon.model.operacao.Multiplicar;
import com.flavio.sallon.model.operacao.Soma;
import com.flavio.sallon.model.operacao.Subtrair;
import jdk.nashorn.internal.objects.annotations.Getter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/robo")
public class Robo {

    AbstractRobo robo = new RoboConcreteCalculador();
    AbstractOperacao concreteOperacao;

    @GET
    @Path("/{nomerobo}/{operacao}")
    @Produces(MediaType.TEXT_PLAIN)
    public String calcular(@PathParam("nomerobo") String nomerobo, @PathParam("operacao") String operacao){
        switch (operacao){
            case "ligar":
                robo.setNome(nomerobo);
                String retorno = robo.ligar();
                if(retorno.contains(nomerobo) || retorno.contains("XPTO")) {
                    return "Ligando " + robo.getNome() + "\n" + retorno;
                }else{
                    return "Falha ao ligar robo!";
                }
            default:
                    return "Operacao não reconhecida!";
        }
    }

    @GET
    @Path("/{nomerobo}/{valor1}/{operacao}/{valor2}")
    @Produces(MediaType.TEXT_PLAIN)
    public String calculoSimples(@PathParam("nomerobo") String nomerobo,
                                 @PathParam("valor1") String a,
                                 @PathParam("operacao") String operacao,
                                 @PathParam("valor2") String b){
        robo.setNome(nomerobo);
        robo.setOperacao(null   );
        switch (operacao){
            case "somar":
                concreteOperacao = new Soma();
                 break;
            case "subtrair":
                concreteOperacao = new Subtrair();
                 break;
            case "multiplicar":
                concreteOperacao = new Multiplicar();
                break;
            case "dividir":
                concreteOperacao = new Dividir();
                break;
            default:
                return "Operação não reconhecida!";
        }

        robo.setOperacao(concreteOperacao);
        try {
            return new StringBuffer(robo.getNome())
                    .append(" Calculando\n")
                    .append("Resultado : ")
                    .append(robo.getOperacao().execute(Double.valueOf(a), Double.valueOf(b))).toString();
        }catch (Exception e){
            return "Valor numérico invãlido";
        }
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String welcome(){
        return "Ligue seu robo";
    }

    @GET
    @Path("{nomerobo}")
    @Produces(MediaType.TEXT_PLAIN)
    public String pedidoLigar(@PathParam("nomerobo") String nomerobo){
        return "Ligue o dispositivo chamado : "+nomerobo;
    }

}