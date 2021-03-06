import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import data.CurrentWeatherData.WeatherCurrent;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import java.io.IOException;


public class BotOpenWeather extends TelegramLongPollingBot {

    private static final String TEST_TOKEN = "781159049:AAG-mAOTsMPCXXbL_WZtvHNLtukEpoHymvk";
    private static final String PROM_TOKEN = "1060501754:AAEY18OnlmCX_-1M8hWHH0VKrCfNs38-42o";
    private KeyboardButton keyboardButton = new KeyboardButton();
    private String jsonToString = new String();

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi =  new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new BotOpenWeather());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        try {
            jsonToString = getWeather(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        WeatherCurrent weatherCurrent = getWeatherCurrent(jsonToString);
        //sendMsg(update.getMessage().getChatId().toString(), String.format("Текущая температура: %.2f", weatherCurrent.getMain().getTemp()));
        try{
            sendMsg(update.getMessage().getChatId().toString(), weatherCurrent.getCeurrentWeather());
        } catch (Exception e) {
            sendMsg(update.getMessage().getChatId().toString(), e.toString());
        }

    }

    public synchronized void sendMsg(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void setKeyboardButton(KeyboardButton keyboardButton) {
        keyboardButton.setText("Отправить город или лоакцию");
        this.keyboardButton = keyboardButton;
    }

    public String getBotUsername() {
        return "OpenWeatherTelBot";
    }

    public String getBotToken() {
        return TEST_TOKEN;
    }

    private String getWeather(String message) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        StringBuilder responseBody = new StringBuilder();
        try{
            HttpPost httpPost = new HttpPost("https://api.openweathermap.org/data/2.5/weather?q=" + message + "&lang=ru&units=metric&appid=f21a3c7b8666212985be12084740e603");
            final ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
                    int status = httpResponse.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = httpResponse.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Неожиданный статус ответа: " + status);
                    }
                }
            };
            responseBody.append(httpClient.execute(httpPost, responseHandler));
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpClient.close();
        }
        return responseBody.toString();
    }

    private WeatherCurrent getWeatherCurrent(String json) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        WeatherCurrent weatherCurrent = gson.fromJson(json, WeatherCurrent.class);
        return weatherCurrent;
    }
}