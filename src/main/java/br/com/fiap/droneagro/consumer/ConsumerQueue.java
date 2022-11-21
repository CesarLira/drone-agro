package br.com.fiap.droneagro.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.fiap.droneagro.dto.MessageDto;
import br.com.fiap.droneagro.services.EmailService;

@Component
public class ConsumerQueue {

    @Autowired
    EmailService mailService;

    @RabbitListener(queues = {"${queue.name}"})
    public void receive(@Payload String fileBody)
    {
        MessageDto mensagem = new MessageDto();
        int posicaoFimTemperatura = fileBody.indexOf(":");
        int posicaoFimUmidade = fileBody.lastIndexOf(":");

        mensagem.setTemperatura(Integer.parseInt(fileBody.substring(0, posicaoFimTemperatura)));
        mensagem.setUmidade(Integer.parseInt(fileBody.substring(posicaoFimTemperatura + 1, posicaoFimUmidade)));
        mensagem.setIdDrone(Integer.parseInt(fileBody.substring(posicaoFimUmidade + 1)));

        if(mensagem.getTemperatura() >= 35 || 
            mensagem.getTemperatura() <= 0 || 
            mensagem.getUmidade() <= 15)
        {
            var corpoEmail = "\n === Atencao!!! === \n" +
                "\n O drone de id: " + mensagem.getIdDrone() + ", " +
                "registrou a temperatura : " + mensagem.getTemperatura() +
                "\n e umidade: " + mensagem.getUmidade() +
                ". \nVerificar analise do drone.";
           
            mailService.send("testeaulafiap@gmail.com", "Alerta", corpoEmail);
        }
    }
    
}
