package main.java.uratelefonica;

import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.Gather;
import com.twilio.twiml.voice.Redirect;
import com.twilio.twiml.voice.Say;

public class CallHandler {
    public static String handleIncomingCall() {
        VoiceResponse voiceResponse = new VoiceResponse.Builder().build();

        // Mensagem de boas-vindas
        Say say = new Say.Builder("Bem-vindo à URA Telefônica. Digite um número de 1 a 9 para selecionar uma opção.")
                .voice(Say.Voice.PT_BR_FEMALE)
                .build();

        // Opções de menu
        Gather gather = new Gather.Builder()
                .numDigits(1) // Apenas 1 dígito será aceito
                .action("http://seu_servidor.com/ura/menu")
                .build();

        gather.append(say);

        voiceResponse.append(gather);

        return voiceResponse.toXml();
    }
}