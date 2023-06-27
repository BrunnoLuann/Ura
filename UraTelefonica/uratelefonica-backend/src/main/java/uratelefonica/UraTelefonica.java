package uratelefonica;

import com.twilio.Twilio;
import com.twilio.twiml.VoiceResponse;
import com.twilio.twiml.voice.Gather;
import com.twilio.twiml.voice.Redirect;
import com.twilio.twiml.voice.Say;

import main.java.uratelefonica.CallHandler;

public class UraTelefonica {
    // Credenciais da conta Twilio
    private static final String ACCOUNT_SID = "account_sid";
    private static final String AUTH_TOKEN = "auth_token";
    // Número do telefone configurado no Twilio
    private static final String TWILIO_PHONE_NUMBER = "numero_telefone";

    public static void main(String[] args) {
        // Configuração da conta Twilio
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        // Iniciar a chamada
        CallHandler.handleIncomingCall();

        System.out.println(xmlResponse);
    }

}

    // Método para criar a resposta XML para redirecionamento
    public static String createRedirectResponse() {
        return new VoiceResponse.Builder()
                .redirect(new Redirect.Builder().url("http://seu_servidor.com/ura").build())
                .build()
                .toXml();
    }

    // Método para criar a resposta XML com uma mensagem de voz
    public static String createSayResponse(String message) {
        return new VoiceResponse.Builder()
                .say(new Say.Builder(message).build())
                .build()
                .toXml();
    }
}